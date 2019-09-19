package com.jh.common.rocketmq.annotation;

import com.jh.common.rocketmq.IMqProducer;
import com.jh.common.rocketmq.impl.MqProducerImpl;
import org.springframework.context.annotation.Bean;

public class RocketMqProducerConfig {
    @Bean
    public IMqProducer mqProducerImpl() {
        return new MqProducerImpl();
    }
}
