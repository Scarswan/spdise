DROP TABLE IF EXISTS `t_rocketmq_message`;

CREATE TABLE `t_rocketmq_message` (
  `rocketmq_message_id` varchar(50) NOT NULL COMMENT 'rocketmq消息id',
  `send_result` varchar(9192) DEFAULT NULL COMMENT '消息发送结果详情',
  `message_topic` varchar(100) DEFAULT NULL COMMENT '消息topic',
  `message_producer_group` varchar(100) DEFAULT NULL COMMENT '消息生产者group',
  `is_transactional` int(1) DEFAULT NULL COMMENT '是否是事务消息',
  `transaction_id` varchar(100) DEFAULT NULL COMMENT '消息的事务id',
  `message_tag` varchar(100) DEFAULT NULL COMMENT '消息tag',
  `messge_status` varchar(100) DEFAULT NULL COMMENT '消息发送结果',
  `message_body` varchar(9192) DEFAULT NULL COMMENT '消息体',
  `send_count` int(5) DEFAULT NULL COMMENT '重试次数',
  `max_retry_count` int(5) DEFAULT NULL COMMENT '最大重试次数',
  `del_flag` int(1) DEFAULT NULL COMMENT '状态标志位',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`rocketmq_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;