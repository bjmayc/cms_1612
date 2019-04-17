/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50122
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50122
File Encoding         : 65001

Date: 2019-04-12 14:28:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `picture` varchar(255) DEFAULT NULL,
  `channel_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `hits` bigint(20) DEFAULT NULL,
  `hot` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES ('1', '游戏是新的精神鸦片', '王者荣耀还是王者农药', 'dd_family_3.jpg', '1', '1', '2', '10000', '1', '1', null, '2019-03-27 17:39:36', null);
INSERT INTO `cms_article` VALUES ('2', '游戏可以释放压力', '小玩怡情大玩伤身', 'dd_family_4.jpg', '1', '1', '2', '20000', '1', '1', null, '2019-03-20 21:30:55', null);
INSERT INTO `cms_article` VALUES ('3', '青少年不能做游戏的奴隶', '不能做游戏的奴隶,要做游戏的主人', 'dd_family_5.jpg', '1', '1', '2', '25000', '0', '1', null, '2019-03-22 22:26:27', null);
INSERT INTO `cms_article` VALUES ('5', '哈哈222', null, '731521054673240090.jpg', '1', '1', '2', '1', '0', '1', '0', '2019-03-29 10:41:12', null);
INSERT INTO `cms_article` VALUES ('6', 'heheheh22', null, 'aaaa.jpg', '1', '2', '2', '1', '0', '1', '0', '2019-03-29 10:46:48', null);
INSERT INTO `cms_article` VALUES ('7', 'wwwww22', null, 'aaaa.jpg', '1', '2', '2', '1', '0', '1', '0', '2019-03-29 10:51:16', null);
INSERT INTO `cms_article` VALUES ('8', '出来混迟早要还的', ' 吃鸡是什么东西 吃鸡是什么东西 吃鸡是什么东西 吃鸡是什么东西', '211265854926657120.jpg', '1', '2', '2', '1000', '0', '2', '0', '2019-03-29 12:02:09', null);
INSERT INTO `cms_article` VALUES ('9', '今天愚人节', '<p>\r\n	你今天被愚了吗?你今天被愚了吗?你今天被愚了吗?你今天被愚了吗?你今天被愚了吗?</p>\r\n', 'aaaa.jpg', '1', '3', '2', '1000', '0', '1', '0', '2019-04-01 16:04:08', null);
INSERT INTO `cms_article` VALUES ('10', 'sssss', '<p>\r\n	sssssssssssssssssssssssss</p>\r\n', '731521054673240090.jpg', '1', '1', '2', '1000', '0', '1', '0', '2019-04-02 18:44:09', null);
INSERT INTO `cms_article` VALUES ('11', 'eerrr', '<p>\r\n	seeeerrr</p>\r\n', 'aaaa.jpg', '1', '1', '2', '1000', '0', '1', '0', '2019-04-02 22:51:24', null);

-- ----------------------------
-- Table structure for cms_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `channel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_category
-- ----------------------------
INSERT INTO `cms_category` VALUES ('1', ' 王者', '1');
INSERT INTO `cms_category` VALUES ('2', '吃鸡', '1');
INSERT INTO `cms_category` VALUES ('3', '消消乐', '1');
INSERT INTO `cms_category` VALUES ('4', '魔兽', '1');

-- ----------------------------
-- Table structure for cms_channel
-- ----------------------------
DROP TABLE IF EXISTS `cms_channel`;
CREATE TABLE `cms_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_channel
-- ----------------------------
INSERT INTO `cms_channel` VALUES ('1', '游戏', ' 游戏就是先被蹂躏再蹂躏别人', null);
INSERT INTO `cms_channel` VALUES ('2', '体育', '体育就是运动跑步', null);
INSERT INTO `cms_channel` VALUES ('3', '财经', '财经财经财经钱钱钱', null);
INSERT INTO `cms_channel` VALUES ('4', '科技', '科技就是生产力', null);
INSERT INTO `cms_channel` VALUES ('5', '军事', '军事强国,军事军事军事军事', null);

-- ----------------------------
-- Table structure for cms_settings
-- ----------------------------
DROP TABLE IF EXISTS `cms_settings`;
CREATE TABLE `cms_settings` (
  `admin_username` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_settings
-- ----------------------------
INSERT INTO `cms_settings` VALUES ('admin', '123456');

-- ----------------------------
-- Table structure for cms_slide
-- ----------------------------
DROP TABLE IF EXISTS `cms_slide`;
CREATE TABLE `cms_slide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_slide
-- ----------------------------
INSERT INTO `cms_slide` VALUES ('2', '哈哈哈', 'aaaa.jpg', 'www.aaa.com');
INSERT INTO `cms_slide` VALUES ('3', 'ssssss', 'QQ图片20181120203105.jpg', 'www.hahaha.com');
INSERT INTO `cms_slide` VALUES ('4', '我就是我不一样烟火', '教师要求打印-01.jpg', 'www.yanhuo.com');
INSERT INTO `cms_slide` VALUES ('5', 'wwwwwwww', '211265854926657120.jpg', 'www.hahaha.com');
INSERT INTO `cms_slide` VALUES ('6', 'ssssss', '731521054673240090.jpg', 'wwww.sssss');

-- ----------------------------
-- Table structure for cms_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_user`;
CREATE TABLE `cms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` char(3) DEFAULT NULL,
  `locked` int(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_user
-- ----------------------------
INSERT INTO `cms_user` VALUES ('1', 'zhangsan', '111111', '张三', '2019-03-26', '男', '0', '1970-01-01 08:00:00', null);
INSERT INTO `cms_user` VALUES ('2', 'wudi', '444444', '我是无敌3322', '2019-03-12', '男', '1', '1970-01-01 08:00:00', null);
INSERT INTO `cms_user` VALUES ('3', 'zhangsanfeng', '888888', '张三丰', '2019-03-26', '男', '1', '1970-01-01 08:00:00', null);
INSERT INTO `cms_user` VALUES ('4', 'myc222', '111111', '学习达人', '2012-12-12', '男', '1', '2019-03-28 12:10:31', null);
INSERT INTO `cms_user` VALUES ('5', '哈哈2', '111111', '娃哈哈', '2019-03-14', '男', '1', '2019-03-28 15:30:11', null);
INSERT INTO `cms_user` VALUES ('6', 'dai ', '123456', '123', '2019-04-18', '男', '1', '2019-03-28 16:15:42', null);
INSERT INTO `cms_user` VALUES ('7', '张三', '123456', 'zhangsan', '2015-03-10', '女', '1', '2019-03-28 16:16:41', null);
