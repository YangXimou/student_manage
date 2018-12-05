/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : student_manage

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-12-05 18:02:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for child_course
-- ----------------------------
DROP TABLE IF EXISTS `child_course`;
CREATE TABLE `child_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child_course_id` int(11) DEFAULT NULL COMMENT '子课程id',
  `course_id` int(11) DEFAULT NULL COMMENT '母课程id',
  `name` varchar(255) DEFAULT NULL,
  `credit` decimal(10,1) DEFAULT NULL COMMENT '学分',
  `class_time` varchar(255) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL COMMENT '（0已结课，1正在开课）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `child_course_id` (`child_course_id`),
  KEY `fk_child_course_course_1` (`course_id`),
  CONSTRAINT `fk_child_course_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of child_course
-- ----------------------------
INSERT INTO `child_course` VALUES ('1', '101001', '101', '计算机学院软件工程', '4.0', '2015-2016学年上半年1-10周', '1', '2018-12-04 17:38:31');
INSERT INTO `child_course` VALUES ('2', '102001', '102', '计算机学院高等数学', '4.0', '2015-2016学年上半年', '1', '2018-12-04 17:38:50');
INSERT INTO `child_course` VALUES ('3', '103001', '103', '计算机学院数据库原理', '3.0', '2015-2016学年上半年', '1', '2018-12-04 17:45:10');
INSERT INTO `child_course` VALUES ('4', '104001', '104', '计算机学院算法', '4.0', '2015-2016学年', '1', '2018-12-05 10:30:34');
INSERT INTO `child_course` VALUES ('5', '105001', '105', '计算机学院java', '4.0', '2015-2016学年', '1', '2018-12-05 10:30:37');
INSERT INTO `child_course` VALUES ('6', '106001', '105', '计算机学院C语言', '4.0', '2015-2016学年', '1', '2018-12-05 10:30:43');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `name` varchar(255) DEFAULT NULL COMMENT '班别',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `class_id` (`class_id`),
  KEY `fk_class_department_1` (`department_id`),
  KEY `fk_class_major_1` (`major_id`),
  CONSTRAINT `fk_class_department_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `fk_class_major_1` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1511001', '11', '11001', '2015', '2015级软件工程专业1班', '2018-12-04 13:51:21');
INSERT INTO `class` VALUES ('2', '1612001', '12', '12001', '2016', '2016将应用数学专业1班', '2018-12-04 13:51:46');
INSERT INTO `class` VALUES ('3', '1611001', '11', '11001', '2016', '2016级软件工程专业1班', '2018-12-05 18:00:20');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `introductions` varchar(255) DEFAULT NULL COMMENT '课程简介',
  `department_id` int(11) DEFAULT NULL COMMENT '开课学院',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id` (`course_id`),
  KEY `fk_course_department_1` (`department_id`),
  CONSTRAINT `fk_course_department_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '101', '软件工程', '介绍', '11', '2018-12-04 17:36:15');
