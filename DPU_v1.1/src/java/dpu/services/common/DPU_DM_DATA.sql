drop database if exists dpu6m;
create database if not exists dpu6m;
use dpu6m;

-- MySQL dump 10.13  Distrib 5.5.34, for Linux (i686)
--
-- Host: localhost    Database: dpu
-- ------------------------------------------------------
-- Server version	5.5.34

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `fk_city_1_idx` (`state_id`),
  CONSTRAINT `fk_city_1` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,NULL,1,1),(2,NULL,1,2),(3,'nskc',1,3),(4,'bhadbsc',1,4),(5,'nc',0,5),(6,'skjbsdv',0,6),(7,'jsxnjc',1,7),(8,'mnscb ',0,8),(9,'snb',1,9),(10,'ndsv',0,10),(11,NULL,0,NULL),(12,'name',1,NULL),(13,'ludhiana',0,NULL),(14,'goa',1,1),(15,NULL,0,1),(16,'chandigarh-the city beautiful',0,1),(17,NULL,1,2),(18,NULL,1,2),(19,'jhsagfjsa',1,2),(20,'sfsdfasdad',0,1),(21,'UNA',1,19),(22,'Dharamshala',0,19);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'India Is Great',1),(2,'USA',1),(3,'Canada',3),(4,'Japan',4),(5,'korea',7),(6,'Iraq(ISIS)',0),(7,'Taliban',1),(8,NULL,NULL),(9,NULL,NULL),(10,NULL,NULL),(11,'he',0),(12,'h',NULL),(13,'asasdasd',1),(14,'adsd',0),(15,'asdasdasd',1),(16,'adadsasdasd',1);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `faqmaster`
--

