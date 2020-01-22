package config;

import app.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import service.ConsoleReviewService;
import view.ConsoleView;

public class AppConfig {
    
    @Autowired
    static ConsoleReviewService consoleReviewService;
    @Autowired
    static ConsoleView consoleView;

    @Bean
    public App app(){
        return new App(consoleReviewService, consoleView);
    }
}
