package com.entelgy.backendchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackendchallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendchallengeApplication.class, args);
    }

}
