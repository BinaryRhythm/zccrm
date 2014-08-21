-- MySQL dump 10.13  Distrib 5.6.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ccit
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'东北',0),(3,'华北',0),(4,'东南',0);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) DEFAULT NULL,
  `areaID` int(11) DEFAULT NULL,
  `customerno` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `legal` varchar(25) DEFAULT NULL,
  `service` text COMMENT '经营范围',
  `dimension` varchar(45) DEFAULT NULL,
  `website` varchar(55) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `comment` text,
  `createdate` datetime DEFAULT NULL,
  `createtype` int(1) DEFAULT NULL,
  `birth` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,3,3,'0001','何勇','刘平','五金电器','1000人','http://www.sina.com.cn','silentbinary@gmail.com','18867354451','浏阳柏加','多人合资，股份制有限公司','2014-08-21 15:55:01',0,'19880513'),(3,3,3,'0003','李大姐','刘平','木瓜','50人','http://www.ifeng.com.cn','vicecode@gmail.com','13867354451','湖南浏阳','股份制有限公司',NULL,1,'19790623'),(4,3,3,'0003','徐科长','刘平','木瓜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南浏阳','多人合资，股份制有限公司','2014-08-21 17:29:03',0,'19790623'),(5,3,3,'0003','徐科长','刘平','木瓜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南浏阳','多人合资，股份制有限公司','2014-08-21 17:50:18',0,'19790623'),(6,3,3,'0003','徐科长','刘平','木瓜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南浏阳','多人合资，股份制有限公司','2014-08-21 17:50:49',0,'19790623'),(7,5,3,'0007','李科长','刘平','西瓜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南浏阳','多人合资，股份制有限公司','2014-08-21 17:51:54',0,'19790623'),(8,7,1,'0008','李科长','刘平','西瓜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南浏阳','多人合资，股份制有限公司','2014-08-21 17:52:28',0,'19790623'),(9,7,1,'0009','刘晓天','刘平','紫菜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南浏阳','多人合资，股份制有限公司','2014-08-21 17:57:36',0,'19790623'),(10,4,3,'0010','王丹','刘平','紫菜','5000人','http://www.ifeng.com.cn','vicecode@gmail.com','18867354451','湖南长沙','多人合资，股份制有限公司','2014-08-21 19:15:39',0,'19790623');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `days`
--

DROP TABLE IF EXISTS `days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `StaffID` int(11) NOT NULL,
  `days1` int(11) NOT NULL,
  `days2` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `days`
--

LOCK TABLES `days` WRITE;
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
/*!40000 ALTER TABLE `days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyperson`
--

DROP TABLE IF EXISTS `keyperson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyperson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `sex` enum('男','女') NOT NULL DEFAULT '男',
  `age` int(3) DEFAULT NULL,
  `cardid` varchar(25) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `job` varchar(25) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  `impression` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyperson`
--

LOCK TABLES `keyperson` WRITE;
/*!40000 ALTER TABLE `keyperson` DISABLE KEYS */;
/*!40000 ALTER TABLE `keyperson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `train_id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `comment` text,
  `dates` date DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leaderID` int(11) DEFAULT NULL,
  `areaID` int(11) DEFAULT NULL,
  `email` varchar(25) NOT NULL,
  `pwd` varchar(64) NOT NULL,
  `name` varchar(25) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `addr` varchar(45) DEFAULT NULL,
  `comments` text,
  `limits` text COMMENT '权限',
  `LoginTime` int(11) DEFAULT NULL COMMENT '密码错误次数',
  `LoginDate` date DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '注释',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,NULL,3,'silentbinary@gmail.com','123456','刘平','18773165213','湖南长沙开福区',NULL,'研发',NULL,NULL,0),(3,NULL,4,'silentbinary@gmail.com','123456','william','18773165213','湖南长沙开福区',NULL,'管理员',NULL,NULL,1),(4,1,4,'1504537@qq.com','123446','林涵','13865808808','山东烟台',NULL,'测试人员1',NULL,NULL,0),(5,NULL,1,'skyloon@qq.com','123446','李长坤','13685808808','湖南长沙',NULL,NULL,NULL,NULL,0),(6,NULL,1,'skyoon@qq.com','123446','李腾','13605808808','湖南长沙',NULL,NULL,NULL,NULL,0),(7,NULL,1,'syoon@qq.com','123446','蓝力','13865808808','广西湛江',NULL,'测试人员',NULL,NULL,0);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traininfo`
--

DROP TABLE IF EXISTS `traininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traininfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `project` varchar(25) NOT NULL,
  `begin` datetime NOT NULL,
  `end` datetime NOT NULL,
  `place` varchar(25) DEFAULT NULL,
  `course` varchar(25) DEFAULT NULL,
  `teacher` varchar(25) DEFAULT NULL,
  `teachertel` varchar(25) DEFAULT NULL,
  `trainer` varchar(25) DEFAULT NULL,
  `trainertel` varchar(25) DEFAULT NULL,
  `logistics` varchar(25) DEFAULT NULL,
  `logisticstel` varchar(25) DEFAULT NULL,
  `car` varchar(25) DEFAULT NULL,
  `cartype` varchar(25) DEFAULT NULL,
  `driver` varchar(25) DEFAULT NULL,
  `drivertel` varchar(25) DEFAULT NULL,
  `trainleader` varchar(25) DEFAULT NULL,
  `trainleadertel` varchar(25) DEFAULT NULL,
  `trainleaderbirth` varchar(25) DEFAULT NULL,
  `trainercount` int(11) DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traininfo`
--

LOCK TABLES `traininfo` WRITE;
/*!40000 ALTER TABLE `traininfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `traininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainuser`
--

DROP TABLE IF EXISTS `trainuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coustomerID` int(11) NOT NULL,
  `train_id` int(11) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `job` varchar(25) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `cardid` varchar(25) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `comment` varchar(40) DEFAULT NULL,
  `isleader` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainuser`
--

LOCK TABLES `trainuser` WRITE;
/*!40000 ALTER TABLE `trainuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `jdr` varchar(25) DEFAULT NULL,
  `jqr` varchar(25) DEFAULT NULL,
  `record` varchar(25) DEFAULT NULL,
  `comment` text,
  `dates` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-21 19:59:37
