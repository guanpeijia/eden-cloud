package com.peijia.system.server.control;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peijia
 * @className TestController
 * @desc
 * @create 2020/9/7 9:34
 */
@RestController
public class TestController {

    @GetMapping("info")
    public String test(){
        return "febs-server-system";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
