package com.peijia.getaway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.peijia.common.entity.Constants;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
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

        byte[] token = Base64Utils.encode((Constants.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(Constants.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }
}
