package com.peijia.server.test.configure;

import com.alibaba.fastjson.JSONObject;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

/**
 * @author Peijia
 * @className LoggableDispatcherServlet
 * @desc
 * @create 2021/4/20 17:48
 */
public class LoggableDispatcherServlet extends DispatcherServlet {

    private static final Logger logger = LoggerFactory.getLogger("HttpLogger");


    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        //创建一个 json 对象，用来存放 http 日志信息
        JSONObject rootNode = new JSONObject();
        rootNode.put("uri", requestWrapper.getRequestURI());
        rootNode.put("clientIp", requestWrapper.getRemoteAddr());
        rootNode.put("requestHeaders", getRequestHeaders(requestWrapper));
        String method = requestWrapper.getMethod();
        rootNode.put("method", method);
        try {
            super.doDispatch(requestWrapper, responseWrapper);
        } finally {
            if(method.equals("GET")) {
                rootNode.put("request", requestWrapper.getParameterMap());
            } else {
                JSONObject newNode = new JSONObject();
                rootNode.put("request", newNode);
            }

            rootNode.put("status", responseWrapper.getStatus());
       /*     JsonNode newNode = mapper.readTree(responseWrapper.getContentAsByteArray());
            rootNode.set("response", newNode);*/

            responseWrapper.copyBodyToResponse();

            /*rootNode.set("responseHeaders", mapper.valueToTree(getResponsetHeaders(responseWrapper)));*/
            logger.info(rootNode.toString());
        }
    }

    private Map<String, Object> getRequestHeaders(HttpServletRequest request) {
        Map<String, Object> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;

    }

    private Map<String, Object> getResponsetHeaders(ContentCachingResponseWrapper response) {
        Map<String, Object> headers = new HashMap<>();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            headers.put(headerName, response.getHeader(headerName));
        }
        return headers;
    }
}