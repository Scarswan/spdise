package com.jh.common.rocketmq.consumer;

public interface IMqConsumer {

    void start(String topic, String consumerGroup) throws Exception;

    void shutDown();

}
