/*
 Navicat Premium Data Transfer

 Source Server         : omv
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : omv:3306
 Source Schema         : iblogs

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 22/10/2020 00:21:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment`  (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT,
  `AuthorId` bigint(20) NULL DEFAULT NULL,
  `FName` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FType` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `FKey` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Attachments_AuthorId`(`AuthorId`) USING BTREE,
  CONSTRAINT `FK_Attachments_Users_AuthorId` FOREIGN KEY (`AuthorId`) REFERENCES `user` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blogsyncrelationship
-- ----------------------------
DROP TABLE IF EXISTS `blogsyncrelationship`;
CREATE TABLE `blogsyncrelationship`  (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT,
  `Created` datetime(6) NOT NULL,
  `Deleted` bit(1) NOT NULL,
  `ContentId` bigint(20) NULL DEFAULT NULL,
  `Target` int(11) NOT NULL,
  `TargetPostId` int(11) NULL DEFAULT NULL,
  `SyncData` datetime(6) NOT NULL,
  `Message` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ExtensionProperty` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Successful` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_BlogSyncRelationships_ContentId`(`ContentId`) USING BTREE,
  CONSTRAINT `FK_BlogSyncRelationships_Contents_ContentId` FOREIGN KEY (`ContentId`) REFERENCES `content` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT,
  `IsAuthor` bit(1) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  `Cid` bigint(20) NULL DEFAULT NULL,
  `Author` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `OwnerId` bigint(11) NOT NULL,
  `Mail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Ip` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Agent` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Type` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Status` int(11) NOT NULL,
  `Parent` bigint(11) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Comments_Cid`(`Cid`) USING BTREE,
  CONSTRAINT `FK_Comments_Contents_Cid` FOREIGN KEY (`Cid`) REFERENCES `content` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `Id` bigint(20) NOT NULL,
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
  `AuthorId` bigint(20) NULL DEFAULT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Contents_AuthorId`(`AuthorId`) USING BTREE,
  CONSTRAINT `FK_Contents_Users_AuthorId` FOREIGN KEY (`AuthorId`) REFERENCES `user` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for meta
-- ----------------------------
DROP TABLE IF EXISTS `meta`;
CREATE TABLE `meta`  (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Slug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Type` int(11) NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `Sort` int(11) NULL DEFAULT 0,
  `Parent` bigint(20) NULL DEFAULT 0,
  `Count` bigint(20) NULL DEFAULT 0,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for option
-- ----------------------------
DROP TABLE IF EXISTS `option`;
CREATE TABLE `option`  (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Value` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Visible` bit(1) NOT NULL DEFAULT b'0',
  `Editable` bit(1) NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for relationship
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship`  (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT,
  `Cid` bigint(20) NULL DEFAULT NULL,
  `Mid` bigint(20) NULL DEFAULT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Relationships_Cid`(`Cid`) USING BTREE,
  INDEX `IX_Relationships_Mid`(`Mid`) USING BTREE,
  CONSTRAINT `FK_Relationships_Contents_Cid` FOREIGN KEY (`Cid`) REFERENCES `content` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` bigint(20) NOT NULL,
  `Username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Created` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `Deleted` bit(1) NOT NULL,
  `Logged` datetime(6) NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
