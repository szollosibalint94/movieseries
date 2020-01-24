package com.epam.training.bmdb.config;

import com.epam.training.bmdb.app.App;
import com.epam.training.bmdb.app.I18N;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Locale;

import javax.inject.Inject;

@Configuration
@Import({I18NConfig.class})
@ComponentScan("com.epam.training.bmdb")
public class AppConfig {
    @Value("hu")
    private Locale locale;

    @Bean
    public App app(){
        return new App();
    }

    @Bean
    public I18N i18N(){
        I18N i18N=new I18N();
        getMessages(i18N);
        return i18N;
    }

    @Inject
    private MessageSource messageSource;

    private void getMessages(I18N i18N){
        i18N.averageRating=messageSource.getMessage("averageRating", null, locale);
        i18N.badRating=messageSource.getMessage("badRating", null, locale);
        i18N.chooseId=messageSource.getMessage("chooseId", null, locale);
        i18N.chooseRatingMessage=messageSource.getMessage("chooseRatingMessage", null, locale);
        i18N.emailMessage=messageSource.getMessage("emailMessage", null, locale);
        i18N.goodRating=messageSource.getMessage("goodRating", null, locale);
        i18N.otherReviewMessage=messageSource.getMessage("otherReviewMessage", null, locale);
        i18N.otherReviewYes=messageSource.getMessage("otherReviewYes", null, locale);
        i18N.passWordMessage=messageSource.getMessage("passWordMessage", null, locale);
        i18N.registerMessage =messageSource.getMessage("registerMessage", null, locale);
        i18N.reviewAverage=messageSource.getMessage("reviewAverage", null, locale);
        i18N.welcomeMessage=messageSource.getMessage("welcomeMessage", null, locale);
        i18N.writeReview=messageSource.getMessage("writeReview", null, locale);
        i18N.yourNameMessage=messageSource.getMessage("yourNameMessage", null, locale);
    }
}
