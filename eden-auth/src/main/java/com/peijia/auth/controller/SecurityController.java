package com.peijia.auth.controller;

import com.peijia.auth.domain.AuthException;
import com.peijia.auth.service.ValidateCodeService;
import com.peijia.common.base.BaseResponse;
import com.peijia.common.exception.ValidateCodeException;
import java.io.IOException;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peijia
 * @className SecurityController
 * @desc 对外提供一些REST服务
 * @create 2020/8/15 20:19
 */
@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public BaseResponse signout(HttpServletRequest request) throws AuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        BaseResponse baseResponse = new BaseResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new AuthException("退出登录失败");
        }
        return baseResponse.message("退出登录成功");
    }
}
