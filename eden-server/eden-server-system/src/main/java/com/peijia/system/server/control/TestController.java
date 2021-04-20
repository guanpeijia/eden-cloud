package com.peijia.system.server.control;

import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peijia
 * @className TestController
 * @desc
 * @create 2020/9/7 9:34
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("info")
    public String test(){
        return "eden-server-system";
    }

    @GetMapping("currentUser")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String hello(String name) {
        log.info("/hello服务被调用");
        return "hello" + name;
    }
}
