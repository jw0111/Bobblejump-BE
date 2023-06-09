package com.example.bobblejump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BobblejumpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BobblejumpApplication.class, args);
    }

}
