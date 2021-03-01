package com;

import com.peijia.common.annotation.EnableEdenAuthExceptionHandler;
import com.peijia.common.annotation.EnableEdenServerProtect;
import com.peijia.common.redis.EnableLettuceRedis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Peijia
 */
@EnableEdenServerProtect
@EnableDiscoveryClient
@EnableEdenAuthExceptionHandler
@EnableLettuceRedis
@SpringBootApplication
@MapperScan("com.peijia.auth.*.mapper")
public class EdenAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenAuthApplication.class, args);
    }

}
