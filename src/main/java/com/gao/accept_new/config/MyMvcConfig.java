package com.gao.accept_new.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //添加视图控制




    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/admin.html").setViewName("admin");
        registry.addViewController("/main.html").setViewName("dashboard");

    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:/home/uploads/");
//    }

//    @Bean
//    public LocalResolver localResolver(){
//
//    }
//
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

           //Windows下
          registry.addResourceHandler("/uploads/**").addResourceLocations("file:/home/uploads/");

          WebMvcConfigurer.super.addResourceHandlers(registry);
       }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/index","/","/user/login","/css/*","/js/**","/","/admin.html","/emp","/success","/uploads/**");
    }
}
