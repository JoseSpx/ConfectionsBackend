package com.josespx.confections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ConfectionsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfectionsApplication.class, args);
    }
}
