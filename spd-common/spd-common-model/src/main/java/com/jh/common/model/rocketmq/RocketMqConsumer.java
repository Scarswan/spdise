package com.jh.common.model.rocketmq;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_rocketmq_consumer")
public class RocketMqConsumer {
    /**
     * message消费记录主键
     */
    @TableId(value = "rocketmq_consumer_id", type = IdType.INPUT)
    private String rocketmqConsumerId;

    /**
     * 消息id
     */
    @TableField(value = "rocketmq_message_id")
    private String rocketmqMessageId;

    /**
     * 事务id
     */
    @TableField(value = "transaction_id")
    private String transactionId;

    /**
     * 消息topic
     */
    @TableField(value = "message_topic")
    private String messageTopic;

    /**
     * 消息消费者group
     */
    @TableField(value = "message_consumer_group")
    private String messageConsumerGroup;

    /**
     * 消费者tag
     */
    @TableField(value = "message_tag")
    private String messageTag;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private String updateTime;

    /**
     * 有效状态位
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    /**
     * 消息消费状态
     */
    @TableField(value = "consume_status")
    private String consumerStatus;

    /**
     * 第几次接收数据
     */
    @TableField(value = "consume_count")
    private Integer consumerCount;

    /**
     * 最多消费次数 超过后会舍弃消息
     */
    @TableField(value = "max_consumer_count")
    private Integer maxConsumerCount;

    public static final String COL_ROCKETMQ_CONSUMER_ID = "rocketmq_consumer_id";

    public static final String COL_ROCKETMQ_MESSAGE_ID = "rocketmq_message_id";

    public static final String COL_TRANSACTION_ID = "transaction_id";

    public static final String COL_MESSAGE_TOPIC = "message_topic";

    public static final String COL_MESSAGE_CONSUMER_GROUP = "message_consumer_group";

    public static final String COL_MESSAGE_TAG = "message_tag";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DEL_FLAG = "del_flag";

    public static final String COL_CONSUMER_STATUS = "consumer_status";

    public static final String COL_CONSUMER_COUNT = "consumer_count";

    public static final String COL_MAX_CONSUMER_COUNT = "max_consumer_count";
}