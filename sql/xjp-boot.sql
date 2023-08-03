/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : xjp-boot

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 04/08/2023 00:18:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作内容',
  `method_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `request_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求数据',
  `response_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '返回数据',
  `execution_time` int(11) NOT NULL COMMENT '执行时间',
  `success` tinyint(4) NOT NULL COMMENT '是否执行成功',
  `ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `operation_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operation_log
-- ----------------------------
INSERT INTO `operation_log` VALUES (1, NULL, NULL, NULL, NULL, NULL, '{\"code\": 0, \"data\": {\"size\": 10, \"total\": 5, \"orders\": [], \"current\": 1, \"records\": [{\"email\": \"xuejingpan@qq.com\", \"phone\": \"18234848738\", \"state\": 1, \"account\": \"1298231208\", \"username\": \"薛景盘\"}, {\"state\": 1, \"account\": \"002\", \"username\": \"002\"}, {\"state\": 1, \"account\": \"003\", \"username\": \"003\"}, {\"state\": 1, \"account\": \"004\", \"username\": \"004\"}, {\"state\": 1, \"account\": \"005\", \"username\": \"005\"}], \"hitCount\": false, \"isSearchCount\": true, \"optimizeCountSql\": true}, \"message\": \"success\"}', 6, 1, NULL, '2023-04-13 00:23:25');
INSERT INTO `operation_log` VALUES (2, NULL, NULL, NULL, NULL, NULL, 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@440b8161)', 141, 1, NULL, '2023-04-14 00:06:49');
INSERT INTO `operation_log` VALUES (3, NULL, NULL, NULL, NULL, NULL, 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@7b3741cb)', 271, 1, NULL, '2023-04-14 00:10:11');
INSERT INTO `operation_log` VALUES (4, NULL, NULL, NULL, NULL, NULL, 'Result(code=0, message=success, data=Test success !)', 2, 1, NULL, '2023-04-14 00:10:40');
INSERT INTO `operation_log` VALUES (5, NULL, NULL, NULL, NULL, NULL, 'Result(code=0, message=success, data=Test success !)', 3, 1, NULL, '2023-04-15 01:08:22');
INSERT INTO `operation_log` VALUES (6, NULL, NULL, NULL, NULL, NULL, 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@19c0c469)', 174, 1, NULL, '2023-04-16 23:46:33');
INSERT INTO `operation_log` VALUES (7, NULL, NULL, '', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@2ad9637b)', 245, 1, NULL, '2023-04-16 23:59:19');
INSERT INTO `operation_log` VALUES (8, NULL, NULL, '分页查询用户', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'java.lang.NullPointerException', 4, 0, NULL, '2023-04-17 00:01:32');
INSERT INTO `operation_log` VALUES (9, NULL, NULL, '分页查询用户', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@1bcbb10f)', 256, 1, NULL, '2023-04-17 00:08:44');
INSERT INTO `operation_log` VALUES (10, NULL, NULL, '分页查询用户', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@20b7b8f)', 420, 1, NULL, '2023-04-21 21:47:44');
INSERT INTO `operation_log` VALUES (11, NULL, NULL, '分页查询用户', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@348692c2)', 260, 1, NULL, '2023-04-21 22:00:52');
INSERT INTO `operation_log` VALUES (12, NULL, NULL, '分页查询用户', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@74720cec)', 455, 1, NULL, '2023-06-13 22:46:44');
INSERT INTO `operation_log` VALUES (13, '10001', '测试', '分页查询用户', 'UserController.getUserPage', '[UserPageDTO(account=null, username=null, phone=null, email=null, state=null)]', 'Result(code=0, message=success, data=com.baomidou.mybatisplus.extension.plugins.pagination.Page@77d8021a)', 333, 1, NULL, '2023-06-13 22:51:22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `state` tinyint(4) NULL DEFAULT 1 COMMENT '状态：0-正常，1-已注销',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_uk`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1298208', '薛江江', 'xuejiangjiang', '18234848712', 'xuejiangjiang@qq.com', 1, '2023-03-09 23:56:22', '2023-03-09 23:56:22');
INSERT INTO `user` VALUES (2, '002', '002', '002', NULL, NULL, 1, '2023-03-29 23:30:35', '2023-03-29 23:30:35');
INSERT INTO `user` VALUES (3, '003', '003', '003', NULL, NULL, 1, '2023-03-29 23:30:44', '2023-03-29 23:30:44');
INSERT INTO `user` VALUES (4, '004', '004', '004', NULL, NULL, 1, '2023-03-29 23:30:53', '2023-03-29 23:30:53');
INSERT INTO `user` VALUES (5, '005', '005', '005', NULL, NULL, 1, '2023-03-29 23:31:01', '2023-03-29 23:31:01');

SET FOREIGN_KEY_CHECKS = 1;
