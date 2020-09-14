package com;

import com.peijia.common.annotation.EnableEdenAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Peijia
 */
@EnableDiscoveryClient
@EnableEdenAuthExceptionHandler
@SpringBootApplication
public class EdenAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenAuthApplication.class, args);
    }

}
