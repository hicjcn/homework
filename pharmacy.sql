/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Schema         : pharmacy

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 17/06/2020 19:10:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `type` int(11) NOT NULL COMMENT '用户类型0管理员1销售员2采购员',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123456', '管理员', '18888888888', 0);
INSERT INTO `admin` VALUES ('inventory', '123456', '库存管理员', '18888888888', 2);
INSERT INTO `admin` VALUES ('sale', '123456', '销售管理员', '18888888888', 1);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `norms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `sale_price` decimal(10, 2) NOT NULL COMMENT '销售价',
  `amount` int(11) NOT NULL COMMENT '库存',
  `manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '厂商',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '感冒药', '12 * 2', 12.34, 20.32, 98, '感冒商');
INSERT INTO `goods` VALUES (2, '健胃消食片', '24 * 2', 34.26, 46.20, 98, '江中');

-- ----------------------------
-- Table structure for sale_record
-- ----------------------------
DROP TABLE IF EXISTS `sale_record`;
CREATE TABLE `sale_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `goods_id` int(11) NOT NULL COMMENT '货物编号',
  `amount` int(11) NOT NULL COMMENT '销售数量',
  `sale_price` decimal(10, 2) NOT NULL COMMENT '销售单价',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '会员编号',
  `sale_time` datetime(0) NULL DEFAULT NULL COMMENT '销售时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_record
-- ----------------------------
INSERT INTO `sale_record` VALUES (1, 1, 1, 20.32, 1, '2020-06-17 14:21:03');
INSERT INTO `sale_record` VALUES (2, 1, 1, 20.32, 1, '2020-06-17 14:21:03');
INSERT INTO `sale_record` VALUES (3, 2, 2, 46.20, 1, '2020-06-17 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `points` decimal(10, 2) NOT NULL COMMENT '积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '小明', '16666666666', 112.72);

SET FOREIGN_KEY_CHECKS = 1;
