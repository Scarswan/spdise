package com.jh.common.rocketmq.impl;

import com.alibaba.fastjson.JSON;
import com.jh.common.constants.MqConstants;
import com.jh.common.enums.rocketmq.ConsumeStatusAppend;
import com.jh.common.enums.RetCode;
import com.jh.common.enums.YesNoEnum;
import com.jh.common.model.rocketmq.RocketMqConsume;
import com.jh.common.model.rocketmq.RocketMqMessage;
import com.jh.common.rocketmq.IMqConsumer;
import com.jh.common.rocketmq.IConsumerListener;
import com.jh.common.rocketmq.mapper.RocketMqConsumeMapper;
import com.jh.common.util.date.DateUtil;
import com.jh.common.util.sequence.Sequence;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Scope("prototype")
public class MqConsumerImpl implements IMqConsumer {
    private Logger logger = LoggerFactory.getLogger(MqConsumerImpl.class);

    @Autowired
    private RocketMqConsumeMapper rocketMqConsumeMapper;

    @Value("${spdise.rocketmq.consumeMaxRetryCount}")
    public int maxRetryCount;

    @Value("${spdise.rocketmq.namesrvAddr}")
    public String namesrvAddr;

    private DefaultMQPushConsumer consumer;

    @Override
    public void start(String topic, String consumerGroup, IConsumerListener iConsumerListener) throws Exception {
        logger.info(String.format("%s消费者开始接收主题%s下消息", consumerGroup, topic));
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMax(5);
        consumer.setConsumeThreadMin(1);
        consumer.subscribe(topic, MqConstants.MQ_TAG);
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try {
                    logger.info(String.format("%s消费者接收主题%s下消息,条数：%d，", consumerGroup, topic, list.size()));
                    //单发消息不会出现多条的情况
                    for (int i = 0; i < list.size(); i ++) {

                        RocketMqConsume rocketMqConsume = new RocketMqConsume();
                        int consumeCount = 0;
                        try {
                            MessageExt messageExt = list.get(i);
                            //消息查重。。。。。。  //重复消费 则记录下重复消费情况  返回消费成功
                            RocketMqMessage rocketMqMessage = JSON.parseObject(messageExt.getProperty(MqConstants.USER_PROPERTY_KEY), RocketMqMessage.class);
                            logger.info(String.format("%s消费者处理主题%s下消息：%d  %s，", consumerGroup, topic, i, messageExt.getProperty(MqConstants.USER_PROPERTY_KEY)));

                            rocketMqConsume.setCreateTime(DateUtil.getCurrentTimeString());
                            rocketMqConsume.setUpdateTime(DateUtil.getCurrentTimeString());
                            rocketMqConsume.setDelFlag(YesNoEnum.YES_CODE.getCode());
                            rocketMqConsume.setMessageConsumerGroup(consumerGroup);
                            rocketMqConsume.setMessageTag(MqConstants.MQ_TAG);
                            rocketMqConsume.setMessageTopic(topic);
                            rocketMqConsume.setRocketmqConsumeId(Sequence.createId());
                            rocketMqConsume.setRocketmqMessageId(rocketMqMessage.getRocketmqMessageId());
                            rocketMqConsume.setMaxConsumeCount(maxRetryCount);

                            RocketMqConsume selectConsume = new RocketMqConsume();
                            selectConsume.setRocketmqMessageId(rocketMqMessage.getRocketmqMessageId());
                            selectConsume.setMessageConsumerGroup(consumerGroup);
                            List<RocketMqConsume> rocketMqConsumes = rocketMqConsumeMapper.selectByAll(selectConsume);
                            if (rocketMqConsumes != null) {
                                for (int j = 0; j < rocketMqConsumes.size(); j++) {
                                    if (ConsumeConcurrentlyStatus.CONSUME_SUCCESS.name().equals(rocketMqConsumes.get(j).getConsumeStatus())) {
                                        rocketMqConsume.setConsumeStatus(ConsumeStatusAppend.CONSUME_CONSUMED.name());
                                        rocketMqConsume.setConsumeCount(rocketMqConsumes.size() + 1);
                                        rocketMqConsumeMapper.insert(rocketMqConsume);
                                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                                    }
                                }
                                if (rocketMqConsumes.size() >= maxRetryCount) {
                                    //新增消费超过最大次数放弃
                                    rocketMqConsume.setConsumeStatus(ConsumeStatusAppend.CONSUME_REACH_MAX.name());
                                    rocketMqConsume.setConsumeCount(rocketMqConsumes.size());
                                    rocketMqConsumeMapper.insert(rocketMqConsume);
                                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                                }
                            }
                            consumeCount = rocketMqConsumes == null ? 0 : rocketMqConsumes.size();


                            //如果不重复
                            String code = iConsumerListener.apply(new String(messageExt.getBody()));
                            consumeCount++;
                            if (RetCode.SUCCESS.getCode().equals(code)) {
                                //新增消费成功记录
                                rocketMqConsume.setConsumeStatus(ConsumeStatusAppend.CONSUME_SUCCESS.name());
                                rocketMqConsume.setConsumeCount(consumeCount);
                                rocketMqConsumeMapper.insert(rocketMqConsume);
                                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                            } else {

                                //新增消费失败记录
                                rocketMqConsume.setConsumeStatus(ConsumeStatusAppend.RECONSUME_LATER.name());
                                rocketMqConsume.setConsumeCount(consumeCount);
                                rocketMqConsumeMapper.insert(rocketMqConsume);

                                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                            }
                        } catch (Exception e) {
                            //新增消费失败记录
                            rocketMqConsume.setConsumeStatus(ConsumeStatusAppend.RECONSUME_LATER.name());
                            rocketMqConsume.setConsumeCount(consumeCount);
                            rocketMqConsumeMapper.insert(rocketMqConsume);

                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

            }
        });
        consumer.start();
    }

    @Override
    public void shutDown() {
        if (consumer != null)
            consumer.shutdown();
    }
}
