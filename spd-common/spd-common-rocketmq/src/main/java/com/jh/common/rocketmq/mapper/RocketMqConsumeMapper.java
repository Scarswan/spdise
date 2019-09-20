package com.jh.common.rocketmq.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.rocketmq.RocketMqConsume;

public interface RocketMqConsumeMapper extends BaseMapper<RocketMqConsume> {
    List<RocketMqConsume> selectByAll(RocketMqConsume rocketMqConsume);
}