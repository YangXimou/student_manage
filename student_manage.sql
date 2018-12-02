/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : student_manage

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-30 23:29:27
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
