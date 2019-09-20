package com.jh.common.rocketmq;

public interface IMqConsumer {

    void start(String topic, String consumerGroup, IConsumerListener iConsumerListener) throws Exception;

    void shutDown();
}
