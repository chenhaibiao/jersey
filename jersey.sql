/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50627
 Source Host           : localhost
 Source Database       : jersey

 Target Server Type    : MySQL
 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 03/26/2017 16:18:38 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_id` varchar(9) NOT NULL COMMENT '店铺ID',
  `name` varchar(256) NOT NULL COMMENT '店铺名',
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `shop`
-- ----------------------------
BEGIN;
INSERT INTO `shop` VALUES ('aaaaaaaaa', '店铺A');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
