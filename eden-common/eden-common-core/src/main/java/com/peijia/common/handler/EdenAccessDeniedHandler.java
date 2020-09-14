package com.peijia.common.handler;

import com.peijia.common.base.BaseResponse;
import com.peijia.common.util.EdenUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author Peijia
 * @className EdenAccessDeniedHandler
 * @desc
 * @create 2020/9/8 9:37
 */
public class EdenAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * Handles an access denied failure.
     *
     * @param request that resulted in an <code>AccessDeniedException</code>
     * @param response so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     * @throws IOException in the event of an IOException
     * @throws ServletException in the event of a ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
        AccessDeniedException accessDeniedException) throws IOException, ServletException {
        BaseResponse baseResponse = new BaseResponse();
        EdenUtil.makeResponse(
            response, MediaType.APPLICATION_JSON_VALUE,
            HttpServletResponse.SC_FORBIDDEN, baseResponse.message("没有权限访问该资源"));
    }
}
