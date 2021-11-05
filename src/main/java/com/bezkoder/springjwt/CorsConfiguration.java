package com.bezkoder.springjwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET" ,"DELETE","PUT", "POST" , "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
}
