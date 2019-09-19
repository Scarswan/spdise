package com.jh.common.rocketmq.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MapperScan("com.jh.common.rocketmq.mapper")
@Import(RocketMqProducerConfig.class)
public @interface EnableRocketMqProducer {
}
