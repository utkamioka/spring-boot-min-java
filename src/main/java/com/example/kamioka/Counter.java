package com.example.kamioka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger counter = new AtomicInteger(0);
    public int getCount() {
        return counter.incrementAndGet();
    }

    @Configuration
    public static class CounterBean {
        @Bean
        public Counter getCounter() {
            return new Counter();
        }
    }
}
