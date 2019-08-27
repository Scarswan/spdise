package com.jh.common.rocketmq.producer.impl;

import com.jh.common.rocketmq.producer.IMqProducer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;

public class MqProducerImpl implements IMqProducer {

    @Override
    public void start(String producerGroup) throws MQClientException {

    }

    @Override
    public SendResult sendMsg(String topic, String msg) {
        return null;
    }

    @Override
    public void shutDown() {

    }
}
