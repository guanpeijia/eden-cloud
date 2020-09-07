package com.peijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Peijia
 * @className EdenServerTestApplication
 * @desc
 * @create 2020/9/7 10:53
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EdenServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenServerTestApplication.class, args);
    }
}
