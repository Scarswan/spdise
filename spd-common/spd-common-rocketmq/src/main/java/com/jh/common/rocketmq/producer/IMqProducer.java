package com.jh.common.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;

public interface IMqProducer {

    /**
     * 启动生产者
     *
     * @param producerGroup 生产者群组
     */
    void start(String producerGroup) throws MQClientException;

    /**
     * 发送消息  统一为String类型
     *
     * @param msg
     * @return
     */
    SendResult sendMsg(String topic, String msg);

    /**
     * 关闭生产者
     */
    void shutDown();

}
