package com.luxuriem.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ApplicationConfig.class})
public class UsersJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersJavaApplication.class, args);
    }
}
