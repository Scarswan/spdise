package com.jh.common.rocketmq.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.rocketmq.RocketMqConsumer;

public interface RocketMqConsumerMapper extends BaseMapper<RocketMqConsumer> {
    List<RocketMqConsumer> selectByAll(RocketMqConsumer rocketMqConsumer);
}