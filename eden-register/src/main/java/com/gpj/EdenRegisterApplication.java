package com.gpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EdenRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenRegisterApplication.class, args);
    }

}
