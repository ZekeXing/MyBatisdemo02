/*
 Navicat Premium Data Transfer

 Source Server         : mydb
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mychina

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 30/11/2022 20:41:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `aid` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容',
  `titlepic` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `video` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '弘扬爱国主义精神', '弘扬爱国主义精神要从少年儿童抓起，要把爱国主义贯穿教育和精神文明建设全过程。要教育引导学生把自身的理想同祖国的前途、把自己的命运同民族的命运紧密联系在一起，引导学生树立和坚持正确的历史观、民族观、国家观、文化观，增强爱国意识和爱国情感，增强民族自豪感和自信心，让爱国主义精神在学生心中牢牢扎根，时刻不忘自己是中国人。\r\n\r\n——习近平2018年9月10日在全国教育大会上的讲话', NULL, '');
INSERT INTO `article` VALUES (2, '推进科技自立自强', '全面建设社会主义现代化强国，实现第二个百年奋斗目标，必须走自主创新之路。要时不我待推进科技自立自强，只争朝夕突破“卡脖子”问题，努力把关键核心技术和装备制造业掌握在我们自己手里。\r\n\r\n——习近平2022年8月16日至17日在辽宁考察时的讲话', NULL, NULL);
INSERT INTO `article` VALUES (3, '社会主义核心价值观', '富强、民主、文明、和谐是国家层面的价值目标，自由、平等、公正、法治是社会层面的价值取向，爱国、敬业、诚信、友善是公民个人层面的价值准则。', 'https://image.baidu.com/search/index?tn=baiduimage&ps=1&ct=201326592&lm=-1&cl=2&nc=1&ie=utf-', 'https://www.xuexi.cn/lgpage/detail/index.html?id=7956673194300354218');
INSERT INTO `article` VALUES (4, '创新精神', '创新是一个民族进步的灵魂，是国家兴亡发达不竭的动力。', NULL, NULL);
INSERT INTO `article` VALUES (5, '社会主义核心价值观', '富强、民主、文明、和谐，倡导自由、平等、公正、法治，倡导爱国、敬业、诚信、友善', NULL, NULL);
INSERT INTO `article` VALUES (7, '科技报国', '科技报国,强国有我', NULL, NULL);
INSERT INTO `article` VALUES (8, '大老鼠', NULL, 'a788cf69-5599-4cc3-b0a5-b830750c83a4_未标题-1.png', NULL);
INSERT INTO `article` VALUES (9, 'miku', '2', 'ad3d2d9a-772a-437f-808c-682d876cfb0c_屏幕截图 2022-11-26 090146.jpg', NULL);
INSERT INTO `article` VALUES (10, '测试main307', '3', '6179027d-873e-4861-ab5b-e2049fefdbee_5718d8533ba08c920b3c0a47e2d5c92.jpg', NULL);
INSERT INTO `article` VALUES (11, '4', '4', NULL, NULL);
INSERT INTO `article` VALUES (12, '5', '5', NULL, NULL);
INSERT INTO `article` VALUES (13, '6', '6', NULL, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论内容',
  `author` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论作者',
  `aid` int(0) DEFAULT NULL COMMENT '关联的文章id',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '我爱你中国！！', '狂奔的蜗牛', 1);
INSERT INTO `comment` VALUES (2, '中国是最强的！', 'tom', 1);
INSERT INTO `comment` VALUES (3, '为中国速度点赞！', 'kitty', 1);
INSERT INTO `comment` VALUES (4, '作为中国人我感到非常自豪~~~', '我是中国人', 1);
INSERT INTO `comment` VALUES (5, '自强自立从科技崛起开始', '张杨', 2);
INSERT INTO `comment` VALUES (6, '111', 'znx', 1);
INSERT INTO `comment` VALUES (7, '111', 'znx', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `passWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'znx', '123');
INSERT INTO `user` VALUES (2, 'abc', '456');

SET FOREIGN_KEY_CHECKS = 1;
