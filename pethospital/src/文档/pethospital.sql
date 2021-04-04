/*
Navicat MySQL Data Transfer

Source Server         : anei
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pethospital

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-04-04 22:23:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(32) NOT NULL,
  `admin_account` varchar(32) NOT NULL,
  `admin_name` varchar(32) NOT NULL,
  `admin_pwd` varchar(16) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for count_data
-- ----------------------------
DROP TABLE IF EXISTS `count_data`;
CREATE TABLE `count_data` (
  `id` varchar(255) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of count_data
-- ----------------------------

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctor_id` varchar(32) NOT NULL,
  `doctor_account` varchar(32) NOT NULL,
  `doctor_name` varchar(32) NOT NULL,
  `doctor_pwd` varchar(16) NOT NULL,
  `doctor_birth` datetime DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` varchar(32) NOT NULL,
  `item_name` varchar(32) NOT NULL,
  `item_text` varchar(500) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`item_id`),
  KEY `fk_user_id` (`item_text`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '毛皮护理', '毛皮护理', '0');
INSERT INTO `item` VALUES ('2', '口腔护理', '口腔护理', '0');
INSERT INTO `item` VALUES ('3', '头皮护理', '头皮护理', '0');
INSERT INTO `item` VALUES ('4', '修剪护理', '修剪护理', '0');
INSERT INTO `item` VALUES ('5', '健康护理', '健康护理', '0');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `medicine_id` varchar(32) NOT NULL,
  `medicine_name` varchar(32) NOT NULL,
  `medicine_text` varchar(500) DEFAULT NULL,
  `medicine_num` int(4) NOT NULL DEFAULT '0',
  `medicine_price` float(18,2) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`medicine_id`),
  KEY `fk_user_id` (`medicine_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', 'A药', null, '99', '10.00', '0');
INSERT INTO `medicine` VALUES ('2', 'B药', null, '99', '5.00', '0');
INSERT INTO `medicine` VALUES ('3', 'C药', null, '99', '3.00', '0');
INSERT INTO `medicine` VALUES ('4', 'D药', null, '99', '100.00', '0');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `order_id` varchar(32) NOT NULL,
  `item_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `pet_id` varchar(32) NOT NULL,
  `doctor_id` varchar(32) NOT NULL,
  `order_text` varchar(500) DEFAULT NULL,
  `order_time` datetime NOT NULL,
  `finish_time` datetime DEFAULT NULL,
  `is_finish` int(1) NOT NULL DEFAULT '0' COMMENT '0-未完成 1-已完成',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效 2-生效但不可提交',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('1', '1', '1', '1', '1', '123123', '2021-04-02 23:32:39', '2021-04-04 18:57:21', '1', '0');
INSERT INTO `orderinfo` VALUES ('2', '2', '3', '4', '5', '123123', '2021-04-03 00:22:51', '2021-04-04 18:57:19', '1', '0');
INSERT INTO `orderinfo` VALUES ('3', '1', '2', '3', '4', '123123', '2021-04-03 00:23:08', '2021-04-03 18:57:16', '1', '0');
INSERT INTO `orderinfo` VALUES ('4', '1', '1', '5', '7', '123123', '2021-04-03 00:25:31', '2021-04-03 18:57:14', '1', '0');
INSERT INTO `orderinfo` VALUES ('402880e6789baa9801789baabfd50000', '2', '1', '1', '1', null, '2021-04-04 14:56:02', '2021-04-04 14:56:02', '1', '0');
INSERT INTO `orderinfo` VALUES ('402880e6789baa9801789bac0b200001', '1', '1', '1', '1', null, '2021-04-04 14:57:27', '2021-04-04 14:57:27', '1', '1');
INSERT INTO `orderinfo` VALUES ('5', '3', '1', '1', '1', '12312344', '2021-04-04 18:38:58', '2021-04-04 18:57:23', '1', '0');
INSERT INTO `orderinfo` VALUES ('6', '4', '1', '6', '2', '123123', '2021-04-04 18:39:29', '2021-04-04 18:57:26', '1', '0');

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `pet_id` varchar(32) NOT NULL,
  `user_id` varchar(11) NOT NULL,
  `pet_name` varchar(32) NOT NULL,
  `pet_age` int(2) DEFAULT NULL,
  `pet_sex` int(1) DEFAULT NULL COMMENT '0-公 1-母',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`pet_id`),
  KEY `fk_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pet
-- ----------------------------

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `prescription_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `medicine_id` varchar(32) NOT NULL,
  `medicine_num` int(4) NOT NULL,
  `count_price` float(18,2) NOT NULL,
  `prescription_time` datetime NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('1', '1', '1', '1', '10.00', '2021-04-04 20:08:21', '0');
INSERT INTO `prescription` VALUES ('2', '1', '2', '3', '15.00', '2021-04-04 20:09:34', '0');
INSERT INTO `prescription` VALUES ('3', '2', '1', '2', '20.00', '2021-04-04 20:09:49', '0');
INSERT INTO `prescription` VALUES ('4', '3', '3', '3', '9.00', '2021-04-04 20:13:20', '0');
INSERT INTO `prescription` VALUES ('5', '4', '4', '9', '900.00', '2021-04-04 20:14:53', '0');
INSERT INTO `prescription` VALUES ('6', '4', '2', '2', '10.00', '2021-04-04 21:19:29', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_pwd` varchar(16) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0-生效 1-失效',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
