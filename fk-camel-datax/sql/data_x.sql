/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : data_x

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2022-01-23 22:39:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datax_config
-- ----------------------------
DROP TABLE IF EXISTS `datax_config`;
CREATE TABLE `datax_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `datax_config` tinytext NOT NULL COMMENT 'datax配置',
  `camel_config` tinytext NOT NULL COMMENT 'camel配置',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info_bak
-- ----------------------------
DROP TABLE IF EXISTS `user_info_bak`;
CREATE TABLE `user_info_bak` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
