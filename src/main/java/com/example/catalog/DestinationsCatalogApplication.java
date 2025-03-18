package com.example.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.catalog    ")
@EnableJpaRepositories(basePackages = "com.example.catalog.repository")
public class DestinationsCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(DestinationsCatalogApplication.class, args);
    }
}
