package com.peijia.server.test.service;

import com.peijia.common.entity.EdenServerConstant;
import com.peijia.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Peijia
 * @className IHelloService
 * @desc IHelloService上通过@FeignClient注解标注表明这是一个Feign Client，该注解的属性含义如下：
 *           value指定远程服务的名称，这个名称对应Eden-Server-System模块配置文件application.yml里spring.application.name的配置，即注册到Eureka里的服务名称；
 *            contextId指定这个Feign Client的别名，当我们定义了多个Feign Client并且value值相同（即调用同一个服务）的时候，需要手动通过contextId设置别名，否则程序将抛出异常；
 *            fallbackFactory指定了回退方法，当我们调用远程服务出现异常时，就会调用这个回退方法。fallback也可以指定回退方法，但fallbackFactory指定的回退方法里可以通过Throwable对象打印出异常日志，方便分析问题。
 * @create 2020/9/17 21:29
 */
@FeignClient(value = EdenServerConstant.EDEN_SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);

}
