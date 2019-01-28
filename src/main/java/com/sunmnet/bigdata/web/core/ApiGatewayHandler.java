package com.sunmnet.bigdata.web.core;

import com.alibaba.fastjson.JSON;
import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ApiGatewayHandler implements InitializingBean,ApplicationContextAware {
    private final String METHOD="method";
    private final String PARAMS="params";

    ApiStore apiStore;
    ParameterNameDiscoverer paramterUtil = null;
    public ApiGatewayHandler(){
        paramterUtil = new LocalVariableTableParameterNameDiscoverer();
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        apiStore.loadApiFromSpringBeans();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        apiStore = new ApiStore(applicationContext);
    }


    public void handle(HttpServletRequest request, HttpServletResponse response){
        String params = request.getParameter(PARAMS);
        Object result = null;
        ApiStore.ApiRunnable apiRun = null;
        try{
            apiRun = sysParamsValdate(request);
            Object[] args = buildParams(apiRun,params,request,response);
            result = apiRun.run(args);
        }
        catch (ApiException ex){
            response.setBufferSize(500);
            result = handleError(ex);
        }
        catch (InvocationTargetException ex){
            response.setBufferSize(500);
            result = handleError(ex);

        }catch (Exception ex){
            response.setBufferSize(500);
            result = handleError(ex);

        }
        returnresult(result,response);
    }
    private Object handleError(Exception e){
        return e.getMessage();
    }
    private void returnresult(Object result,HttpServletResponse response){
        try {
            String json = JSON.toJSONString(result);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html/json;charset=utf-8");
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Pragma","no-cache");
            response.setDateHeader("Expires",0);
            if(StringUtils.isNotEmpty(json)){
                response.getWriter().write(json);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private ApiStore.ApiRunnable sysParamsValdate(HttpServletRequest request) throws ApiException{
        String apiName = request.getParameter(METHOD);
        String json = request.getParameter(PARAMS);
        ApiStore.ApiRunnable api = apiStore.findApiRunnable(apiName);

        if (StringUtils.isEmpty(apiName)) {
            throw new ApiException("调用失败：参数‘method’为空");
        }else if (StringUtils.isEmpty(json)) {
            throw new ApiException("调用失败：参数‘params’为空");
        }else if (api==null) {
            throw new ApiException("调用失败：指定API不存在，API："+apiName);
        }
        return api;
    }

    private Object[] buildParams(ApiStore.ApiRunnable run,String paramJson,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws ApiException {
        Map<String,Object> map = null;
        try {
            map = JSON.parseObject(paramJson,Map.class);
        }catch (IllegalArgumentException ex){
            throw new ApiException("调用失败：josn字符串格式异常，请检查params参数");
        }
        if(map == null){
            map = new HashMap<>();
        }
        Method method = run.getTargetMethod();
        List<String> paramNames = Arrays.asList(paramterUtil.getParameterNames(method));
        Class<?>[] paramTypes = method.getParameterTypes();
        for(Map.Entry<String,Object> m : map.entrySet()){
            if(!paramNames.contains(m.getKey())){
                throw new ApiException("调用失败：接口不存在'"+m.getKey()+"'参数");
            }
        }
        Object[] args = new Object[paramTypes.length];
        for(int i=0;i<paramTypes.length;i++){
            if(paramTypes[i].isAssignableFrom(HttpServletRequest.class)){
                args[i] = request;
            }else if(map.containsKey(paramNames.get(i))){
                try {
                    args[i] = convertJsonToBean(map.get(paramNames.get(i)),paramTypes[i]);
                }catch (Exception e){
                    throw new ApiException("调用失败：指定参数格式错误或值错误'" +
                            paramNames.get(i)+"’" +e.getMessage());
                }
            }else {
                args[i] = null;
            }
        }
        return args;

    }

    private <T> Object convertJsonToBean(Object val,Class<T> targetClass)throws Exception{
        Object result = null;
        if(val == null){
            return null;
        }else if(Integer.class.equals(targetClass)){
            result = Integer.parseInt(val.toString());
        }else if(Long.class.equals(targetClass)){
            result = Long.parseLong(val.toString());
        }else if(Date.class.equals(targetClass)){
            if (val.toString().matches("[0-9]+")){
                result = new Date(Long.parseLong(val.toString()));
            }else{
                throw new IllegalArgumentException("日期必须是长整形的时间戳");
            }
        }else if(String.class.equals(targetClass)){
            if(val instanceof String){
                result = val;
            }else{
                throw new IllegalArgumentException("转换目标类型为字符串");
            }
        }else {
            result = JSON.parseObject(val.toString(),targetClass);
        }
        return result;
    }

}
