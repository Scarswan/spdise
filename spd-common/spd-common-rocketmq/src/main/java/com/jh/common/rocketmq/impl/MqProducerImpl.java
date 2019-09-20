package com.jh.common.rocketmq.impl;

import com.alibaba.fastjson.JSON;
import com.jh.common.constants.MqConstants;
import com.jh.common.enums.rocketmq.MqDelayTimeLevelEnum;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.model.rocketmq.RocketMqMessage;
import com.jh.common.rocketmq.mapper.RocketMqMessageMapper;
import com.jh.common.rocketmq.IMqProducer;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import java.util.Objects;

@Scope("prototype")
public class MqProducerImpl implements IMqProducer {
    private Logger logger = LoggerFactory.getLogger(MqProducerImpl.class);

    @Value("${spdise.rocketMq.nameServerAddr}")
    public String nameServerAddr;

    @Value("${spdise.rocketMq.producerMaxRetryCount}")
    public int maxRetryCount;

    @Autowired
    private RocketMqMessageMapper rocketMqMessageMapper;

    private String producerGroup;

    private DefaultMQProducer defaultMQProducer;

    @Override
    public void start(String producerGroup) throws MQClientException {
        this.producerGroup = producerGroup;
        defaultMQProducer = new DefaultMQProducer(producerGroup);
        defaultMQProducer.setNamesrvAddr(nameServerAddr);
        defaultMQProducer.start();
    }

    @Override
    public SendResult sendMsg(String topic, String msg) {
        return sendDelayedMsg(topic, msg, null);
    }

    @Override
    public SendResult sendDelayedMsg(String topic, String msg, MqDelayTimeLevelEnum mqDelayTimeLevelEnum) {
        try {
            logger.info(String.format("RocketMq 消息队列开始往主题 %s 发送消息 %s", topic, msg));
            RocketMqMessage rocketMqMessage = new RocketMqMessage();
            rocketMqMessage.setRocketmqMessageId(Sequence.createId());
            rocketMqMessage.setCreateTime(DateUtil.getCurrentTimeString());
            rocketMqMessage.setUpdateTime(DateUtil.getCurrentTimeString());
            rocketMqMessage.setDelFlag(YesNoEnum.YES_CODE.getCode());
            rocketMqMessage.setIsTransactional(YesNoEnum.NO_CODE.getCode());
            rocketMqMessage.setMessageBody(msg);
            rocketMqMessage.setMessageProducerGroup(producerGroup);
            rocketMqMessage.setMessageTag(MqConstants.MQ_TAG);
            rocketMqMessage.setMessageTopic(topic);
            rocketMqMessage.setMessgeStatus("TO_SEND");
            rocketMqMessageMapper.insert(rocketMqMessage);
            Message message = new Message(topic, MqConstants.MQ_TAG, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            message.putUserProperty(MqConstants.USER_PROPERTY_KEY, JSON.toJSONString(rocketMqMessage));
            //如果设置了延迟，则设置延迟发送消息
            if (!Objects.isNull(mqDelayTimeLevelEnum)) {
                message.setDelayTimeLevel(mqDelayTimeLevelEnum.getLevel());
            }
            SendResult sendResult = defaultMQProducer.send(message);
            int sendCount = 1;
            while (!sendResult.getSendStatus().name().equals(SendStatus.SEND_OK.name()) && sendCount < maxRetryCount) {
                sendResult = defaultMQProducer.send(message);
                sendCount++;
            }
            rocketMqMessage.setSendCount(sendCount);
            rocketMqMessage.setMaxRetryCount(maxRetryCount);
            rocketMqMessage.setSendResult(JSON.toJSONString(sendResult));
            rocketMqMessage.setMessgeStatus(sendResult.getSendStatus().name());
            rocketMqMessageMapper.updateByRocketmqMessageId(rocketMqMessage);

            return sendResult;
        } catch (Exception e) {
            logger.error("RocketMq 消息队列往主题" + topic + "发送消息" + msg + "异常", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutDown() {
        if (defaultMQProducer != null)
            defaultMQProducer.shutdown();
    }
}
