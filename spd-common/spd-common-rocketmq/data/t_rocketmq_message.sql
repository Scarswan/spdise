/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.22 : Database - rongxintianxia
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rongxintianxia` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `rongxintianxia`;

/*Table structure for table `t_rocketmq_message` */

DROP TABLE IF EXISTS `t_rocketmq_message`;

CREATE TABLE `t_rocketmq_message` (
  `rocketmq_message_id` varchar(50) NOT NULL COMMENT 'rocketmq消息id',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '状态标志位',
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
  PRIMARY KEY (`rocketmq_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
