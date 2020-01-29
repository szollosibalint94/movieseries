package com.epam.training.bmdb.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.epam.training.bmdb.*")
public class AppSpringWeb {
    public static void main(String[] args) {
        SpringApplication.run(AppSpringWeb.class, args);
    }
}
