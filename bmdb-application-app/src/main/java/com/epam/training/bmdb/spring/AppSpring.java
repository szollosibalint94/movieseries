package com.epam.training.bmdb.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.training.bmdb.app.App;
import com.epam.training.bmdb.config.AppConfig;

public class AppSpring {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);
            app.play();
        }
    }
}
