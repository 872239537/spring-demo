package com.threeeye.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.threeeye.expands.api.ApiGatewayHandler;
import com.threeeye.expands.api.ApiGatewayServlet;
import com.threeeye.expands.protocol.ExtFastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;


@Controller
@EnableWebMvc
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
@ComponentScan(basePackages = {"com.threeeye.demo","com.threeeye.framework.exception.handler"})
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动完成!");
    }

    @Bean
    public ApiGatewayHandler apiGatewayHandler(){
        return new ApiGatewayHandler();
    }

    @Bean
    public ServletRegistrationBean MyServlet1(){
        return new ServletRegistrationBean(new ApiGatewayServlet(),"/api/*");
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<>();
        httpMessageConverterList.add(fastJsonHttpMessageConverter());
        requestMappingHandlerAdapter.setMessageConverters(httpMessageConverterList);
        return requestMappingHandlerAdapter;
    }

    @Bean
    public ExtFastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        ExtFastJsonHttpMessageConverter fastJsonHttpMessageConverter = new ExtFastJsonHttpMessageConverter();
        return fastJsonHttpMessageConverter;
    }
}
