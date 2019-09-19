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

/*Table structure for table `t_rocketmq_consume` */

DROP TABLE IF EXISTS `t_rocketmq_consume`;

CREATE TABLE `t_rocketmq_consume` (
  `rocketmq_consume_id` varchar(50) NOT NULL COMMENT 'message消费记录主键',
  `rocketmq_message_id` varchar(50) DEFAULT NULL COMMENT '消息id',
  `transaction_id` varchar(100) DEFAULT NULL COMMENT '事务id',
  `message_topic` varchar(100) DEFAULT NULL COMMENT '消息topic',
  `message_consumer_group` varchar(100) DEFAULT NULL COMMENT '消息消费者group',
  `message_tag` varchar(100) DEFAULT NULL COMMENT '消费者tag',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '有效状态位',
  `consume_status` varchar(100) DEFAULT NULL COMMENT '消息消费状态',
  `consume_count` int(5) DEFAULT NULL COMMENT '第几次接收数据',
  `max_consume_count` int(5) DEFAULT NULL COMMENT '最多消费次数 超过后会舍弃消息',
  PRIMARY KEY (`rocketmq_consume_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
