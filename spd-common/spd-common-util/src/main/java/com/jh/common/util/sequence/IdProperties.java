package com.jh.common.util.sequence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date
 */
@Configuration
@Slf4j
public class IdProperties {

    @Value("${id.workerId:1}")
    private Long workerId;

    @Value("${id.datacenterId:1}")
    private Long datacenterId;

    @Bean
    public int initIdProperties() {
        log.info("机器id={},服务id={}", workerId, datacenterId);
        Sequence.setId(workerId, datacenterId);
        return 0;
    }
}
