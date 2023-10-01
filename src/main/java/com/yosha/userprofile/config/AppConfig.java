package com.yosha.userprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter();
    }
}
