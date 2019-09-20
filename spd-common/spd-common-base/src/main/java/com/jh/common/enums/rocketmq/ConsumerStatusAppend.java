package com.jh.common.enums.rocketmq;

/**
 * @data 消费状态补充
 */
public enum ConsumerStatusAppend {

    //消费成功
    CONSUMER_SUCCESS,
    //过一段时间再次投递该消息
    RECONSUMER_LATER,
    //已消费过 放弃消费
    CONSUMER_CONSUMED,
    //消费次数达到次数上限 放弃消费
    CONSUMER_REACH_MAX;

    private ConsumerStatusAppend() {
    }
}
