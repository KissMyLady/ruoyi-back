-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: ry_vue
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gen_table`
--

DROP TABLE IF EXISTS `gen_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gen_table` (
  `table_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成业务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table`
--

LOCK TABLES `gen_table` WRITE;
/*!40000 ALTER TABLE `gen_table` DISABLE KEYS */;
INSERT INTO `gen_table` VALUES (12,'llm_chat_log','语言模型,聊天记录表',NULL,NULL,'LlmChatLog','crud','com.ruoyi.platform.llm_chat_log','llm_chat_log','llm_chat_log','语言模型聊天记录','mylady','0','/','{\"parentMenuId\":2000}','admin','2023-09-23 09:40:39','','2023-09-23 09:41:43',NULL),(13,'llm_claude_key','语言模型,api,claude连接池',NULL,NULL,'LlmClaudeKey','crud','com.ruoyi.platform.llm_claude_key','llm_claude_key','llm_claude_key','语言模型,api,claude连接池','mylady','0','/','{\"parentMenuId\":2000}','admin','2023-09-23 09:40:39','','2023-09-23 10:09:34',NULL);
/*!40000 ALTER TABLE `gen_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_table_column`
--

DROP TABLE IF EXISTS `gen_table_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gen_table_column` (
  `column_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` bigint DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成业务表字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table_column`
--

