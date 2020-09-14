package com.peijia.common.handler;

import com.peijia.common.base.BaseResponse;
import com.peijia.common.util.EdenUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author Peijia
 * @className EdenAuthExceptionEntryPoint
 * @desc
 * @create 2020/9/7 21:40
 */
public class EdenAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException {
        BaseResponse baseResponse = new BaseResponse();
        EdenUtil.makeResponse(
            response, MediaType.APPLICATION_JSON_VALUE,
            HttpServletResponse.SC_UNAUTHORIZED, baseResponse.message("token无效")
        );
    }
}
