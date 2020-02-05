package com.epam.training.bmdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.epam.training.bmdb.app.App;

@Configuration
@ComponentScan("com.epam.training.bmdb")
public class AppConfig {

    @Bean
    public App app(){
        return new App();
    }
}
