-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: dpu
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `acipassengermaster`
--

DROP TABLE IF EXISTS `acipassengermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acipassengermaster` (
  `passenger_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `present_state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `cell_no` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acipassengermaster`
--

LOCK TABLES `acipassengermaster` WRITE;
/*!40000 ALTER TABLE `acipassengermaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `acipassengermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorymaster`
--

DROP TABLE IF EXISTS `categorymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorymaster` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorymaster`
--

LOCK TABLES `categorymaster` WRITE;
/*!40000 ALTER TABLE `categorymaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classmaster`
--

DROP TABLE IF EXISTS `classmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classmaster` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `class_id_UNIQUE` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classmaster`
--

LOCK TABLES `classmaster` WRITE;
/*!40000 ALTER TABLE `classmaster` DISABLE KEYS */;
INSERT INTO `classmaster` VALUES (1,'CLASSa'),(2,'BB'),(3,'CCC'),(4,'DDDD');
/*!40000 ALTER TABLE `classmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companymaster`
--

DROP TABLE IF EXISTS `companymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companymaster` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(155) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companymaster`
--

LOCK TABLES `companymaster` WRITE;
/*!40000 ALTER TABLE `companymaster` DISABLE KEYS */;
INSERT INTO `companymaster` VALUES (1,'HH'),(2,'ABCC');
/*!40000 ALTER TABLE `companymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `containermaster`
--

DROP TABLE IF EXISTS `containermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `containermaster` (
  `container_id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  `terminal_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`container_id`),
  KEY `owner_id_idx` (`owner_id`),
  KEY `equipment_id_idx` (`equipment_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  CONSTRAINT `equipment_id_containermaster` FOREIGN KEY (`equipment_id`) REFERENCES `equipmentmaster` (`equipment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `owner_id_containermaster` FOREIGN KEY (`owner_id`) REFERENCES `companymaster` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id_containermaster` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `containermaster`
--

LOCK TABLES `containermaster` WRITE;
/*!40000 ALTER TABLE `containermaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `containermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `divisionmaster`
--

DROP TABLE IF EXISTS `divisionmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `divisionmaster` (
  `division_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divisionmaster`
--

LOCK TABLES `divisionmaster` WRITE;
/*!40000 ALTER TABLE `divisionmaster` DISABLE KEYS */;
INSERT INTO `divisionmaster` VALUES (1,'Toronto'),(2,'Calgary111'),(3,'Alberta'),(4,'Missisauga'),(5,'Ontario'),(6,'Ottawa'),(7,'Regina'),(8,'London'),(9,'Niagara');
/*!40000 ALTER TABLE `divisionmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivermaster`
--

DROP TABLE IF EXISTS `drivermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drivermaster` (
  `driver_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `def_truck` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `home_phone` varchar(45) DEFAULT NULL,
  `cellular` varchar(45) DEFAULT NULL,
  `pager` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `last_trip` varchar(45) DEFAULT NULL,
  `last_ETA` date DEFAULT NULL,
  `last_event` varchar(45) DEFAULT NULL,
  `last_location` varchar(45) DEFAULT NULL,
  `last_city` varchar(45) DEFAULT NULL,
  `L/S` varchar(45) DEFAULT NULL,
  `fax_no` varchar(45) DEFAULT NULL,
  `division_id` int(11) DEFAULT NULL,
  `terminal_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`driver_id`),
  KEY `division_id_idx` (`division_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  KEY `category_id_idx` (`category_id`),
  KEY `class_id_idx` (`class_id`),
  CONSTRAINT `category_id_drivermaster` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `class_id_drivermaster` FOREIGN KEY (`class_id`) REFERENCES `classmaster` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `division_id_drivermaster` FOREIGN KEY (`division_id`) REFERENCES `divisionmaster` (`division_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id_drivermaster` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivermaster`
--

LOCK TABLES `drivermaster` WRITE;
/*!40000 ALTER TABLE `drivermaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `drivermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipmaster`
--

DROP TABLE IF EXISTS `equipmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipmaster` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`equipment_id`),
  UNIQUE KEY `container_id_UNIQUE` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipmaster`
--

LOCK TABLES `equipmaster` WRITE;
/*!40000 ALTER TABLE `equipmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipmentmaster`
--

DROP TABLE IF EXISTS `equipmentmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipmentmaster` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`equipment_id`),
  UNIQUE KEY `container_id_UNIQUE` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipmentmaster`
--

LOCK TABLES `equipmentmaster` WRITE;
/*!40000 ALTER TABLE `equipmentmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipmentmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `powerunitmaster`
--

DROP TABLE IF EXISTS `powerunitmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `powerunitmaster` (
  `unit_no` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  `truck_class` varchar(45) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `VIN` varchar(45) DEFAULT NULL,
  `make` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `truck_year` int(11) DEFAULT NULL,
  `plate_no` varchar(45) DEFAULT NULL,
  `jurisdiction` varchar(10) DEFAULT NULL,
  `tare_weight` int(11) DEFAULT NULL,
  `rgw` varchar(155) DEFAULT NULL,
  `tracking_id` int(11) DEFAULT NULL,
  `current_odometer` varchar(45) DEFAULT NULL,
  `equipment_type` varchar(45) DEFAULT NULL,
  `terminal_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`unit_no`),
  KEY `owner_id_idx` (`owner_id`),
  KEY `tracking_id_idx` (`tracking_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  CONSTRAINT `owner_id` FOREIGN KEY (`owner_id`) REFERENCES `companymaster` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tracking_id` FOREIGN KEY (`tracking_id`) REFERENCES `trackingmaster` (`tracking_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `powerunitmaster`
--

LOCK TABLES `powerunitmaster` WRITE;
/*!40000 ALTER TABLE `powerunitmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `powerunitmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolemaster`
--

DROP TABLE IF EXISTS `rolemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolemaster` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolemaster`
--

LOCK TABLES `rolemaster` WRITE;
/*!40000 ALTER TABLE `rolemaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salespersonmaster`
--

DROP TABLE IF EXISTS `salespersonmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salespersonmaster` (
  `person_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `present_state` varchar(45) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `phone_no` varchar(45) DEFAULT NULL,
  `fax_no` varchar(45) DEFAULT NULL,
  `cellular_no` varchar(45) DEFAULT NULL,
  `pager_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salespersonmaster`
--

LOCK TABLES `salespersonmaster` WRITE;
/*!40000 ALTER TABLE `salespersonmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `salespersonmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `straighttruckmaster`
--

DROP TABLE IF EXISTS `straighttruckmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `straighttruckmaster` (
  `unit_no` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(45) DEFAULT NULL,
  `VIN` varchar(45) DEFAULT NULL,
  `make` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `plate_no` varchar(45) DEFAULT NULL,
  `jurisdiction` varchar(45) DEFAULT NULL,
  `tare_weight` varchar(45) DEFAULT NULL,
  `rgw` varchar(45) DEFAULT NULL,
  `tracking_id` int(11) DEFAULT NULL,
  `current_odometer` varchar(45) DEFAULT NULL,
  `reading_taken` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `division` varchar(45) DEFAULT NULL,
  `terminal_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `IFTA_account` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`unit_no`),
  KEY `tracking_id_idx` (`tracking_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `category_id_straighttruckmaster` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id_straighttruckmaster` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tracking_id_straighttruckmaster` FOREIGN KEY (`tracking_id`) REFERENCES `trackingmaster` (`tracking_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `straighttruckmaster`
--

LOCK TABLES `straighttruckmaster` WRITE;
/*!40000 ALTER TABLE `straighttruckmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `straighttruckmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminalmaster`
--

DROP TABLE IF EXISTS `terminalmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminalmaster` (
  `terminal_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  UNIQUE KEY `terminal_id_UNIQUE` (`terminal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminalmaster`
--

LOCK TABLES `terminalmaster` WRITE;
/*!40000 ALTER TABLE `terminalmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminalmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackingmaster`
--

DROP TABLE IF EXISTS `trackingmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trackingmaster` (
  `tracking_id` int(11) NOT NULL AUTO_INCREMENT,
  `tracking_date` datetime DEFAULT NULL,
  PRIMARY KEY (`tracking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackingmaster`
--

LOCK TABLES `trackingmaster` WRITE;
/*!40000 ALTER TABLE `trackingmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `trackingmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trailermaster`
--

DROP TABLE IF EXISTS `trailermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trailermaster` (
  `trailer_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `VIN` varchar(45) DEFAULT NULL,
  `make` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `plate_no` varchar(45) DEFAULT NULL,
  `jurisdiction` varchar(45) DEFAULT NULL,
  `tare_weight` varchar(45) DEFAULT NULL,
  `rgw` varchar(45) DEFAULT NULL,
  `current_odometer` varchar(45) DEFAULT NULL,
  `reading_taken_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  PRIMARY KEY (`trailer_id`),
  KEY `class_id_idx` (`class_id`),
  KEY `equipment_id_idx` (`equipment_id`),
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `classmaster` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipmaster` (`equipment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trailermaster`
--

LOCK TABLES `trailermaster` WRITE;
/*!40000 ALTER TABLE `trailermaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `trailermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripmaster`
--

DROP TABLE IF EXISTS `tripmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tripmaster` (
  `trip_no` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) DEFAULT NULL,
  `truck_id` int(11) DEFAULT NULL,
  `trailer_id` int(11) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `next_date` datetime DEFAULT NULL,
  `next_event` varchar(45) DEFAULT NULL,
  `next_location` varchar(45) DEFAULT NULL,
  `next_city` varchar(45) DEFAULT NULL,
  `next_state` varchar(45) DEFAULT NULL,
  `last_location` varchar(45) DEFAULT NULL,
  `last_city` varchar(45) DEFAULT NULL,
  `last_state` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `cellular` varchar(45) DEFAULT NULL,
  `on_time` int(11) DEFAULT NULL,
  `check_call_location` varchar(45) DEFAULT NULL,
  `eta_to_nextstop` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trip_no`),
  KEY `driver_id_idx` (`driver_id`),
  KEY `truck_id_idx` (`truck_id`),
  KEY `trailer_id_idx` (`trailer_id`),
  CONSTRAINT `driver_id` FOREIGN KEY (`driver_id`) REFERENCES `drivermaster` (`driver_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `trailer_id` FOREIGN KEY (`trailer_id`) REFERENCES `trailermaster` (`trailer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `truck_id` FOREIGN KEY (`truck_id`) REFERENCES `powerunitmaster` (`unit_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripmaster`
--

LOCK TABLES `tripmaster` WRITE;
/*!40000 ALTER TABLE `tripmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `tripmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'jaimal','j4f76g','jaimal20.1990@gmail.com');
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

-- Dump completed on 2016-07-31 23:43:25
