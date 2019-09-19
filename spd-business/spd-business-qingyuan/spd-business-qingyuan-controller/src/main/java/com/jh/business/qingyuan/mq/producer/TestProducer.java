package com.jh.business.qingyuan.mq.producer;

import com.jh.common.enums.rocketmq.MqChannel;
import com.jh.common.rocketmq.IMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestProducer implements CommandLineRunner {
    @Autowired
    private IMqProducer mqProducerImpl;

    @Override
    public void run(String... strings) throws Exception {
        mqProducerImpl.start(MqChannel.MQ_CHANNEL_TEST.getProducerGroup());
    }
}
