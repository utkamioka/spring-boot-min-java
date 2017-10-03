package com.example.kamioka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        System.out.println(Application.class.getPackage().getName() + ".Application.main(" + Arrays.asList(args) + ")");
        SpringApplication.run(Application.class, args);
    }
}
