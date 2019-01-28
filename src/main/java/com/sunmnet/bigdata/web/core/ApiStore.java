package com.sunmnet.bigdata.web.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ApiStore {
    private ApplicationContext applicationContext;
    private HashMap<String,ApiRunnable> apiMap = new HashMap<>();

    public ApiStore(ApplicationContext applicationContext){
        Assert.notNull(applicationContext);
        this.applicationContext = applicationContext;
    }

    public void loadApiFromSpringBeans(){
        String[] names = applicationContext.getBeanDefinitionNames();
        Class<?> type;
        for(String name:names){
            type=applicationContext.getType(name);
            for(Method m : type.getDeclaredMethods()){
                APIMapping apiMapping = m.getAnnotation(APIMapping.class);
                if(apiMapping!=null){
                    addApiItem(apiMapping,name,m);
                }
            }
        }
    }

    public ApiRunnable findApiRunnable(String apiName ) {return apiMap.get(apiName );}

    private void addApiItem(APIMapping apiMapping,String beanName,Method method){
        ApiRunnable apiRun = new ApiRunnable ();
        apiRun.apiName = apiMapping.value();
        apiRun.targetMethod = method;
        apiRun.targetName = beanName;
        apiMap.put(apiRun.apiName,apiRun);
    }

    public ApiRunnable findApiRunnable(String apiName,String version){
        return (ApiRunnable)apiMap.get(apiName+"_"+version);
    }
    public List<ApiRunnable> findApiRunnables(String apiName){
        if(StringUtils.isEmpty(apiName)){
            throw new IllegalArgumentException("api name must not null");
        }
        List<ApiRunnable> apiRunnables = new ArrayList<>();
        for(ApiRunnable apiRunnable: apiMap.values()){
            if(apiName.equals(apiRunnable.apiName)){
                apiRunnables.add(apiRunnable);
            }
        }
        return apiRunnables;
    }

    public List<ApiRunnable> getAll(){
        List<ApiRunnable> apiRunnables = new ArrayList<>();
        apiRunnables.addAll(apiMap.values());
        Collections.sort(apiRunnables, new Comparator<ApiRunnable>() {
            @Override
            public int compare(ApiRunnable o1, ApiRunnable o2) {
                return o1.getApiName().compareTo(o2.getApiName());
            }
        });
        return apiRunnables;
    }

    public class ApiRunnable {

        String apiName;
        String targetName;
        Object target;
        Method targetMethod;

        public Object run(Object... args) throws InvocationTargetException, IllegalAccessException {
            if(target==null){
                target = applicationContext.getBean(targetName);
            }
            return targetMethod.invoke(target,args);
        }


        public Class<?>[] getParmTypes(){
            return targetMethod.getParameterTypes();
        }

        public String getApiName() {
            return apiName;
        }

        public void setApiName(String apiName) {
            this.apiName = apiName;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

        public Object getTarget() {
            return target;
        }

        public void setTarget(Object target) {
            this.target = target;
        }

        public Method getTargetMethod() {
            return targetMethod;
        }

        public void setTargetMethod(Method targetMethod) {
            this.targetMethod = targetMethod;
        }
    }
}
