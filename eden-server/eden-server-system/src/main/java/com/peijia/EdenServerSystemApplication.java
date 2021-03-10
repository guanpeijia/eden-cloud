package com.peijia;

import com.peijia.common.annotation.EdenCloudApplication;
import com.peijia.common.annotation.EnableEdenServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Peijia
 * @className EdenServerSystemApplication
 * @desc @EnableGlobalMethodSecurity(prePostEnabled = true)注解，表示开启Spring Cloud Security权限注解
 * @create 2020/9/6 19:25
 */
@EnableFeignClients
@EdenCloudApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@EnableEdenServerProtect
@MapperScan("com.peijia.system.server.*.mapper")
public class EdenServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenServerSystemApplication.class, args);
    }
}
