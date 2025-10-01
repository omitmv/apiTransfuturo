package com.transfuturo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.transfuturo.entity")
@EnableJpaRepositories("com.transfuturo.repository")
public class ApiTransfuturoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTransfuturoApplication.class, args);
    }
}
