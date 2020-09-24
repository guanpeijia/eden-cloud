package com.peijia;

import com.peijia.common.annotation.EnableEdenServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Peijia
 * @className EdenGatewayApplication
 * @desc 网关启动类  @EnableDiscoveryClient注解，开启服务注册与发现，
 *                  添加@EnableZuulProxy注解，开启Zuul服务网关功能
 * @create 2020/9/6 17:25
 */
@EnableEdenServerProtect
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class EdenGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdenGatewayApplication.class, args);
    }
}
