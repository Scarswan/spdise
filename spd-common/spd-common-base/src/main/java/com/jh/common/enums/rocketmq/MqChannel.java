package com.jh.common.enums.rocketmq;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MqChannel {
    MQ_CHANNEL_TEST("test_topic_message", "test_producer_message", "test_consumer_message", "测试用消息管道"),
    ;

    private String topic;

    private String producerGroup;

    private String consumerGroup;

    private String desc;
}
