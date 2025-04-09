package com.example.projectcoding0.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")      // Allow all paths to cross domains
                        .allowedOrigins("http://localhost:5173")    // Allowed front-end sources
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                        .allowedHeaders("*")    // Allow all Headers
                        .exposedHeaders("Authorization")
                        .allowCredentials(true);    // Allow Cookies or authentication information
            }
        };
    }
}

