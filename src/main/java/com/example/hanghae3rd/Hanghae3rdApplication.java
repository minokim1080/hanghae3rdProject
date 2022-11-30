package com.example.hanghae3rd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hanghae3rdApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hanghae3rdApplication.class, args);
    }

}
