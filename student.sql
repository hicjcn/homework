/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Schema         : stu

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 13/06/2020 14:48:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '课程名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `teacher_id` varchar(16) NOT NULL COMMENT '教师号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager
-- 初始管理员密码 admin/123456
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES (1, 'admin', '123456');
COMMIT;

-- ----------------------------
-- Table structure for rel_course_student
-- ----------------------------
DROP TABLE IF EXISTS `rel_course_student`;
CREATE TABLE `rel_course_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL COMMENT '课程号',
  `student_no` varchar(16) NOT NULL COMMENT '学生号',
  `grade` int(11) NOT NULL DEFAULT '0' COMMENT '分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of rel_course_student
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` varchar(16) NOT NULL COMMENT '学号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `sex` int(11) NOT NULL COMMENT '性别1男0女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `no` varchar(16) NOT NULL COMMENT '教工号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `sex` int(11) NOT NULL COMMENT '性别1男0女',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
