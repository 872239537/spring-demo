package com.threeeye.demo.conf;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;

@Component
public class WebMvcInitializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext webApplicationContext =
                new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebMvcConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/manage/*");

        // Session cookie config
        SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
        sessionCookieConfig.setMaxAge(60 * 30); // 30分钟

    }
}