DROP TABLE IF EXISTS `faqmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faqmaster` (
  `faq_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(45) DEFAULT NULL,
  `answer` text,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`faq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faqmaster`
--

LOCK TABLES `faqmaster` WRITE;
/*!40000 ALTER TABLE `faqmaster` DISABLE KEYS */;
INSERT INTO `faqmaster` VALUES (1,'how to register?','Go to the main menu, and fill in the sign up form.',1),(2,'what is this site about?','its about processing customer orders.',0),(3,'asdas','asdas',1),(4,'which page is this?','Manage FAQ',1),(5,'Which Ide should be used?','Netbeans',1),(6,'how to do','asdasd',1),(7,'dfgdfg','dfgdfg',1);
/*!40000 ALTER TABLE `faqmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbackmaster`
--

DROP TABLE IF EXISTS `feedbackmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedbackmaster` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback` varchar(45) DEFAULT NULL,
  `feedback_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `fk_feedbackmaster_1_idx` (`user_id`),
  CONSTRAINT `fk_feedbackmaster_1` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `orderitemmaster`
--

DROP TABLE IF EXISTS `orderitemmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitemmaster` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `fk_orderitemmaster_1_idx` (`order_id`),
  KEY `fk_orderitemmaster_2_idx` (`product_id`),
  CONSTRAINT `fk_orderitemmaster_1` FOREIGN KEY (`order_id`) REFERENCES `ordermaster` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderitemmaster_2` FOREIGN KEY (`product_id`) REFERENCES `productmaster` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `ordermaster`
--

DROP TABLE IF EXISTS `ordermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordermaster` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_title` varchar(45) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `dealer_id` int(11) DEFAULT NULL,
  `order_status` varchar(15) DEFAULT NULL,
  `is_cancelled` tinyint(4) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `is_payment_done` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_ordermaster_2_idx` (`dealer_id`),
  CONSTRAINT `fk_ordermaster_2` FOREIGN KEY (`dealer_id`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `productcategorymaster`
--

DROP TABLE IF EXISTS `productcategorymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcategorymaster` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` text,
  `status` tinyint(4) DEFAULT NULL,
  `vat_per_cent` decimal(10,2) DEFAULT NULL,
  `shipping_charges_per_kg` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `productmaster`
--

DROP TABLE IF EXISTS `productmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productmaster` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `product_code` varchar(45) DEFAULT NULL,
  `model_no` varchar(45) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `description` text,
  `price` decimal(10,2) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `weight` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_productmaster_1_idx` (`category_id`),
  CONSTRAINT `fk_productmaster_1` FOREIGN KEY (`category_id`) REFERENCES `productcategorymaster` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmaster`
--

LOCK TABLES `productmaster` WRITE;
/*!40000 ALTER TABLE `productmaster` DISABLE KEYS */;
INSERT INTO `productmaster` VALUES (1,'headphones','c500e','9779127269',4,'beats by Dr.Dre','Good Quality HeadPhones\r\n                                                ',12000.00,1,NULL),(2,'hjsdbv',NULL,'4376',2,NULL,NULL,200.00,1,NULL),(3,'wejhfb',NULL,'467',3,NULL,NULL,500.00,1,NULL),(4,'gft',NULL,'76756',4,NULL,NULL,100.00,0,NULL),(5,'cdh',NULL,'5355',5,NULL,NULL,998.00,0,NULL),(6,'NEXUS 5','#NXS5','63526',1,'LG','     asjbbchjasb                                           ',30000.00,1,NULL),(8,'jjjsd','mnzznx','n 743',14,'jdsjjb','                                                ',23676.00,1,NULL),(9,'jjjsd','mnzznx','n 743',14,'jdsjjb','                                                ',23676.00,1,NULL),(10,'jjdjn','74237','2382',14,'ajsdk','                                                ',324.00,1,NULL);
/*!40000 ALTER TABLE `productmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestmaster`
--

DROP TABLE IF EXISTS `requestmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestmaster` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `request_title` varchar(45) DEFAULT NULL,
  `description` text,
  `request_date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`request_id`),
  KEY `fk_requestmaster_1_idx` (`user_id`),
  CONSTRAINT `fk_requestmaster_1` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestmaster`
--

LOCK TABLES `requestmaster` WRITE;
/*!40000 ALTER TABLE `requestmaster` DISABLE KEYS */;
INSERT INTO `requestmaster` VALUES (1,'Login prob','Prob','2015-02-24 10:12:46',1,'completed'),(2,'Ziag','desc','2015-02-24 10:26:36',1,'completed'),(3,'jhjbhjh','hgghhvjghjgc','2015-03-03 08:53:02',1,'completed'),(4,'ddbnmdmn','ansc namcasnbcnsmbncbhahbsmncnbxzm','2015-03-11 11:41:08',2,'completed'),(5,'iuwhshjh','wqkhkdwekjfwkjefjk','2015-03-11 11:49:15',2,'completed'),(6,'fhdbj','hj','2015-03-11 12:00:56',2,'completed'),(7,'fhdbj','hj','2015-03-11 12:00:56',2,'completed'),(8,'Loginva Problem','fdjdf','2015-03-11 12:20:59',2,'completed'),(9,'request','Request Here kjasbjabns ','2015-04-14 10:12:09',2,'completed'),(10,'jhsj','Request Here sakjjk ','2015-04-14 10:26:35',2,'Pending'),(11,'sakjdjj','Request Here jkaskjd ','2015-04-14 10:31:25',2,'Pending'),(12,'jkdkjmm','Request Here','2015-04-14 10:35:34',2,'Pending'),(13,'any','Random','2015-04-25 12:24:35',2,'completed'),(14,'askhdasd','jkhkj','2015-05-11 12:40:07',2,'Pending');
/*!40000 ALTER TABLE `requestmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsemaster`
--

DROP TABLE IF EXISTS `responsemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsemaster` (
  `response_id` int(11) NOT NULL AUTO_INCREMENT,
  `request_id` int(11) DEFAULT NULL,
  `response` text,
  `response_date` datetime DEFAULT NULL,
  `response_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`response_id`),
  KEY `fk_responsemaster_1_idx` (`request_id`),
  KEY `fk_responsemaster_2_idx` (`response_user_id`),
  CONSTRAINT `fk_responsemaster_1` FOREIGN KEY (`request_id`) REFERENCES `requestmaster` (`request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_responsemaster_2` FOREIGN KEY (`response_user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsemaster`
--

LOCK TABLES `responsemaster` WRITE;
/*!40000 ALTER TABLE `responsemaster` DISABLE KEYS */;
INSERT INTO `responsemaster` VALUES (1,1,'Nohting seroious','2015-02-24 10:14:22',2),(8,2,'sdmvmdvbmnmv','2015-02-24 12:01:26',1),(9,3,'svnsdbvmv','2015-03-04 23:44:57',1),(10,5,'sdvjsbvhjvvevj ','2015-03-11 12:13:59',1),(11,8,'Ok ','2015-03-11 12:21:36',1),(12,9,'asasd','2015-05-11 12:18:55',1),(13,13,'asdasd','2015-05-11 12:19:01',1);
/*!40000 ALTER TABLE `responsemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `securitymaster`
--

DROP TABLE IF EXISTS `securitymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `securitymaster` (
  `security_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` text,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`security_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `securitymaster`
--

LOCK TABLES `securitymaster` WRITE;
/*!40000 ALTER TABLE `securitymaster` DISABLE KEYS */;
INSERT INTO `securitymaster` VALUES (1,'sfsertfesgsdg',1),(2,'sfsertfesgsdg',1),(3,'sfsertfesgsdg',0),(4,'sfsertfesgsdg',0),(5,'sfsertfesgsdg',0),(6,'sfsertfesgsdg',0),(7,'sfsertfesgsdg',1),(8,'sfsertfesgsdg',1),(9,'sfsertfesgsdg',1),(10,'sfsertfesgsdg',1),(11,'sfsertfesgsdg',0),(12,'sfsertfesgsdg',1),(13,'sfsertfesgsdg',0);
/*!40000 ALTER TABLE `securitymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`state_id`),
  KEY `fk_state_1_idx` (`country_id`),
  CONSTRAINT `fk_state_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Punjab',0,1),(2,'HP',0,1),(3,'Haryana',1,1),(4,'California',1,2),(5,'wehgfewj',0,2),(6,'nshvh',1,3),(7,'wejbfw',0,3),(8,'whsfdgwev',1,4),(9,'jjhghhj',0,4),(10,'yytryd',1,5),(11,'jhefghwv',1,5),(12,'UP',0,1),(13,'g',0,1),(14,'th',0,1),(15,'ty',1,1),(16,'asdasd',1,1),(17,'xcvxcvxc',0,1),(18,'asdad',0,1),(19,'Himachal',0,1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionmaster`
--

DROP TABLE IF EXISTS `transactionmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionmaster` (
  `order_id` int(11) NOT NULL,
  `processed_date` date DEFAULT NULL,
  `total_charges` decimal(10,2) DEFAULT NULL,
  `shipping_charges` decimal(10,2) DEFAULT NULL,
  `payment_via` varchar(25) DEFAULT NULL,
  `dispatch_date` date DEFAULT NULL,
  `order_processed_by` int(11) DEFAULT NULL,
  `order_dispatched_by` int(11) DEFAULT NULL,
  `bill_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_transactionmaster_1_idx` (`order_processed_by`),
  KEY `fk_transactionmaster_2_idx` (`order_dispatched_by`),
  CONSTRAINT `fk_transactionmaster_1` FOREIGN KEY (`order_processed_by`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transactionmaster_2` FOREIGN KEY (`order_dispatched_by`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transactionmaster_3` FOREIGN KEY (`order_id`) REFERENCES `ordermaster` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionmaster`
--

LOCK TABLES `transactionmaster` WRITE;
/*!40000 ALTER TABLE `transactionmaster` DISABLE KEYS */;
INSERT INTO `transactionmaster` VALUES (1,'2015-02-16',2000.00,NULL,NULL,'2015-05-11',NULL,1,'1'),(2,'2015-02-16',4000.00,NULL,NULL,'2015-02-16',NULL,NULL,NULL),(3,'2015-02-16',8000.00,NULL,NULL,'2015-05-11',NULL,1,'3');
/*!40000 ALTER TABLE `transactionmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccountsecurity`
--

DROP TABLE IF EXISTS `useraccountsecurity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccountsecurity` (
  `user_id` int(11) NOT NULL,
  `security_question_id` int(11) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_useraccountsecurity_1_idx` (`security_question_id`),
  CONSTRAINT `fk_useraccountsecurity_1` FOREIGN KEY (`security_question_id`) REFERENCES `securitymaster` (`security_question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_useraccountsecurity_2` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccountsecurity`
--

LOCK TABLES `useraccountsecurity` WRITE;
/*!40000 ALTER TABLE `useraccountsecurity` DISABLE KEYS */;
/*!40000 ALTER TABLE `useraccountsecurity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetail` (
  `user_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phone` varchar(45) DEFAULT '',
  `mobile` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `profile_pic_path` varchar(500) DEFAULT NULL,
  `pin_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_userdetail_2_idx` (`country_id`),
  KEY `fk_userdetail_3_idx` (`state_id`),
  KEY `fk_userdetail_4_idx` (`city_id`),
  CONSTRAINT `fk_userdetail_1` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userdetail_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userdetail_3` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userdetail_4` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetail`
--

LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` VALUES (1,'hitesh','M','2015-03-04','627541','9041057616','hitesh.dangerman@gmail.com','#3312',1,1,14,'1.jpg','123456'),(2,'def','M','2015-02-16','5453453','9876765656','def@it.com','gfdfgfdrdgfd',1,2,2,NULL,'432323'),(3,'GHI','M','2015-02-16','5534354','678','ghi@it.com','gcgfddvxsesgv',3,7,7,NULL,'123'),(5,'a','M','1990-01-16','3265326','3267632','a@abd.com','63 ATLANTIC ROAD',2,4,4,NULL,'124526'),(8,'sakdk','M','1990-01-16','32894','2354632764','jjhaskd','askldmklsakmfkkfnsamdklmaklcmcaklm',2,4,4,NULL,'432323'),(9,'abhay','M','2012-11-11','2734824','1212378690','ajsdk@dashgd.com','Houae number344 ',1,1,14,NULL,'123123');
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  `user_status` varchar(10) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `last_login_ip_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'admin','admin','Admin','Active','2015-02-12 11:21:13',NULL),(2,'dealer','dealer','dealer','Active','2015-02-16 09:38:53',NULL),(3,'employee','employee','employee','Active','2015-02-16 09:39:43',NULL),(4,'a','a','employee','Active',NULL,NULL),(5,'abc','abc','admin','Inactive',NULL,NULL),(6,NULL,NULL,'employee','InActive',NULL,NULL),(7,'jj','Being@1','employee','InActive',NULL,NULL),(8,'a','Being@1','employee','Inactive',NULL,NULL),(9,'abhay','1231','employee','Active',NULL,NULL);
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-15  8:43:51
