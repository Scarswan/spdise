package com.jh.api.qingyuan.fallbackfactory;

import com.jh.api.qingyuan.ClazzClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ClazzClientFallbackFactory implements FallbackFactory<ClazzClient> {
    private static Logger logger = LoggerFactory.getLogger(ClazzClientFallbackFactory.class);

    @Override
    public ClazzClient create(Throwable throwable) {
        logger.error("QingYuan服务调用失败", throwable);
        return new ClazzClient() {
        };
    }
}
