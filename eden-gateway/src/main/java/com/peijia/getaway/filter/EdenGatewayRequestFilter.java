package com.peijia.getaway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.peijia.common.base.BaseResponse;
import com.peijia.common.entity.Constants;
import com.peijia.common.util.EdenUtil;
import com.peijia.getaway.properties.GatewayProperties;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Base64Utils;

/**
 * @author Peijia
 * @className EdenGatewayRequestFilter
 * @desc 访问服务只能服务网关 禁止直接访问服务
 * @create 2020/9/18 10:13
 */
@Slf4j
@Component
public class EdenGatewayRequestFilter  extends ZuulFilter {

    @Autowired
    private GatewayProperties properties;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 对应Zuul生命周期的四个阶段：pre、post、route和error，我们要在请求转发出去前添加请求头，所以这里指定为pre
     * @return Zuul生命周期
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器的优先级，数字越小，优先级越高。PreDecorationFilter过滤器的优先级为5，所以我们可以指定为6让我们的过滤器优先级比它低；
     * @return 过滤器的优先级
     */
    @Override
    public int filterOrder() {
        return 6;
    }

    /**
     * 方法返回boolean类型，true时表示是否执行该过滤器的run方法，false则表示不执行
     * @return 是否执行该过滤器的run方法
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 定义过滤器的主要逻辑
     * @return null
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        HttpServletRequest request = ctx.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);

        // 禁止外部访问资源实现
        /*
         * 从配置文件里读取到禁止外部访问资源的链接，并以逗号分隔转换为数组。
         * 遍历这些数组，逐一判断客户端请求URI是否在禁止外部访问的范围内，
         * 如果是的话则返回“该URI不允许外部访问”响应，状态码为403，不是的话放行
         */
        boolean shouldForward = true;
        String forbidRequestUri = properties.getForbidRequestUri();
        String[] forbidRequestUris = StringUtils
            .splitByWholeSeparatorPreserveAllTokens(forbidRequestUri, ",");
        if (ArrayUtils.isNotEmpty(forbidRequestUris)) {
            for (String u : forbidRequestUris) {
                if (pathMatcher.match(u, uri)) {
                    shouldForward = false;
                }
            }
        }
        if (!shouldForward) {
            HttpServletResponse response = ctx.getResponse();
            BaseResponse febsResponse = new BaseResponse().message("该URI不允许外部访问");
            try {

                EdenUtil.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_FORBIDDEN, febsResponse
                );
                ctx.setSendZuulResponse(false);
                ctx.setResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        byte[] token = Base64Utils.encode((Constants.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(Constants.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }
}
