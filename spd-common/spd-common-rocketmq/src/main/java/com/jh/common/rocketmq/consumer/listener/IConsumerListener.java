package com.jh.common.rocketmq.consumer.listener;

import java.util.function.Function;

/**
 * @author YangFu
 * @data 2019/08/27  17:16
 * 消息消费回调，接收json格式消息， 返回RetCode.code 000000 表示消费成功 其余为失败 在超过最大失败次数前会重复投递该消息
 */
public interface IConsumerListener extends Function<String, String> {
}
