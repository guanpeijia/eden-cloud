package com.peijia.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.peijia.common.base.BaseResponse;
import com.peijia.common.entity.Constants;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Peijia
 * @className EdenServerProtectInterceptor
 * @desc
 * @create 2020/9/18 10:28
 */
public class EdenServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(Constants.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(Constants.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            BaseResponse baseResponse = new BaseResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSON.toJSONString(baseResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}
