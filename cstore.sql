/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Schema         : cstore

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 22/06/2020 16:32:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for BUY
-- ----------------------------
DROP TABLE IF EXISTS `BUY`;
CREATE TABLE `BUY` (
  `BuyID` varchar(16) NOT NULL COMMENT '入库单号',
  `Price` decimal(10,2) NOT NULL COMMENT '价格',
  `Quantity` int(16) NOT NULL COMMENT '数量',
  `BuyDate` datetime NOT NULL COMMENT '入库日期',
  `WareID` varchar(16) NOT NULL COMMENT '商品编码',
  `BuyPerson` varchar(16) NOT NULL COMMENT '购买员工',
  PRIMARY KEY (`BuyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of BUY
-- ----------------------------
BEGIN;
INSERT INTO `BUY` VALUES ('01202006220001', 1.00, 1, '2020-06-22 08:27:24', '10000001', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for SALE
-- ----------------------------
DROP TABLE IF EXISTS `SALE`;
CREATE TABLE `SALE` (
  `SaleID` varchar(16) NOT NULL COMMENT '销售单号',
  `SalePrice` decimal(10,2) NOT NULL COMMENT '价格',
  `SaleQuantity` int(16) NOT NULL COMMENT '数量',
  `SaleDate` datetime NOT NULL COMMENT '销售日期',
  `WareID` varchar(16) NOT NULL COMMENT '商品编码',
  PRIMARY KEY (`SaleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of SALE
-- ----------------------------
BEGIN;
INSERT INTO `SALE` VALUES ('01202006220001', 2.00, 2, '2020-06-22 07:54:33', '10000001');
COMMIT;

-- ----------------------------
-- Table structure for STAFF
-- ----------------------------
DROP TABLE IF EXISTS `STAFF`;
CREATE TABLE `STAFF` (
  `StaffID` varchar(16) NOT NULL COMMENT '员工编号',
  `StaffName` varchar(80) NOT NULL COMMENT '姓名',
  `StaffSex` int(11) NOT NULL COMMENT '性别1男 0女',
  `IDNumber` varchar(20) NOT NULL COMMENT '身份证号',
  `Wage` decimal(10,2) NOT NULL COMMENT '工资',
  `StaffType` int(16) NOT NULL COMMENT '员工类型',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工登记表';

-- ----------------------------
-- Records of STAFF
-- ----------------------------
BEGIN;
INSERT INTO `STAFF` VALUES ('01011', '采购员', 1, '1', 1.00, 1, '123456');
INSERT INTO `STAFF` VALUES ('01022', '销售员', 0, '2', 2.00, 0, '123456');
INSERT INTO `STAFF` VALUES ('admin', 'admin', 1, '2516666665657766', 6.66, 2, '123123');
COMMIT;

-- ----------------------------
-- Table structure for WARE
-- ----------------------------
DROP TABLE IF EXISTS `WARE`;
CREATE TABLE `WARE` (
  `WareID` varchar(16) NOT NULL COMMENT '商品编号',
  `WareName` varchar(80) NOT NULL COMMENT '商品名称',
  `WarePrice` decimal(10,2) NOT NULL COMMENT '价格',
  PRIMARY KEY (`WareID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品登记表';

-- ----------------------------
-- Records of WARE
-- ----------------------------
BEGIN;
INSERT INTO `WARE` VALUES ('10000001', '农夫山泉矿泉水', 1.00);
INSERT INTO `WARE` VALUES ('10000002', '雪碧', 2.00);
INSERT INTO `WARE` VALUES ('10000003', '可口可乐', 3.00);
INSERT INTO `WARE` VALUES ('20000001', '百事可乐', 1.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
