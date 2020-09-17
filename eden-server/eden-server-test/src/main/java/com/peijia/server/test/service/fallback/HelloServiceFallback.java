package com.peijia.server.test.service.fallback;

import com.peijia.server.test.service.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Peijia
 * @className HelloServiceFallback
 * @desc
 * @create 2020/9/17 21:36
 */
@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IHelloService> {

    /**
     * Returns an instance of the fallback appropriate for the given cause
     *
     * @param cause corresponds to {@link AbstractCommand#getExecutionException()} often, but not
     * always an instance of {@link FeignException}.
     */
    @Override
    public IHelloService create(Throwable cause) {
        return name -> {
            log.error("调用eden-server-system服务出错", cause);
            return "调用出错";
        };
    }
}
