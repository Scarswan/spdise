package com.jh.common.model.rocketmq;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_rocketmq_message")
public class RocketMqMessage {
    /**
     * rocketmq消息id
     */
    @TableId(value = "rocketmq_message_id", type = IdType.INPUT)
    private String rocketmqMessageId;

    /**
     * 状态标志位
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    /**
     * 消息发送结果详情
     */
    @TableField(value = "send_result")
    private String sendResult;

    /**
     * 消息topic
     */
    @TableField(value = "message_topic")
    private String messageTopic;

    /**
     * 消息生产者group
     */
    @TableField(value = "message_producer_group")
    private String messageProducerGroup;

    /**
     * 是否是事务消息
     */
    @TableField(value = "is_transactional")
    private Integer isTransactional;

    /**
     * 消息的事务id
     */
    @TableField(value = "transaction_id")
    private String transactionId;

    /**
     * 消息tag
     */
    @TableField(value = "message_tag")
    private String messageTag;

    /**
     * 消息发送结果
     */
    @TableField(value = "messge_status")
    private String messgeStatus;

    /**
     * 消息体
     */
    @TableField(value = "message_body")
    private String messageBody;

    /**
     * 重试次数
     */
    @TableField(value = "send_count")
    private Integer sendCount;

    /**
     * 最大重试次数
     */
    @TableField(value = "max_retry_count")
    private Integer maxRetryCount;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    private String updateTime;

    public static final String COL_ROCKETMQ_MESSAGE_ID = "rocketmq_message_id";

    public static final String COL_DEL_FLAG = "del_flag";

    public static final String COL_SEND_RESULT = "send_result";

    public static final String COL_MESSAGE_TOPIC = "message_topic";

    public static final String COL_MESSAGE_PRODUCER_GROUP = "message_producer_group";

    public static final String COL_IS_TRANSACTIONAL = "is_transactional";

    public static final String COL_TRANSACTION_ID = "transaction_id";

    public static final String COL_MESSAGE_TAG = "message_tag";

    public static final String COL_MESSGE_STATUS = "messge_status";

    public static final String COL_MESSAGE_BODY = "message_body";

    public static final String COL_SEND_COUNT = "send_count";

    public static final String COL_MAX_RETRY_COUNT = "max_retry_count";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}