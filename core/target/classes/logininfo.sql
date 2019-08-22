/*
Navicat MySQL Data Transfer

Source Server         : mysql_localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : gxa_eloan

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-19 10:52:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logininfo
-- ----------------------------
DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `usertype` tinyint(4) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logininfo
-- ----------------------------
INSERT INTO `logininfo` VALUES ('4', 'stef', '1111', '0', '1', '\0');
INSERT INTO `logininfo` VALUES ('5', 'admin', '1234', '0', '0', '');
INSERT INTO `logininfo` VALUES ('6', 'admin', '1111', '0', '1', '\0');
INSERT INTO `logininfo` VALUES ('7', 'stea', '1111', '0', '1', '\0');
INSERT INTO `logininfo` VALUES ('10', 'stee', '1111', '0', '1', '\0');
INSERT INTO `logininfo` VALUES ('53', 'novo', '1111', '0', '0', '\0');
INSERT INTO `logininfo` VALUES ('54', 'novo1', '1111', '0', '0', '\0');
INSERT INTO `logininfo` VALUES ('55', 'novo3', '1111', '0', '0', '\0');
