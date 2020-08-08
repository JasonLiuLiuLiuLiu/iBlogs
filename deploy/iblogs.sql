/*
 Navicat Premium Data Transfer

 Source Server         : centos-dev1
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : centos-dev1:3306
 Source Schema         : iblogs

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 27/04/2020 22:41:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Attachments
-- ----------------------------
DROP TABLE IF EXISTS `Attachments`;
CREATE TABLE `Attachments`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AuthorId` int(11) NOT NULL,
  `FName` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FType` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FKey` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Attachments_AuthorId`(`AuthorId`) USING BTREE,
  CONSTRAINT `FK_Attachments_Users_AuthorId` FOREIGN KEY (`AuthorId`) REFERENCES `Users` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for BlogSyncRelationships
-- ----------------------------
DROP TABLE IF EXISTS `BlogSyncRelationships`;
CREATE TABLE `BlogSyncRelationships`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Created` datetime(6) NOT NULL,
  `Deleted` bit(1) NOT NULL,
  `ContentId` int(11) NOT NULL,
  `Target` int(11) NOT NULL,
  `TargetPostId` int(11) NULL DEFAULT NULL,
  `SyncData` datetime(6) NOT NULL,
  `Message` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ExtensionProperty` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Successful` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_BlogSyncRelationships_ContentId`(`ContentId`) USING BTREE,
  CONSTRAINT `FK_BlogSyncRelationships_Contents_ContentId` FOREIGN KEY (`ContentId`) REFERENCES `Contents` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for Comments
-- ----------------------------
DROP TABLE IF EXISTS `Comments`;
CREATE TABLE `Comments`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IsAuthor` bit(1) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  `Cid` int(11) NOT NULL,
  `Author` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `OwnerId` int(11) NOT NULL,
  `Mail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Ip` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Agent` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Type` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Status` int(11) NOT NULL,
  `Parent` int(11) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Comments_Cid`(`Cid`) USING BTREE,
  CONSTRAINT `FK_Comments_Contents_Cid` FOREIGN KEY (`Cid`) REFERENCES `Contents` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for Contents
-- ----------------------------
DROP TABLE IF EXISTS `Contents`;
CREATE TABLE `Contents`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Slug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Modified` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `Content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Hits` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  `FmtType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ThumbImg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Categories` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Status` int(11) NOT NULL,
  `CommentsNum` int(11) NOT NULL,
  `AllowComment` bit(1) NOT NULL,
  `AllowPing` bit(1) NOT NULL,
  `AllowFeed` bit(1) NOT NULL,
  `Url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `AuthorId` int(11) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Contents_AuthorId`(`AuthorId`) USING BTREE,
  CONSTRAINT `FK_Contents_Users_AuthorId` FOREIGN KEY (`AuthorId`) REFERENCES `Users` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for Metas
-- ----------------------------
DROP TABLE IF EXISTS `Metas`;
CREATE TABLE `Metas`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Slug` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Type` int(11) NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Sort` int(11) NOT NULL,
  `Parent` int(11) NOT NULL,
  `Count` int(11) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for Options
-- ----------------------------
DROP TABLE IF EXISTS `Options`;
CREATE TABLE `Options`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Value` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Editable` bit(1) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for Relationships
-- ----------------------------
DROP TABLE IF EXISTS `Relationships`;
CREATE TABLE `Relationships`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cid` int(11) NOT NULL,
  `Mid` int(11) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Relationships_Cid`(`Cid`) USING BTREE,
  INDEX `IX_Relationships_Mid`(`Mid`) USING BTREE,
  CONSTRAINT `FK_Relationships_Contents_Cid` FOREIGN KEY (`Cid`) REFERENCES `Contents` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationships_Metas_Mid` FOREIGN KEY (`Mid`) REFERENCES `Metas` (`Id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for Users
-- ----------------------------
DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Password` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Email` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `HomeUrl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `ScreenName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  `Activated` datetime(6) NOT NULL,
  `Logged` datetime(6) NOT NULL,
  `GroupName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
