package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TreasuryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.TreasuryServiceApplication.class, args);
    }

}