INSERT INTO `course` VALUES ('2', '102', '高等数学', '介绍', '12', '2018-12-04 17:36:30');
INSERT INTO `course` VALUES ('4', '103', '数据库', '介绍', '11', '2018-12-04 17:44:12');
INSERT INTO `course` VALUES ('5', '104', '算法', '介绍', '11', '2018-12-05 10:29:14');
INSERT INTO `course` VALUES ('6', '105', 'java语言', '介绍', '11', '2018-12-05 10:29:26');
INSERT INTO `course` VALUES ('7', '106', 'C语言', '介绍', '11', '2018-12-05 10:29:30');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `introductions` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `department_id` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '11', '计算机学院', '这是计算机学院的简介', '2018-12-04 13:48:47');
INSERT INTO `department` VALUES ('2', '12', '数学与统计学院', '这是数学与统计学院的简介', '2018-12-04 13:48:52');
INSERT INTO `department` VALUES ('14', '13', '生科院', '这是生科院的简介', '2018-12-05 16:34:45');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `introductions` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `major_id` (`major_id`),
  KEY `fk_major_department_1` (`department_id`),
  CONSTRAINT `fk_major_department_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '11001', '11', '软件工程', '软件工程专业', '2018-12-04 13:49:36');
INSERT INTO `major` VALUES ('2', '12001', '12', '统计学', '统计学专业', '2018-12-04 13:49:59');
INSERT INTO `major` VALUES ('3', '11002', '11', '网络工程', '网络工程专业', '2018-12-05 17:11:44');
INSERT INTO `major` VALUES ('4', '13001', '13', '园林', '园林专业', '2018-12-05 17:18:02');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `manager_id` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '1990010101', '1990', '2018-12-04 11:24:16');
INSERT INTO `manager` VALUES ('2', '1990010102', '1990', '2018-12-04 11:24:23');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL COMMENT '院系',
  `major_id` int(11) DEFAULT NULL COMMENT '专业',
  `grade` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `political_status` varchar(255) DEFAULT NULL COMMENT '政治面目',
  `nationality` varchar(255) DEFAULT NULL COMMENT '民族',
  `enrollment_date` datetime DEFAULT NULL COMMENT '入学日期',
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` tinyint(255) DEFAULT NULL COMMENT '0休学，1正常，2已毕业',
  `image` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id` (`student_id`),
  KEY `fk_student_department_1` (`department_id`),
  KEY `fk_student_major_1` (`major_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `fk_student_department_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `fk_student_major_1` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '111', '147258', 'simon', 'male', '11', '11001', '2015', '1511001', '共产党员', '汉', '2018-12-04 00:00:00', '147258', '1hello', '1', '/kk/m.jpg', '2018-11-29 09:34:40');
INSERT INTO `student` VALUES ('2', '222', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:10');
INSERT INTO `student` VALUES ('3', '333', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:19');
INSERT INTO `student` VALUES ('4', '444', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:20');
INSERT INTO `student` VALUES ('5', '555', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:20');
INSERT INTO `student` VALUES ('6', '666', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:21');
INSERT INTO `student` VALUES ('7', '777', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:21');
INSERT INTO `student` VALUES ('8', '888', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:22');
INSERT INTO `student` VALUES ('9', '999', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-12-02 22:06:23');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child_course_id` int(11) DEFAULT NULL COMMENT '子课程id',
  `student_id` int(11) DEFAULT NULL,
  `daily_score` decimal(10,0) DEFAULT NULL,
  `exam_score` decimal(10,0) DEFAULT NULL,
  `final_score` decimal(10,0) DEFAULT NULL,
  `credit` decimal(10,1) DEFAULT NULL COMMENT '学分',
  `state` tinyint(4) DEFAULT NULL COMMENT '（0挂科，1合格）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_student_course_child_course_1` (`child_course_id`),
  KEY `fk_student_course_student_1` (`student_id`),
  CONSTRAINT `fk_student_course_child_course_1` FOREIGN KEY (`child_course_id`) REFERENCES `child_course` (`child_course_id`),
  CONSTRAINT `fk_student_course_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('1', '101001', '111', '20', '50', '80', '3.2', '1', '2018-12-04 17:39:46');
INSERT INTO `student_course` VALUES ('2', '102001', '111', '30', '60', '90', '3.6', '1', '2018-12-04 17:41:03');
INSERT INTO `student_course` VALUES ('3', '103001', '111', '23', null, null, null, null, '2018-12-04 17:45:35');
INSERT INTO `student_course` VALUES ('4', '101001', '222', '20', '60', '80', '3.2', '1', '2018-12-05 11:29:06');
INSERT INTO `student_course` VALUES ('5', '101001', '333', null, null, null, null, null, '2018-12-05 11:29:08');
INSERT INTO `student_course` VALUES ('6', '101001', '444', null, null, null, null, null, '2018-12-05 11:29:16');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL COMMENT '院系',
  `office_address` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `political_status` varchar(255) DEFAULT NULL COMMENT '政治面目',
  `nationality` varchar(255) DEFAULT NULL COMMENT '民族',
  `enrollment_date` datetime DEFAULT NULL COMMENT '入职日期',
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` tinyint(255) DEFAULT NULL COMMENT '0休学，1正常，2已毕业',
  `image` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacher_id` (`teacher_id`) USING BTREE,
  KEY `fk_teacher_department_1` (`department_id`),
  CONSTRAINT `fk_teacher_department_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '10000', '456', '朱老师', 'male', '11', '中巴软件园101', '教授', '共产党员', '汉族', '2010-02-05 00:00:00', '15050505050', '教师公寓1栋', '1', '/lklk/oko/lll.jpg', '2018-12-04 11:23:26');
INSERT INTO `teacher` VALUES ('2', '10001', '456', '马老师', 'female', '12', '数学院202', '讲师', '共产党员', '汉族', '2018-12-13 01:52:10', '16060606060', '教师公寓1栋', '1', '/lklk/oko/lll.jpg', '2018-12-04 11:23:29');
INSERT INTO `teacher` VALUES ('3', '10002', 'newpassword', '杨老师', 'male', '11', '中巴软件园606', '副主任', '共产党员', '汉族', '2018-12-03 01:52:51', '12345679810', 'new address', '1', '/lklk/oko/lll.jpg', '2018-12-04 11:23:35');

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child_course_id` int(11) DEFAULT NULL COMMENT '子课程id',
  `teacher_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_teacher_course_child_course_1` (`child_course_id`),
  KEY `fk_teacher_course_teacher_1` (`teacher_id`),
  CONSTRAINT `fk_teacher_course_child_course_1` FOREIGN KEY (`child_course_id`) REFERENCES `child_course` (`child_course_id`),
  CONSTRAINT `fk_teacher_course_teacher_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('1', '101001', '10000', '2018-12-05 01:51:12');
INSERT INTO `teacher_course` VALUES ('2', '102001', '10001', '2018-12-05 01:53:34');
INSERT INTO `teacher_course` VALUES ('3', '103001', '10002', '2018-12-05 01:53:43');
INSERT INTO `teacher_course` VALUES ('4', '104001', '10002', '2018-12-05 10:31:37');
INSERT INTO `teacher_course` VALUES ('5', '105001', '10002', '2018-12-05 10:31:42');
INSERT INTO `teacher_course` VALUES ('6', '106001', '10002', '2018-12-05 10:31:46');
