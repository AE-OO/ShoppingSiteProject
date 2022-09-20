package com.example.boardproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //TODO [resources >> static >> 리소스 연결]

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:C://JavaProgramming/_project/myImage/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}