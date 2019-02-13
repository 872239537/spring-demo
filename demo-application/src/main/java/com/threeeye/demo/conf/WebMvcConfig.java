/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.threeeye.demo.conf;

import com.threeeye.framework.conf.FrameworkWebMvcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.List;


@Configuration
@EnableSwagger2
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Resource
//    private ApplicationContext ctx;
//
//    @Override
//    protected void initApiInfo() {
//        String title = "西南医科大学后台管理平台接口";
//        String description = "西南医科大学-后台管理平台接口API";
//
//        setTitle(title);
//        setDescription(description);
//    }
//
////    /***
////     * 添加其权限注入拦截
////     * @param registry
////     */
////    @Override
////    public void addInterceptors(InterceptorRegistry registry){
////        if (!this.isdebug) {
////            super.addInterceptors(registry);
////            List<String> list = new ArrayList();
////            list.add("/login");
////            setExcludePathPatterns(list);
////            String[] strings = new String[list.size()];
////            list.toArray(strings);
////            registry.addInterceptor((HandlerInterceptor) this.ctx.getBean(PemInterceptor.class))
////                    .addPathPatterns(new String[]{"/**"}).excludePathPatterns(strings);
////        }
////    }
//
//    @Override
//    protected void initApiInfo(ResourceHandlerRegistry registry) {
//        String swaggerPath="swagger/swagger-ui.html";
//        setSwaggerPath(swaggerPath);
//    }
//
//    @Override
//    protected void setExcludePathPatterns(List<String> list){
//        list.add("/swagger-ui.html");
//        list.add("/swagger-ui.html/*");
//        list.add("/swagger-resources");
//        list.add("/swagger-resources/**");
//        list.add("/webjars/**");
//    }
//
//    @Override
//    protected void initSwaggerBasePackage(List<String> list){
//        list.add("com.sunmnet.admin.controller" );
//    }
}
