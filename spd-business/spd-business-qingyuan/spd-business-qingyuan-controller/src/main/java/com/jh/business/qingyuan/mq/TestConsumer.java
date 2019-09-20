package com.jh.business.qingyuan.mq;

import com.jh.common.enums.rocketmq.MqChannel;
import com.jh.common.enums.RetCode;
import com.jh.common.rocketmq.IMqConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(TestConsumer.class);

    @Autowired
    private IMqConsumer mqConsumerImpl;

    @Override
    public void run(String... args) throws Exception {
        mqConsumerImpl.start(MqChannel.MQ_CHANNEL_TEST.getTopic(), MqChannel.MQ_CHANNEL_TEST.getConsumerGroup(), msg -> {
            try {
                logger.info("RocketMq 回调消息=========================>" + msg);
            } catch (Exception e) {
                logger.error("新增回调，新增教师信息异常", e);
                throw e;
            }
            return RetCode.SUCCESS.getCode();
        });
    }
}
