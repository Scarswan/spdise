package com.jh.api.qingyuan.fallbackfactory;

import com.jh.api.qingyuan.TeacherClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TeacherClientFallbackFactory implements FallbackFactory<TeacherClient> {
    private static Logger logger = LoggerFactory.getLogger(TeacherClientFallbackFactory.class);

    @Override
    public TeacherClient create(Throwable throwable) {
        logger.error("QingYuan服务调用失败", throwable);
        return new TeacherClient() {
        };
    }
}
