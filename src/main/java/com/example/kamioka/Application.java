package com.example.kamioka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Arrays;
import java.util.Locale;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println(Application.class.getPackage().getName() + ".Application.main(" + Arrays.asList(args) + ")");
        SpringApplication.run(Application.class, args);
    }

//    // NG: Accept-Languageに何を指定しても"en-US"にしかならない
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(Locale.US);
//        return localeResolver;
//    }
}
