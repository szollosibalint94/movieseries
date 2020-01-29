package com.epam.training.bmdb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.epam.training.bmdb.*")
public class AppSpring {
    public static void main(String[] args) {
        SpringApplication.run(AppSpring.class, args);
    }
}
