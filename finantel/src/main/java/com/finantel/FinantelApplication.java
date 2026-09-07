package com.finantel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FinantelApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinantelApplication.class, args);
    }
}