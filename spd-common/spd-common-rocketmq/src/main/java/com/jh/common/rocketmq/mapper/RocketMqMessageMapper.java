package com.jh.common.rocketmq.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.common.model.rocketmq.RocketMqMessage;

public interface RocketMqMessageMapper extends BaseMapper<RocketMqMessage> {
    int updateByRocketmqMessageId(@Param("updated")RocketMqMessage updated);
}