LOCK TABLES `gen_table_column` WRITE;
/*!40000 ALTER TABLE `gen_table_column` DISABLE KEYS */;
INSERT INTO `gen_table_column` VALUES (131,12,'id','主键','int','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(132,12,'user','聊天用户','varchar(32)','String','user','0','0',NULL,'1','1','1','1','EQ','input','',2,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(133,12,'user_device_type','操作类别（0其它 1后台用户 2手机端用户）','int','Long','userDeviceType','0','0',NULL,'1','1','1','1','EQ','select','',3,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(134,12,'user_ip','ip地址','varchar(128)','String','userIp','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(135,12,'user_address','聊天用户地址','varchar(128)','String','userAddress','0','0',NULL,'1','1','1','1','EQ','input','',5,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(136,12,'user_agent','请求头','varchar(512)','String','userAgent','0','0',NULL,'1','1','1','1','EQ','textarea','',6,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(137,12,'user_browser','浏览器','varchar(64)','String','userBrowser','0','0',NULL,'1','1','1','1','EQ','input','',7,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(138,12,'user_system','操作系统','varchar(32)','String','userSystem','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(139,12,'role_name','角色名称','varchar(64)','String','roleName','0','0',NULL,'1','1','1','1','LIKE','input','',9,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(140,12,'current_role_name','当前聊天角色','varchar(64)','String','currentRoleName','0','0',NULL,'1','1','1','1','LIKE','input','',10,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(141,12,'llm','当前聊天语言模型','varchar(64)','String','llm','0','0',NULL,'1','1','1','1','EQ','input','',11,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(142,12,'prompt','输入内容','text','String','prompt','0','0',NULL,'1','1','1','1','EQ','textarea','',12,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(143,12,'response','输出内容','text','String','response','0','0',NULL,'1','1','1','1','EQ','textarea','',13,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(144,12,'consume_time','计算耗时','varchar(16)','String','consumeTime','0','0',NULL,'1','1','1','1','EQ','input','',14,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(145,12,'history','当前聊天的历史内容','text','String','history','0','0',NULL,'1','1','1','1','EQ','textarea','',15,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(146,12,'req_params','操作提交的数据','text','String','reqParams','0','0',NULL,'1','1','1','1','EQ','textarea','',16,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(147,12,'is_delete','历史记录','tinyint(1)','Integer','isDelete','0','0',NULL,'1','1','1','1','EQ','input','',17,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(148,12,'create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',18,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(149,12,'update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',19,'admin','2023-09-23 09:40:39','','2023-09-23 09:41:43'),(150,13,'id','主键','int','Long','id','1','1',NULL,'1',NULL,NULL,NULL,'EQ','input','',1,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(151,13,'api_type','类别名称','varchar(32)','String','apiType','0','0',NULL,'1','1','1','1','EQ','select','',2,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(152,13,'info','备注信息','varchar(32)','String','info','0','0',NULL,'1','1','1','1','EQ','input','',3,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(153,13,'org_uuid','org_uuid','varchar(255)','String','orgUuid','0','0',NULL,'1','1','1','1','EQ','input','',4,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(154,13,'sessionKey','sessionKey','varchar(255)','String','sessionKey','0','0',NULL,'1','1','1','1','EQ','input','',5,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(155,13,'conversation_uuid','conversation_uuid','varchar(255)','String','conversationUuid','0','0',NULL,'1','1','1','1','EQ','input','',6,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(156,13,'create_user','创建人','varchar(255)','String','createUser','0','0',NULL,'1','1','1','1','EQ','input','',7,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(157,13,'is_delete','删除标记','tinyint(1)','Integer','isDelete','0','0',NULL,'1','1','1','1','EQ','input','',8,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(158,13,'create_time','创建时间','datetime','Date','createTime','0','0',NULL,'1',NULL,NULL,NULL,'EQ','datetime','',9,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34'),(159,13,'update_time','更新时间','datetime','Date','updateTime','0','0',NULL,'1','1',NULL,NULL,'EQ','datetime','',10,'admin','2023-09-23 09:40:39','','2023-09-23 10:09:34');
/*!40000 ALTER TABLE `gen_table_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llm_chat_log`
--

DROP TABLE IF EXISTS `llm_chat_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `llm_chat_log` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user` varchar(32) DEFAULT NULL COMMENT '聊天用户',
  `user_device_type` int DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `user_ip` varchar(128) DEFAULT NULL COMMENT 'ip地址',
  `user_address` varchar(128) DEFAULT NULL COMMENT '聊天用户地址',
  `user_agent` varchar(512) DEFAULT NULL COMMENT '请求头',
  `user_browser` varchar(64) DEFAULT NULL COMMENT '浏览器',
  `user_system` varchar(32) DEFAULT NULL COMMENT '操作系统',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `current_role_name` varchar(64) DEFAULT NULL COMMENT '当前聊天角色',
  `llm` varchar(64) DEFAULT NULL COMMENT '当前聊天语言模型',
  `prompt` text COMMENT '输入内容',
  `response` text COMMENT '输出内容',
  `consume_time` varchar(16) DEFAULT NULL COMMENT '计算耗时',
  `history` text COMMENT '当前聊天的历史内容',
  `req_params` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '操作提交的数据',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '历史记录',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='语言模型,聊天记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llm_chat_log`
--

LOCK TABLES `llm_chat_log` WRITE;
/*!40000 ALTER TABLE `llm_chat_log` DISABLE KEYS */;
INSERT INTO `llm_chat_log` VALUES (1,'1',0,NULL,'中国,杭州',NULL,'Chrom11','windows10','猫娘','主人','ChatGLM2GPT','我们如何在日常生活中减少用水？','猫娘:「我们可以尝试使用可重复使用的餐具和杯子来减少用水量。我们还可以在洗衣服时使用低泡洗涤剂，减少用水量。此外，我们还可以在洗澡时使用淋浴代替泡澡，减少用水量。」','19.03','','{\'prompt\': \'我们如何在日常生活中减少用水？\', \'current_role_name\': \'主人\', \'role_name\': \'猫娘\', \'llm\': \'ChatGLM2GPT\'}',0,'2023-09-23 09:32:41','2023-09-23 10:01:11'),(2,NULL,1,'127.0.0.1',NULL,NULL,NULL,NULL,NULL,NULL,'claude_api',NULL,'响应返回数据','2秒',NULL,'请求数据',0,'2023-09-23 15:51:52','2023-09-23 15:51:52'),(3,'',0,'192.168.1.106',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','',NULL,'',0,'2023-09-23 15:59:19','2023-09-23 15:59:19'),(4,NULL,1,'127.0.0.1',NULL,NULL,NULL,NULL,NULL,NULL,'claude_api','你好啊','响应返回数据','2秒',NULL,'请求数据',0,'2023-09-23 16:12:42','2023-09-23 16:12:42'),(5,'',0,'192.168.1.106',NULL,NULL,NULL,NULL,NULL,NULL,'','你好中国','','',NULL,'',0,'2023-09-23 16:13:27','2023-09-23 16:13:27'),(6,NULL,1,'127.0.0.1',NULL,NULL,NULL,NULL,NULL,NULL,'claude_api','你好啊','响应返回数据','2秒',NULL,'请求数据',0,'2023-09-23 16:14:59','2023-09-23 16:14:59'),(7,'用户A',1,'127.0.0.1','局域网','浏览器请求头','Chrom11','windows','猫娘','主人','claude','你好啊','你好,我是猫娘, 很高兴见到你','5秒','[历史记录]','{请求数据}',0,'2023-09-23 17:27:14','2023-09-23 17:27:14'),(8,'用户A',1,'127.0.0.1','局域网','浏览器请求头','Chrom11','windows','猫娘','主人','claude','你好啊','你好,我是猫娘, 很高兴见到你','5秒','[历史记录]','{请求数据}',0,'2023-09-23 17:31:45','2023-09-23 17:31:45'),(9,'用户A',1,'127.0.0.1','局域网','浏览器请求头','Chrom11','windows','猫娘','主人','claude','你好啊','你好,我是猫娘, 很高兴见到你','5秒','[历史记录]','{请求数据}',0,'2023-09-23 17:32:04','2023-09-23 17:32:04'),(10,'无状态用户',1,'ipaddress','局域网','浏览器请求头','Chrom11','windows','role_name','current_role_name','llm','prompt','response','3.25','history','{json_post_list}',0,'2023-09-23 17:34:52','2023-09-23 17:34:52'),(11,'无状态用户',1,'39.99.228.188','中国 浙江省 杭州','userAgent','req_browser','req_system','role_name','current_role_name','llm','prompt','response','3.25','history','{json_post_list}',0,'2023-09-23 17:52:47','2023-09-23 17:52:47');
/*!40000 ALTER TABLE `llm_chat_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llm_claude_key`
--

DROP TABLE IF EXISTS `llm_claude_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `llm_claude_key` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_type` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `info` varchar(32) DEFAULT NULL COMMENT '备注信息',
  `org_uuid` varchar(255) DEFAULT NULL COMMENT 'org_uuid',
  `sessionKey` varchar(255) DEFAULT NULL COMMENT 'sessionKey',
  `conversation_uuid` varchar(255) DEFAULT NULL COMMENT 'conversation_uuid',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='语言模型,api,claude连接池';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llm_claude_key`
--

LOCK TABLES `llm_claude_key` WRITE;
/*!40000 ALTER TABLE `llm_claude_key` DISABLE KEYS */;
INSERT INTO `llm_claude_key` VALUES (1,'claude_api','公司账号 可用','da6a9b74-dc65-4a1f-b0a5-7a0ee151b911','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','774cc912-0f97-4adb-9a67-abd802da7d85','nv科技',0,'2023-09-23 09:31:32','2023-09-23 09:31:32'),(2,'claude_api111','测试内容','删除标记控制内容','删除标记控制内容','删除标记控制内容','删除标记控制内容',1,'2023-09-23 09:31:38','2023-09-23 10:18:23');
/*!40000 ALTER TABLE `llm_claude_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_config` (
  `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2023-09-16 11:10:42','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2023-09-16 11:10:42','',NULL,'初始化密码 123456'),(3,'主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2023-09-16 11:10:42','',NULL,'深色主题theme-dark，浅色主题theme-light'),(4,'账号自助-验证码开关','sys.account.captchaEnabled','true','Y','admin','2023-09-16 11:10:42','',NULL,'是否开启验证码功能（true开启，false关闭）'),(5,'账号自助-是否开启用户注册功能','sys.account.registerUser','false','Y','admin','2023-09-16 11:10:42','',NULL,'是否开启注册用户功能（true开启，false关闭）'),(6,'用户登录-黑名单列表','sys.login.blackIPList','','Y','admin','2023-09-16 11:10:42','',NULL,'设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (100,0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(101,100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(102,100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(103,101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(104,101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(105,101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(106,101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(107,101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(108,102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL),(109,102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2023-09-16 11:10:41','',NULL);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES (1,1,'男','0','sys_user_sex','','','Y','0','admin','2023-09-16 11:10:42','',NULL,'性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2023-09-16 11:10:42','',NULL,'性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2023-09-16 11:10:42','',NULL,'性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2023-09-16 11:10:42','',NULL,'显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2023-09-16 11:10:42','',NULL,'正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2023-09-16 11:10:42','',NULL,'正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'停用状态'),(10,1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2023-09-16 11:10:42','',NULL,'默认分组'),(11,2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2023-09-16 11:10:42','',NULL,'系统分组'),(12,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2023-09-16 11:10:42','',NULL,'系统默认是'),(13,2,'否','N','sys_yes_no','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'系统默认否'),(14,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2023-09-16 11:10:42','',NULL,'通知'),(15,2,'公告','2','sys_notice_type','','success','N','0','admin','2023-09-16 11:10:42','',NULL,'公告'),(16,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2023-09-16 11:10:42','',NULL,'正常状态'),(17,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'关闭状态'),(18,99,'其他','0','sys_oper_type','','info','N','0','admin','2023-09-16 11:10:42','',NULL,'其他操作'),(19,1,'新增','1','sys_oper_type','','info','N','0','admin','2023-09-16 11:10:42','',NULL,'新增操作'),(20,2,'修改','2','sys_oper_type','','info','N','0','admin','2023-09-16 11:10:42','',NULL,'修改操作'),(21,3,'删除','3','sys_oper_type','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'删除操作'),(22,4,'授权','4','sys_oper_type','','primary','N','0','admin','2023-09-16 11:10:42','',NULL,'授权操作'),(23,5,'导出','5','sys_oper_type','','warning','N','0','admin','2023-09-16 11:10:42','',NULL,'导出操作'),(24,6,'导入','6','sys_oper_type','','warning','N','0','admin','2023-09-16 11:10:42','',NULL,'导入操作'),(25,7,'强退','7','sys_oper_type','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'强退操作'),(26,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2023-09-16 11:10:42','',NULL,'生成操作'),(27,9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'清空操作'),(28,1,'成功','0','sys_common_status','','primary','N','0','admin','2023-09-16 11:10:42','',NULL,'正常状态'),(29,2,'失败','1','sys_common_status','','danger','N','0','admin','2023-09-16 11:10:42','',NULL,'停用状态');
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES (1,'用户性别','sys_user_sex','0','admin','2023-09-16 11:10:41','',NULL,'用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2023-09-16 11:10:41','',NULL,'菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2023-09-16 11:10:41','',NULL,'系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2023-09-16 11:10:41','',NULL,'任务状态列表'),(5,'任务分组','sys_job_group','0','admin','2023-09-16 11:10:41','',NULL,'任务分组列表'),(6,'系统是否','sys_yes_no','0','admin','2023-09-16 11:10:41','',NULL,'系统是否列表'),(7,'通知类型','sys_notice_type','0','admin','2023-09-16 11:10:42','',NULL,'通知类型列表'),(8,'通知状态','sys_notice_status','0','admin','2023-09-16 11:10:42','',NULL,'通知状态列表'),(9,'操作类型','sys_oper_type','0','admin','2023-09-16 11:10:42','',NULL,'操作类型列表'),(10,'系统状态','sys_common_status','0','admin','2023-09-16 11:10:42','',NULL,'登录状态列表');
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job`
--

DROP TABLE IF EXISTS `sys_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job` (
  `job_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务调度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job`
--

LOCK TABLES `sys_job` WRITE;
/*!40000 ALTER TABLE `sys_job` DISABLE KEYS */;
INSERT INTO `sys_job` VALUES (1,'系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2023-09-16 11:10:42','',NULL,''),(2,'系统默认（有参）','DEFAULT','ryTask.ryParams(\'ry\')','0/15 * * * * ?','3','1','1','admin','2023-09-16 11:10:42','',NULL,''),(3,'系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2023-09-16 11:10:42','',NULL,'');
/*!40000 ALTER TABLE `sys_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job_log`
--

DROP TABLE IF EXISTS `sys_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务调度日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job_log`
--

LOCK TABLES `sys_job_log` WRITE;
/*!40000 ALTER TABLE `sys_job_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logininfor`
--

DROP TABLE IF EXISTS `sys_logininfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`),
  KEY `idx_sys_logininfor_s` (`status`),
  KEY `idx_sys_logininfor_lt` (`login_time`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统访问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logininfor`
--

LOCK TABLES `sys_logininfor` WRITE;
/*!40000 ALTER TABLE `sys_logininfor` DISABLE KEYS */;
INSERT INTO `sys_logininfor` VALUES (100,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-16 11:12:05'),(101,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-16 16:26:53'),(102,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-18 16:26:28'),(103,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-18 16:26:32'),(104,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-18 16:34:12'),(105,'ry','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-18 16:34:17'),(106,'ry','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-18 16:35:14'),(107,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-18 16:35:19'),(108,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-18 16:35:23'),(109,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-18 16:37:03'),(110,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-18 16:37:11'),(111,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-21 14:31:08'),(112,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-21 14:31:14'),(113,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 09:08:45'),(114,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 10:15:21'),(115,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 10:15:24'),(116,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 10:16:48'),(117,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 10:16:58'),(118,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 10:17:53'),(119,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 10:17:58'),(120,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 10:20:24'),(121,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 10:20:28'),(122,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 10:20:59'),(123,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-22 10:21:02'),(124,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 10:21:05'),(125,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:07:10'),(126,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:15:43'),(127,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:15:47'),(128,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:16:42'),(129,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-22 11:16:51'),(130,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:17:03'),(131,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:17:42'),(132,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:17:46'),(133,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:18:01'),(134,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-22 11:18:05'),(135,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:18:08'),(136,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:18:44'),(137,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:18:47'),(138,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:20:18'),(139,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:20:21'),(140,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:25:00'),(141,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:25:19'),(142,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:25:19'),(143,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','1','验证码错误','2023-09-22 11:26:07'),(144,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:33:41'),(145,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 11:37:43'),(146,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 11:37:46'),(147,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','退出成功','2023-09-22 12:09:23'),(148,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 12:09:27'),(149,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 13:49:29'),(150,'admin','192.168.1.10','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 16:34:19'),(151,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-22 19:52:18'),(152,'admin','127.0.0.1','内网IP','Chrome 11','Windows 10','0','登录成功','2023-09-23 09:40:05');
/*!40000 ALTER TABLE `sys_logininfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
  `is_frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',0,1,'system',NULL,'',1,0,'M','0','0','','system','admin','2023-09-16 11:10:41','',NULL,'系统管理目录'),(2,'系统监控',0,2,'monitor',NULL,'',1,0,'M','0','0','','monitor','admin','2023-09-16 11:10:41','',NULL,'系统监控目录'),(3,'系统工具',0,3,'tool',NULL,'',1,0,'M','0','0','','tool','admin','2023-09-16 11:10:41','',NULL,'系统工具目录'),(100,'用户管理',1,1,'user','system/user/index','',1,0,'C','0','0','system:user:list','user','admin','2023-09-16 11:10:41','',NULL,'用户管理菜单'),(101,'角色管理',1,2,'role','system/role/index','',1,0,'C','0','0','system:role:list','peoples','admin','2023-09-16 11:10:41','',NULL,'角色管理菜单'),(102,'菜单管理',1,3,'menu','system/menu/index','',1,0,'C','0','0','system:menu:list','tree-table','admin','2023-09-16 11:10:41','',NULL,'菜单管理菜单'),(103,'部门管理',1,4,'dept','system/dept/index','',1,0,'C','0','0','system:dept:list','tree','admin','2023-09-16 11:10:41','',NULL,'部门管理菜单'),(104,'岗位管理',1,5,'post','system/post/index','',1,0,'C','0','0','system:post:list','post','admin','2023-09-16 11:10:41','',NULL,'岗位管理菜单'),(105,'字典管理',1,6,'dict','system/dict/index','',1,0,'C','0','0','system:dict:list','dict','admin','2023-09-16 11:10:41','',NULL,'字典管理菜单'),(106,'参数设置',1,7,'config','system/config/index','',1,0,'C','0','0','system:config:list','edit','admin','2023-09-16 11:10:41','',NULL,'参数设置菜单'),(107,'通知公告',1,8,'notice','system/notice/index','',1,0,'C','0','0','system:notice:list','message','admin','2023-09-16 11:10:41','',NULL,'通知公告菜单'),(108,'日志管理',1,9,'log','','',1,0,'M','0','0','','log','admin','2023-09-16 11:10:41','',NULL,'日志管理菜单'),(109,'在线用户',2,1,'online','monitor/online/index','',1,0,'C','0','0','monitor:online:list','online','admin','2023-09-16 11:10:41','',NULL,'在线用户菜单'),(110,'定时任务',2,2,'job','monitor/job/index','',1,0,'C','0','1','monitor:job:list','job','admin','2023-09-16 11:10:41','admin','2023-09-22 15:10:03','定时任务菜单'),(111,'数据监控',2,3,'druid','monitor/druid/index','',1,0,'C','0','0','monitor:druid:list','druid','admin','2023-09-16 11:10:41','',NULL,'数据监控菜单'),(112,'服务监控',2,4,'server','monitor/server/index','',1,0,'C','0','0','monitor:server:list','server','admin','2023-09-16 11:10:41','',NULL,'服务监控菜单'),(113,'缓存监控',2,5,'cache','monitor/cache/index','',1,0,'C','0','0','monitor:cache:list','redis','admin','2023-09-16 11:10:41','',NULL,'缓存监控菜单'),(114,'缓存列表',2,6,'cacheList','monitor/cache/list','',1,0,'C','0','0','monitor:cache:list','redis-list','admin','2023-09-16 11:10:41','',NULL,'缓存列表菜单'),(115,'表单构建',3,1,'build','tool/build/index','',1,0,'C','0','0','tool:build:list','build','admin','2023-09-16 11:10:41','',NULL,'表单构建菜单'),(116,'代码生成',3,2,'gen','tool/gen/index','',1,0,'C','0','0','tool:gen:list','code','admin','2023-09-16 11:10:41','',NULL,'代码生成菜单'),(117,'系统接口',3,3,'swagger','tool/swagger/index','',1,0,'C','0','0','tool:swagger:list','swagger','admin','2023-09-16 11:10:41','',NULL,'系统接口菜单'),(500,'操作日志',108,1,'operlog','monitor/operlog/index','',1,0,'C','0','0','monitor:operlog:list','form','admin','2023-09-16 11:10:41','',NULL,'操作日志菜单'),(501,'登录日志',108,2,'logininfor','monitor/logininfor/index','',1,0,'C','0','0','monitor:logininfor:list','logininfor','admin','2023-09-16 11:10:41','',NULL,'登录日志菜单'),(1000,'用户查询',100,1,'','','',1,0,'F','0','0','system:user:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1001,'用户新增',100,2,'','','',1,0,'F','0','0','system:user:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1002,'用户修改',100,3,'','','',1,0,'F','0','0','system:user:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1003,'用户删除',100,4,'','','',1,0,'F','0','0','system:user:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1004,'用户导出',100,5,'','','',1,0,'F','0','0','system:user:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1005,'用户导入',100,6,'','','',1,0,'F','0','0','system:user:import','#','admin','2023-09-16 11:10:41','',NULL,''),(1006,'重置密码',100,7,'','','',1,0,'F','0','0','system:user:resetPwd','#','admin','2023-09-16 11:10:41','',NULL,''),(1007,'角色查询',101,1,'','','',1,0,'F','0','0','system:role:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1008,'角色新增',101,2,'','','',1,0,'F','0','0','system:role:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1009,'角色修改',101,3,'','','',1,0,'F','0','0','system:role:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1010,'角色删除',101,4,'','','',1,0,'F','0','0','system:role:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1011,'角色导出',101,5,'','','',1,0,'F','0','0','system:role:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1012,'菜单查询',102,1,'','','',1,0,'F','0','0','system:menu:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1013,'菜单新增',102,2,'','','',1,0,'F','0','0','system:menu:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1014,'菜单修改',102,3,'','','',1,0,'F','0','0','system:menu:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1015,'菜单删除',102,4,'','','',1,0,'F','0','0','system:menu:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1016,'部门查询',103,1,'','','',1,0,'F','0','0','system:dept:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1017,'部门新增',103,2,'','','',1,0,'F','0','0','system:dept:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1018,'部门修改',103,3,'','','',1,0,'F','0','0','system:dept:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1019,'部门删除',103,4,'','','',1,0,'F','0','0','system:dept:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1020,'岗位查询',104,1,'','','',1,0,'F','0','0','system:post:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1021,'岗位新增',104,2,'','','',1,0,'F','0','0','system:post:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1022,'岗位修改',104,3,'','','',1,0,'F','0','0','system:post:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1023,'岗位删除',104,4,'','','',1,0,'F','0','0','system:post:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1024,'岗位导出',104,5,'','','',1,0,'F','0','0','system:post:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1025,'字典查询',105,1,'#','','',1,0,'F','0','0','system:dict:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1026,'字典新增',105,2,'#','','',1,0,'F','0','0','system:dict:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1027,'字典修改',105,3,'#','','',1,0,'F','0','0','system:dict:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1028,'字典删除',105,4,'#','','',1,0,'F','0','0','system:dict:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1029,'字典导出',105,5,'#','','',1,0,'F','0','0','system:dict:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1030,'参数查询',106,1,'#','','',1,0,'F','0','0','system:config:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1031,'参数新增',106,2,'#','','',1,0,'F','0','0','system:config:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1032,'参数修改',106,3,'#','','',1,0,'F','0','0','system:config:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1033,'参数删除',106,4,'#','','',1,0,'F','0','0','system:config:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1034,'参数导出',106,5,'#','','',1,0,'F','0','0','system:config:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1035,'公告查询',107,1,'#','','',1,0,'F','0','0','system:notice:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1036,'公告新增',107,2,'#','','',1,0,'F','0','0','system:notice:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1037,'公告修改',107,3,'#','','',1,0,'F','0','0','system:notice:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1038,'公告删除',107,4,'#','','',1,0,'F','0','0','system:notice:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1039,'操作查询',500,1,'#','','',1,0,'F','0','0','monitor:operlog:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1040,'操作删除',500,2,'#','','',1,0,'F','0','0','monitor:operlog:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1041,'日志导出',500,3,'#','','',1,0,'F','0','0','monitor:operlog:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1042,'登录查询',501,1,'#','','',1,0,'F','0','0','monitor:logininfor:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1043,'登录删除',501,2,'#','','',1,0,'F','0','0','monitor:logininfor:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1044,'日志导出',501,3,'#','','',1,0,'F','0','0','monitor:logininfor:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1045,'账户解锁',501,4,'#','','',1,0,'F','0','0','monitor:logininfor:unlock','#','admin','2023-09-16 11:10:41','',NULL,''),(1046,'在线查询',109,1,'#','','',1,0,'F','0','0','monitor:online:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1047,'批量强退',109,2,'#','','',1,0,'F','0','0','monitor:online:batchLogout','#','admin','2023-09-16 11:10:41','',NULL,''),(1048,'单条强退',109,3,'#','','',1,0,'F','0','0','monitor:online:forceLogout','#','admin','2023-09-16 11:10:41','',NULL,''),(1049,'任务查询',110,1,'#','','',1,0,'F','0','0','monitor:job:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1050,'任务新增',110,2,'#','','',1,0,'F','0','0','monitor:job:add','#','admin','2023-09-16 11:10:41','',NULL,''),(1051,'任务修改',110,3,'#','','',1,0,'F','0','0','monitor:job:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1052,'任务删除',110,4,'#','','',1,0,'F','0','0','monitor:job:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1053,'状态修改',110,5,'#','','',1,0,'F','0','0','monitor:job:changeStatus','#','admin','2023-09-16 11:10:41','',NULL,''),(1054,'任务导出',110,6,'#','','',1,0,'F','0','0','monitor:job:export','#','admin','2023-09-16 11:10:41','',NULL,''),(1055,'生成查询',116,1,'#','','',1,0,'F','0','0','tool:gen:query','#','admin','2023-09-16 11:10:41','',NULL,''),(1056,'生成修改',116,2,'#','','',1,0,'F','0','0','tool:gen:edit','#','admin','2023-09-16 11:10:41','',NULL,''),(1057,'生成删除',116,3,'#','','',1,0,'F','0','0','tool:gen:remove','#','admin','2023-09-16 11:10:41','',NULL,''),(1058,'导入代码',116,4,'#','','',1,0,'F','0','0','tool:gen:import','#','admin','2023-09-16 11:10:41','',NULL,''),(1059,'预览代码',116,5,'#','','',1,0,'F','0','0','tool:gen:preview','#','admin','2023-09-16 11:10:41','',NULL,''),(1060,'生成代码',116,6,'#','','',1,0,'F','0','0','tool:gen:code','#','admin','2023-09-16 11:10:41','',NULL,''),(2000,'平台管理',0,1,'platform',NULL,NULL,1,0,'M','0','0','','code','admin','2023-09-22 13:58:08','admin','2023-09-22 14:50:46',''),(2001,'系统码表',2000,1,'sys_option','platform/sys_option/index',NULL,1,0,'C','0','0','sys_option','chart','admin','2023-09-22 13:59:59','',NULL,''),(2002,'聊天记录',2000,2,'llm_chat_log','platform/llm_chat_log/index',NULL,1,0,'C','0','0','llm_chat_log','date-range','admin','2023-09-23 09:46:51','admin','2023-09-23 10:04:02',''),(2003,'claude账号池',2000,3,'llm_claude_key','platform/llm_claude_key/index',NULL,1,0,'C','0','0','llm_claude_key','code','admin','2023-09-23 10:13:39','',NULL,'');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='通知公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
INSERT INTO `sys_notice` VALUES (1,'温馨提醒：2018-07-01 若依新版本发布啦','2',_binary '新版本内容','0','admin','2023-09-16 11:10:42','',NULL,'管理员'),(2,'维护通知：2018-07-01 若依系统凌晨维护','1',_binary '维护内容','0','admin','2023-09-16 11:10:42','',NULL,'管理员');
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT NULL COMMENT '模块标题',
  `business_type` int DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT NULL COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT NULL COMMENT '请求方式',
  `operator_type` int DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT NULL COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT NULL COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT NULL COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `req_agent` varchar(512) DEFAULT NULL COMMENT '请求头',
  `req_browser` varchar(64) DEFAULT NULL COMMENT '浏览器',
  `req_system` varchar(32) DEFAULT NULL COMMENT '操作系统',
  `oper_param` text COMMENT '请求参数',
  `json_result` text COMMENT '返回参数',
  `status` int DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` text COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  `cost_time` bigint DEFAULT '0' COMMENT '消耗时间',
  PRIMARY KEY (`oper_id`),
  KEY `idx_sys_oper_log_bt` (`business_type`),
  KEY `idx_sys_oper_log_ot` (`oper_time`),
  KEY `idx_sys_oper_log_s` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
INSERT INTO `sys_oper_log` VALUES (1,'角色管理',1,'com.ruoyi.web.controller.system.SysRoleController.add()','POST',1,'admin',NULL,'/system/role','127.0.0.1','内网IP',NULL,'谷歌浏览器',NULL,'{\"admin\":false,\"createBy\":\"admin\",\"deptCheckStrictly\":true,\"deptIds\":[],\"flag\":false,\"menuCheckStrictly\":true,\"menuIds\":[],\"params\":{},\"roleId\":101,\"roleKey\":\"vip_custom\",\"roleName\":\"vip客户\",\"roleSort\":0,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-21 14:57:50',0,63),(2,'角色管理',1,'com.ruoyi.web.controller.system.SysRoleController.add()','POST',1,'admin',NULL,'/system/role','127.0.0.1','内网IP',NULL,NULL,NULL,'{\"admin\":false,\"createBy\":\"admin\",\"deptCheckStrictly\":true,\"deptIds\":[],\"flag\":false,\"menuCheckStrictly\":true,\"menuIds\":[],\"params\":{},\"roleId\":102,\"roleKey\":\"conpany_common\",\"roleName\":\"公司内部人员_普通操作员\",\"roleSort\":0,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-21 15:14:24',0,72),(3,'角色管理',3,'com.ruoyi.web.controller.system.SysRoleController.remove()','DELETE',1,'admin',NULL,'/system/role/100','127.0.0.1','内网IP',NULL,NULL,NULL,'{}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-21 15:23:50',0,55),(4,'角色管理',1,'com.ruoyi.web.controller.system.SysRoleController.add()','POST',1,'admin',NULL,'/system/role','127.0.0.1','内网IP',NULL,NULL,NULL,'{\"admin\":false,\"createBy\":\"admin\",\"deptCheckStrictly\":true,\"deptIds\":[],\"flag\":false,\"menuCheckStrictly\":true,\"menuIds\":[],\"params\":{},\"roleId\":103,\"roleKey\":\"common_role_v1\",\"roleName\":\"普通角色_v1\",\"roleSort\":0,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-21 15:27:00',0,72),(5,'角色管理',1,'com.ruoyi.web.controller.system.SysRoleController.add()','POST',1,'admin',NULL,'/system/role','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"admin\":false,\"createBy\":\"admin\",\"deptCheckStrictly\":true,\"deptIds\":[],\"flag\":false,\"menuCheckStrictly\":true,\"menuIds\":[],\"params\":{},\"roleId\":104,\"roleKey\":\"common_v2\",\"roleName\":\"普通角色_v2\",\"roleSort\":0,\"status\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-21 15:31:22',0,71),(6,'角色管理',3,'com.ruoyi.web.controller.system.SysRoleController.remove()','DELETE',1,'admin',NULL,'/system/role/104','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-21 15:37:10',0,60),(7,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 19:17:00',0,22),(8,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:10:14',0,25),(9,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:10:27',0,1),(10,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:16:24',0,29),(11,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:16:26',0,1),(12,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:18:52',0,192),(13,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:18:55',0,1),(14,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:18:57',0,2),(15,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:26:17',0,23),(16,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 20:30:34',0,28),(17,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 21:11:30',0,23),(18,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 21:20:41',0,25),(19,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 21:22:51',0,31),(20,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 21:25:23',0,31),(21,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 21:27:42',0,26),(22,'HelloWorld测试',10,'com.ruoyi.platform.liveBroadcastApp.HelloV2.getCode()','GET',1,'获取用户信息异常.未知用户',NULL,'/hello/world','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"成功\",\"code\":200}',0,NULL,'2023-09-21 21:30:10',0,25),(23,'用户头像',2,'com.ruoyi.web.controller.system.SysProfileController.avatar()','POST',1,'admin',NULL,'/api/system/user/profile/avatar','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','','{\"msg\":\"操作成功\",\"imgUrl\":\"/profile/avatar/2023/09/22/blob_20230922094345A001.png\",\"code\":200}',0,NULL,'2023-09-22 09:43:45',0,100),(24,'用户头像',2,'com.ruoyi.web.controller.system.SysProfileController.avatar()','POST',1,'admin',NULL,'/api/system/user/profile/avatar','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','','{\"msg\":\"操作成功\",\"imgUrl\":\"/profile/avatar/2023/09/22/blob_20230922102625A001.png\",\"code\":200}',0,NULL,'2023-09-22 10:26:25',0,55),(25,'用户头像',2,'com.ruoyi.web.controller.system.SysProfileController.avatar()','POST',1,'admin',NULL,'/api/system/user/profile/avatar','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','','{\"msg\":\"操作成功\",\"imgUrl\":\"/profile/avatar/2023/09/22/blob_20230922114840A001.png\",\"code\":200}',0,NULL,'2023-09-22 11:48:40',0,51),(26,'代码生成',6,'com.ruoyi.generator.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/api/tool/gen/importTable','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"sys_option\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 13:49:43',0,69),(27,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/api/tool/gen','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"businessName\":\"sys_option\",\"className\":\"SysOption\",\"columns\":[{\"capJavaField\":\"Id\",\"columnComment\":\"主键\",\"columnId\":124,\"columnName\":\"id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":true,\"isIncrement\":\"1\",\"isInsert\":\"1\",\"isPk\":\"1\",\"javaField\":\"id\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":11,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"Title\",\"columnComment\":\"标题\",\"columnId\":125,\"columnName\":\"title\",\"columnType\":\"varchar(64)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"title\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":2,\"superColumn\":false,\"tableId\":11,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"DictKey\",\"columnComment\":\"键值对-键\",\"columnId\":126,\"columnName\":\"dict_key\",\"columnType\":\"varchar(256)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"dictKey\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":3,\"superColumn\":false,\"tableId\":11,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"DictValue\",\"columnComment\":\"键值对-值\",\"columnId\":127,\"columnName\":\"dict_value\",\"columnType\":\"text\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"textarea\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"dictValue\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"que','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 13:50:55',0,37),(28,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"sys_option\"}',NULL,0,NULL,'2023-09-22 13:51:06',0,34),(29,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/api/tool/gen','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"businessName\":\"sys_option\",\"className\":\"SysOption\",\"columns\":[{\"capJavaField\":\"Id\",\"columnComment\":\"主键\",\"columnId\":124,\"columnName\":\"id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":true,\"isIncrement\":\"1\",\"isInsert\":\"1\",\"isPk\":\"1\",\"javaField\":\"id\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":11,\"updateBy\":\"\",\"updateTime\":\"2023-09-22 13:50:54\",\"usableColumn\":false},{\"capJavaField\":\"Title\",\"columnComment\":\"标题\",\"columnId\":125,\"columnName\":\"title\",\"columnType\":\"varchar(64)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"title\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":2,\"superColumn\":false,\"tableId\":11,\"updateBy\":\"\",\"updateTime\":\"2023-09-22 13:50:54\",\"usableColumn\":false},{\"capJavaField\":\"DictKey\",\"columnComment\":\"键值对-键\",\"columnId\":126,\"columnName\":\"dict_key\",\"columnType\":\"varchar(256)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"dictKey\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":3,\"superColumn\":false,\"tableId\":11,\"updateBy\":\"\",\"updateTime\":\"2023-09-22 13:50:54\",\"usableColumn\":false},{\"capJavaField\":\"DictValue\",\"columnComment\":\"键值对-值\",\"columnId\":127,\"columnName\":\"dict_value\",\"columnType\":\"text\",\"createBy\":\"admin\",\"createTime\":\"2023-09-22 13:49:43\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"textarea\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"is','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 13:52:28',0,27),(30,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"sys_option\"}',NULL,0,NULL,'2023-09-22 13:52:30',0,30),(31,'菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.add()','POST',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"createBy\":\"admin\",\"icon\":\"code\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"平台管理\",\"menuType\":\"M\",\"orderNum\":1,\"params\":{},\"parentId\":0,\"path\":\"/platform\",\"status\":\"0\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 13:58:08',0,45),(32,'菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.add()','POST',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"component\":\"platform/sys_option/index\",\"createBy\":\"admin\",\"icon\":\"chart\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"系统码表\",\"menuType\":\"C\",\"orderNum\":1,\"params\":{},\"parentId\":2000,\"path\":\"sys_option\",\"perms\":\"sys_option\",\"status\":\"0\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 13:59:59',0,8),(33,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"sys_option\"}',NULL,0,NULL,'2023-09-22 14:14:46',0,172),(34,'系统-操作码',1,'com.ruoyi.platform.liveBroadcastApp.sys_option.controller.SysOptionController.add()','POST',1,'admin',NULL,'/api/sysOption/sys_option','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"createTime\":\"2023-09-22 14:20:54\",\"dictKey\":\"1\",\"dictValue\":\"1\",\"id\":1,\"params\":{},\"title\":\"1\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:20:54',0,48),(35,'系统-操作码',2,'com.ruoyi.platform.liveBroadcastApp.sys_option.controller.SysOptionController.edit()','PUT',1,'admin',NULL,'/api/sysOption/sys_option','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"createTime\":\"2023-09-22 14:20:54\",\"dictKey\":\"1\",\"dictValue\":\"2222\",\"id\":1,\"isDelete\":0,\"params\":{},\"title\":\"1\",\"updateTime\":\"2023-09-22 14:20:59\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:20:59',0,9),(36,'系统-操作码',2,'com.ruoyi.platform.liveBroadcastApp.sys_option.controller.SysOptionController.edit()','PUT',1,'admin',NULL,'/api/sysOption/sys_option','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"createTime\":\"2023-09-22 14:20:54\",\"dictKey\":\"1\",\"dictValue\":\"2222\",\"id\":1,\"isDelete\":1,\"params\":{},\"title\":\"1\",\"updateTime\":\"2023-09-22 14:21:01\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:21:01',0,13),(37,'系统-操作码',2,'com.ruoyi.platform.liveBroadcastApp.sys_option.controller.SysOptionController.edit()','PUT',1,'admin',NULL,'/api/sysOption/sys_option','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"createTime\":\"2023-09-22 14:20:54\",\"dictKey\":\"1\",\"dictValue\":\"2222\",\"id\":1,\"isDelete\":0,\"params\":{},\"title\":\"1\",\"updateTime\":\"2023-09-22 14:21:05\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:21:05',0,11),(38,'字典类型',9,'com.ruoyi.web.controller.system.SysDictTypeController.refreshCache()','DELETE',1,'admin',NULL,'/api/system/dict/type/refreshCache','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:31:42',0,31),(39,'系统-操作码',2,'com.ruoyi.platform.liveBroadcastApp.sys_option.controller.SysOptionController.edit()','PUT',1,'admin',NULL,'/api/sysOption/sys_option','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"createTime\":\"2023-09-22 14:20:54\",\"dictKey\":\"1\",\"dictValue\":\"2222\",\"id\":1,\"isDelete\":0,\"params\":{},\"title\":\"1\",\"updateTime\":\"2023-09-22 14:32:27\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:32:27',0,3),(40,'菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.edit()','PUT',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"createTime\":\"2023-09-22 13:58:08\",\"icon\":\"code\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2000,\"menuName\":\"平台管理\",\"menuType\":\"M\",\"orderNum\":1,\"params\":{},\"parentId\":0,\"path\":\"platform\",\"perms\":\"\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 14:50:46',0,41),(41,'角色管理',5,'com.ruoyi.web.controller.system.SysRoleController.export()','POST',1,'admin',NULL,'/api/system/role/export','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"pageSize\":\"10\",\"pageNum\":\"1\"}',NULL,0,NULL,'2023-09-22 14:54:28',0,692),(42,'导出系统-操作码列表',5,'com.ruoyi.platform.liveBroadcastApp.sys_option.controller.SysOptionController.export()','POST',1,'admin',NULL,'/api/sysOption/sys_option/export','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"pageSize\":\"10\",\"pageNum\":\"1\"}',NULL,0,NULL,'2023-09-22 14:54:51',0,36),(43,'菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.edit()','PUT',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"component\":\"monitor/job/index\",\"createTime\":\"2023-09-16 11:10:41\",\"icon\":\"job\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":110,\"menuName\":\"定时任务\",\"menuType\":\"C\",\"orderNum\":2,\"params\":{},\"parentId\":2,\"path\":\"job\",\"perms\":\"monitor:job:list\",\"query\":\"\",\"status\":\"1\",\"updateBy\":\"admin\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-22 15:10:03',0,38),(44,'用户头像',2,'com.ruoyi.web.controller.system.SysProfileController.avatar()','POST',1,'admin',NULL,'/api/system/user/profile/avatar','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','','{\"msg\":\"操作成功\",\"imgUrl\":\"/profile/avatar/2023/09/22/blob_20230922152116A001.png\",\"code\":200}',0,NULL,'2023-09-22 15:21:16',0,53),(45,'代码生成',6,'com.ruoyi.generator.controller.GenController.importTableSave()','POST',1,'admin',NULL,'/api/tool/gen/importTable','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log,llm_claude_key\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 09:40:39',0,151),(46,'代码生成',3,'com.ruoyi.generator.controller.GenController.remove()','DELETE',1,'admin',NULL,'/api/tool/gen/1,2,3,4,11','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 09:40:48',0,13),(47,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/api/tool/gen','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"businessName\":\"llm_chat_log\",\"className\":\"LlmChatLog\",\"columns\":[{\"capJavaField\":\"Id\",\"columnComment\":\"主键\",\"columnId\":131,\"columnName\":\"id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":true,\"isIncrement\":\"1\",\"isInsert\":\"1\",\"isPk\":\"1\",\"javaField\":\"id\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":12,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"User\",\"columnComment\":\"聊天用户\",\"columnId\":132,\"columnName\":\"user\",\"columnType\":\"varchar(32)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"user\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":2,\"superColumn\":false,\"tableId\":12,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"UserDeviceType\",\"columnComment\":\"操作类别（0其它 1后台用户 2手机端用户）\",\"columnId\":133,\"columnName\":\"user_device_type\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"select\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"userDeviceType\",\"javaType\":\"Long\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":3,\"superColumn\":false,\"tableId\":12,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"UserIp\",\"columnComment\":\"ip地址\",\"columnId\":134,\"columnName\":\"user_ip\",\"columnType\":\"varchar(128)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"userIp\",\"javaType\":\"String\",\"list\":true,\"','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 09:41:43',0,51),(48,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 09:41:47',0,196),(49,'菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.add()','POST',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"component\":\"platform/llm_chat_log/index\",\"createBy\":\"admin\",\"icon\":\"date-range\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"llm_chat_log\",\"menuType\":\"C\",\"orderNum\":2,\"params\":{},\"parentId\":2000,\"path\":\"llm_chat_log\",\"perms\":\"llm_chat_log\",\"status\":\"0\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 09:46:51',0,14),(50,'语言模型聊天记录',2,'com.ruoyi.platform.llm_chat_log.controller.LlmChatLogController.edit()','PUT',1,'admin',NULL,'/api/llm_chat_log/llm_chat_log','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"consumeTime\":\"19.03\",\"createTime\":\"2023-09-23 09:32:41\",\"currentRoleName\":\"主人\",\"history\":\"\",\"id\":1,\"isDelete\":0,\"llm\":\"ChatGLM2GPT\",\"params\":{},\"prompt\":\"我们如何在日常生活中减少用水？\",\"reqParams\":\"{\'prompt\': \'我们如何在日常生活中减少用水？\', \'current_role_name\': \'主人\', \'role_name\': \'猫娘\', \'llm\': \'ChatGLM2GPT\'}\",\"response\":\"猫娘:「我们可以尝试使用可重复使用的餐具和杯子来减少用水量。我们还可以在洗衣服时使用低泡洗涤剂，减少用水量。此外，我们还可以在洗澡时使用淋浴代替泡澡，减少用水量。」\",\"roleName\":\"猫娘\",\"updateTime\":\"2023-09-23 10:00:59\",\"user\":\"1\",\"userAddress\":\"中国,杭州\",\"userDeviceType\":0}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 10:00:59',0,51),(51,'语言模型聊天记录',2,'com.ruoyi.platform.llm_chat_log.controller.LlmChatLogController.edit()','PUT',1,'admin',NULL,'/api/llm_chat_log/llm_chat_log','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"consumeTime\":\"19.03\",\"createTime\":\"2023-09-23 09:32:41\",\"currentRoleName\":\"主人\",\"history\":\"\",\"id\":1,\"isDelete\":0,\"llm\":\"ChatGLM2GPT\",\"params\":{},\"prompt\":\"我们如何在日常生活中减少用水？\",\"reqParams\":\"{\'prompt\': \'我们如何在日常生活中减少用水？\', \'current_role_name\': \'主人\', \'role_name\': \'猫娘\', \'llm\': \'ChatGLM2GPT\'}\",\"response\":\"猫娘:「我们可以尝试使用可重复使用的餐具和杯子来减少用水量。我们还可以在洗衣服时使用低泡洗涤剂，减少用水量。此外，我们还可以在洗澡时使用淋浴代替泡澡，减少用水量。」\",\"roleName\":\"猫娘\",\"updateTime\":\"2023-09-23 10:01:10\",\"user\":\"1\",\"userAddress\":\"中国,杭州\",\"userBrowser\":\"Chrom11\",\"userDeviceType\":0,\"userSystem\":\"windows10\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 10:01:10',0,10),(52,'菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.edit()','PUT',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"component\":\"platform/llm_chat_log/index\",\"createTime\":\"2023-09-23 09:46:51\",\"icon\":\"date-range\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuId\":2002,\"menuName\":\"聊天记录\",\"menuType\":\"C\",\"orderNum\":2,\"params\":{},\"parentId\":2000,\"path\":\"llm_chat_log\",\"perms\":\"llm_chat_log\",\"status\":\"0\",\"updateBy\":\"admin\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 10:04:02',0,17),(53,'代码生成',2,'com.ruoyi.generator.controller.GenController.editSave()','PUT',1,'admin',NULL,'/api/tool/gen','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"businessName\":\"llm_claude_key\",\"className\":\"LlmClaudeKey\",\"columns\":[{\"capJavaField\":\"Id\",\"columnComment\":\"主键\",\"columnId\":150,\"columnName\":\"id\",\"columnType\":\"int\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":false,\"htmlType\":\"input\",\"increment\":true,\"insert\":true,\"isIncrement\":\"1\",\"isInsert\":\"1\",\"isPk\":\"1\",\"javaField\":\"id\",\"javaType\":\"Long\",\"list\":false,\"params\":{},\"pk\":true,\"query\":false,\"queryType\":\"EQ\",\"required\":false,\"sort\":1,\"superColumn\":false,\"tableId\":13,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"ApiType\",\"columnComment\":\"类别名称\",\"columnId\":151,\"columnName\":\"api_type\",\"columnType\":\"varchar(32)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"select\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"apiType\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":2,\"superColumn\":false,\"tableId\":13,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"Info\",\"columnComment\":\"备注信息\",\"columnId\":152,\"columnName\":\"info\",\"columnType\":\"varchar(32)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"info\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":false,\"query\":true,\"queryType\":\"EQ\",\"required\":false,\"sort\":3,\"superColumn\":false,\"tableId\":13,\"updateBy\":\"\",\"usableColumn\":false},{\"capJavaField\":\"OrgUuid\",\"columnComment\":\"org_uuid\",\"columnId\":153,\"columnName\":\"org_uuid\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"createTime\":\"2023-09-23 09:40:39\",\"dictType\":\"\",\"edit\":true,\"htmlType\":\"input\",\"increment\":false,\"insert\":true,\"isEdit\":\"1\",\"isIncrement\":\"0\",\"isInsert\":\"1\",\"isList\":\"1\",\"isPk\":\"0\",\"isQuery\":\"1\",\"javaField\":\"orgUuid\",\"javaType\":\"String\",\"list\":true,\"params\":{},\"pk\":fal','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 10:09:34',0,50),(54,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_claude_key\"}',NULL,0,NULL,'2023-09-23 10:09:49',0,153),(55,'菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.add()','POST',1,'admin',NULL,'/api/system/menu','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"children\":[],\"component\":\"platform/llm_claude_key/index\",\"createBy\":\"admin\",\"icon\":\"code\",\"isCache\":\"0\",\"isFrame\":\"1\",\"menuName\":\"claude账号池\",\"menuType\":\"C\",\"orderNum\":3,\"params\":{},\"parentId\":2000,\"path\":\"llm_claude_key\",\"perms\":\"llm_claude_key\",\"status\":\"0\",\"visible\":\"0\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 10:13:39',0,45),(56,'语言模型,api,claude连接池',2,'com.ruoyi.platform.llm_claude_key.controller.LlmClaudeKeyController.edit()','PUT',1,'admin',NULL,'/api/llm_claude_key/llm_claude_key','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"apiType\":\"claude_api111\",\"conversationUuid\":\"删除标记控制内容\",\"createTime\":\"2023-09-23 09:31:38\",\"createUser\":\"删除标记控制内容\",\"id\":2,\"info\":\"测试内容\",\"isDelete\":1,\"orgUuid\":\"删除标记控制内容\",\"params\":{},\"sessionKey\":\"删除标记控制内容\",\"updateTime\":\"2023-09-23 10:18:22\"}','{\"msg\":\"操作成功\",\"code\":200}',0,NULL,'2023-09-23 10:18:22',0,20),(57,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 10:48:27',0,223),(58,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 10:52:42',0,194),(59,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 10:55:49',0,227),(60,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 10:59:18',0,206),(61,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:01:41',0,211),(62,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:07:46',0,192),(63,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:11:17',0,216),(64,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:17:28',0,194),(65,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:21:03',0,246),(66,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:22:30',0,272),(67,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:23:29',0,207),(68,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:24:48',0,248),(69,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:26:44',0,264),(70,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:29:59',0,208),(71,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:34:29',0,210),(72,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:44:36',0,293),(73,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:46:13',0,290),(74,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:49:52',0,214),(75,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:50:54',0,214),(76,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:51:27',0,45),(77,'代码生成',8,'com.ruoyi.generator.controller.GenController.batchGenCode()','GET',1,'admin',NULL,'/api/tool/gen/batchGenCode','127.0.0.1','内网IP','WINDOWS_10-CHROME11','Chrome 11','Windows 10','{\"tables\":\"llm_chat_log\"}',NULL,0,NULL,'2023-09-23 11:57:02',0,242);
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_option`
--

DROP TABLE IF EXISTS `sys_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_option` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `dict_key` varchar(256) DEFAULT NULL COMMENT '键值对-键',
  `dict_value` text,
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统-操作码表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_option`
--

LOCK TABLES `sys_option` WRITE;
/*!40000 ALTER TABLE `sys_option` DISABLE KEYS */;
INSERT INTO `sys_option` VALUES (1,'1','1','2222',0,'2023-09-22 06:20:54','2023-09-22 06:32:27');
/*!40000 ALTER TABLE `sys_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (1,'ceo','董事长',1,'0','admin','2023-09-16 11:10:41','',NULL,''),(2,'se','项目经理',2,'0','admin','2023-09-16 11:10:41','',NULL,''),(3,'hr','人力资源',3,'0','admin','2023-09-16 11:10:41','',NULL,''),(4,'user','普通员工',4,'0','admin','2023-09-16 11:10:41','',NULL,'');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'超级管理员','admin',1,'1',1,1,'0','0','admin','2023-09-16 11:10:41','',NULL,'超级管理员'),(2,'普通角色','common',2,'2',1,1,'0','0','admin','2023-09-16 11:10:41','admin','2023-09-18 16:49:27','普通角色'),(100,'未注册用户_猫娘','no_register_user',0,'1',1,1,'0','2','admin','2023-09-21 14:34:33','',NULL,NULL),(101,'vip客户','vip_custom',0,'1',1,1,'0','0','admin','2023-09-21 14:57:50','',NULL,NULL),(102,'公司内部人员_普通操作员','conpany_common',0,'1',1,1,'0','0','admin','2023-09-21 15:14:24','',NULL,NULL),(103,'普通角色_v1','common_role_v1',0,'1',1,1,'0','0','admin','2023-09-21 15:27:00','',NULL,NULL),(104,'普通角色_v2','common_v2',0,'1',1,1,'0','2','admin','2023-09-21 15:31:22','',NULL,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
INSERT INTO `sys_role_dept` VALUES (2,100),(2,101),(2,105);
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (2,1),(2,2),(2,3),(2,100),(2,101),(2,102),(2,103),(2,104),(2,105),(2,106),(2,107),(2,108),(2,109),(2,110),(2,111),(2,112),(2,113),(2,114),(2,115),(2,116),(2,117),(2,500),(2,501),(2,1000),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1008),(2,1009),(2,1010),(2,1011),(2,1012),(2,1013),(2,1014),(2,1015),(2,1016),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1031),(2,1032),(2,1033),(2,1034),(2,1035),(2,1036),(2,1037),(2,1038),(2,1039),(2,1040),(2,1041),(2,1042),(2,1043),(2,1044),(2,1045),(2,1046),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,1057),(2,1058),(2,1059),(2,1060);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,103,'admin','魔法师狄奥伦娜','00','ry@163.com','15888888888','1','/profile/avatar/2023/09/22/blob_20230922152116A001.png','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2023-09-23 09:40:05','admin','2023-09-16 11:10:41','','2023-09-23 09:40:05','管理员'),(2,105,'ry','太乙上仙','00','ry@qq.com','15666666666','1','','$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2','0','0','127.0.0.1','2023-09-18 16:34:17','admin','2023-09-16 11:10:41','','2023-09-18 16:34:17','测试员');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_post` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-25  9:08:46
