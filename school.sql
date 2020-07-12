/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 12/07/2020 21:18:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程名',
  `teacher_code` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师编码',
  `class_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `teacher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任课老师',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '大学语文', 'tec', '大学语文（一）', '教师1');
INSERT INTO `class` VALUES (2, '高等数学', 'tec', '高等数学（一）', '教师1');

-- ----------------------------
-- Table structure for class_student
-- ----------------------------
DROP TABLE IF EXISTS `class_student`;
CREATE TABLE `class_student`  (
  `cs_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `class_id` int(8) NOT NULL COMMENT '班级ID',
  `student_code` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生ID',
  `status` int(1) NOT NULL COMMENT '状态（0通过，1审核中，2驳回）',
  `teacher_code` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师ID',
  PRIMARY KEY (`cs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_student
-- ----------------------------
INSERT INTO `class_student` VALUES (1, 1, 'stu', 0, 'tec');
INSERT INTO `class_student` VALUES (2, 2, 'stu', 0, 'tec');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `h_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `h_topic` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业主题',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `deadline` datetime(0) NULL DEFAULT NULL COMMENT '截至时间',
  `class_id` int(8) NOT NULL COMMENT '班级ID',
  `teacher_code` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师ID',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  PRIMARY KEY (`h_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, '第一节课：阅读', '2020-07-12 13:07:32', '2020-07-18 00:00:00', 1, 'tec', 'file1594559252492第一节课：阅读.txt');
INSERT INTO `homework` VALUES (2, '第二节课：写作', '2020-07-12 13:10:39', '2020-07-18 00:00:00', 1, 'tec', 'file1594559439250第二节课：写作.txt');
INSERT INTO `homework` VALUES (3, '线性积分', '2020-07-12 13:11:00', '2020-07-18 00:00:00', 2, 'tec', 'file1594559459585线性积分.txt');

-- ----------------------------
-- Table structure for homework_student
-- ----------------------------
DROP TABLE IF EXISTS `homework_student`;
CREATE TABLE `homework_student`  (
  `hs_id` int(8) NOT NULL AUTO_INCREMENT,
  `student_code` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生编码',
  `h_id` int(8) NOT NULL COMMENT '作业ID',
  `submit_time` datetime(0) NOT NULL COMMENT '提交时间',
  `grade` float(5, 2) NULL DEFAULT NULL COMMENT '得分',
  `hs_file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `hs_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
  `student_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`hs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework_student
-- ----------------------------
INSERT INTO `homework_student` VALUES (1, 'stu', 3, '2020-07-12 13:11:29', 82.00, 'file1594559488677线性积分.txt', '线性积分作业', '学生1');
INSERT INTO `homework_student` VALUES (2, 'stu', 2, '2020-07-12 13:11:46', 87.00, 'file1594559506232写作作业.txt', '写作作业', '学生1');
INSERT INTO `homework_student` VALUES (3, 'stu', 1, '2020-07-12 13:12:04', 67.00, 'file1594559524225阅读作业.txt', '阅读作业', '学生1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_code` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编码（登录用）',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
  `user_type` int(1) NOT NULL COMMENT '用户类型（1老师，0学生）',
  PRIMARY KEY (`user_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('stu', '123', '学生1', 0);
INSERT INTO `user` VALUES ('tec', '123', '教师1', 1);

SET FOREIGN_KEY_CHECKS = 1;
