DROP TABLE IF EXISTS `t_rocketmq_consumer`;

CREATE TABLE `t_rocketmq_consumer` (
  `rocketmq_consumer_id` varchar(50) NOT NULL COMMENT 'message消费记录主键',
  `rocketmq_message_id` varchar(50) DEFAULT NULL COMMENT '消息id',
  `transaction_id` varchar(100) DEFAULT NULL COMMENT '事务id',
  `message_topic` varchar(100) DEFAULT NULL COMMENT '消息topic',
  `message_consumer_group` varchar(100) DEFAULT NULL COMMENT '消息消费者group',
  `message_tag` varchar(100) DEFAULT NULL COMMENT '消费者tag',
  `consumer_status` varchar(100) DEFAULT NULL COMMENT '消息消费状态',
  `consumer_count` int(5) DEFAULT NULL COMMENT '第几次接收数据',
  `max_consumer_count` int(5) DEFAULT NULL COMMENT '最多消费次数 超过后会舍弃消息',
  `del_flag` int(1) DEFAULT NULL COMMENT '有效状态位',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`rocketmq_consumer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
