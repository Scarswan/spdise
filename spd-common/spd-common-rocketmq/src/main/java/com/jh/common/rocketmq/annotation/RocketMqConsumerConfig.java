package com.jh.common.rocketmq.annotation;

import com.jh.common.rocketmq.IMqConsumer;
import com.jh.common.rocketmq.impl.MqConsumerImpl;
import org.springframework.context.annotation.Bean;

public class RocketMqConsumerConfig {
    @Bean
    public IMqConsumer mqConsumerImpl() {
        return new MqConsumerImpl();
    }
}
