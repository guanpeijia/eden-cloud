package com.peijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Peijia
 * @className EdenServerSystemApplication
 * @desc @EnableGlobalMethodSecurity(prePostEnabled = true)注解，表示开启Spring Cloud Security权限注解
 * @create 2020/9/6 19:25
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EdenServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenServerSystemApplication.class, args);
    }
}
