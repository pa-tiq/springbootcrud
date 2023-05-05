package com.dantas.springbootcrud.services.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept())
                .excludePathPatterns(
                        "/login",
                        "/error",
                        "/vendor/**",
                        "/img/**",
                        "/js/**",
                        "/favicon.ico",
                        "/css/**");
    }
}
