package com.example.shoaib.domytask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DoMyTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoMyTaskApplication.class, args);
    }

}
