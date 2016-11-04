drop database if exists jiqa;
create database jiqa;
use jiqa;

-- MySQL dump 10.13  Distrib 5.6.33, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: jiqa
-- ------------------------------------------------------
-- Server version	5.6.33-0ubuntu0.14.04.1

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
-- Table structure for table `categorymaster`
--

DROP TABLE IF EXISTS `categorymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorymaster` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `image_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorymaster`
--

LOCK TABLES `categorymaster` WRITE;
/*!40000 ALTER TABLE `categorymaster` DISABLE KEYS */;
INSERT INTO `categorymaster` VALUES (7,'String',1,NULL),(9,'QQQ',1,NULL),(41,'eeeee',0,NULL),(42,'asasa1',0,NULL),(43,'jjj',1,NULL),(44,'yyy',1,NULL),(45,'cfsd',1,NULL),(46,'asas',1,NULL),(47,'eeee',1,NULL),(48,'QQq',1,'Terminal.JPG'),(49,'www',1,'Euipment Type 1.JPG'),(50,'asas',0,'List.JPG'),(51,'qqq',1,'Image3.jpg'),(52,'',1,''),(53,'',1,''),(54,'qQQ',1,'MyPic.jpg'),(55,'dsfsdfsd',1,'no-category-image.jpg'),(56,'sdfsdf',1,'Terminal.JPG'),(57,'Exception Handling',1,'List.JPG'),(58,'New Cat11',1,'Euipment Type 1.JPG'),(59,'cc',1,'Terminal.JPG'),(60,'XXX',1,'List.JPG'),(61,'WW',1,'better-blog-categories.jpg');
/*!40000 ALTER TABLE `categorymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionmaster`
--

DROP TABLE IF EXISTS `questionmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionmaster` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) DEFAULT NULL,
  `answer` varchar(2500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `questionmaster_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionmaster`
--

LOCK TABLES `questionmaster` WRITE;
/*!40000 ALTER TABLE `questionmaster` DISABLE KEYS */;
INSERT INTO `questionmaster` VALUES (1,'WW','EE',1,7),(2,'ERR','RRR',0,43),(3,'RR','RRR',1,44),(10,'a','a',1,7),(11,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','a\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na',1,7),(12,'Hashing :How Hash Map Works ?','How Hashmap works in Java\r\n\r\nHashMap works on the principle of Hashing .  To understand Hashing , we should understand the three terms first   i.e  Hash Function , Hash Value and Bucket .\r\n\r\nWhat is Hash Function , Hash Value  and Bucket ?\r\n\r\nhashCode() function  which returns an integer value is the Hash function. The important point to note that ,  this method is present in Object class ( Mother of all class ) .\r\n\r\nThis is the code for the hash function(also known as hashCode method) in Object Class :\r\n\r\n    public native int hashCode();\r\n\r\nThe most important point to note from the above line :  hashCode method return  int value .\r\nSo the Hash value is the int value returned by the hash function .\r\n\r\nWhat is bucket ? \r\nA bucket is used to store key value pairs . A bucket can have multiple key-value pairs . In hash map, bucket used simple linked list to store objects .\r\n\r\n\r\n\r\nAfter understanding the terms we are ready to move next step , How hash map works in java or How get() works internally in java .\r\n\r\n\r\nCode inside Java Api (HashMap class internal implementation) for HashMap get(Obejct key) method ',1,7),(13,'How HashMap works in Java','HashMap in Java works on hashing principle. It is a data structure which allows us to store object and retrieve it in constant time O(1) provided we know the key. In hashing, hash functions are used to link key and value in HashMap. Objects are stored by calling put(key, value) method of HashMap and retrieved by calling get(key) method. When we call put method, hashcode() method of the key object is called so that hash function of the map can find a bucket location to store value object, which is actually an index of the internal array, known as the table. HashMap internally stores mapping in the form of Map.\r\n\r\n\r\n\r\nEntry object which contains both key and value object. When you want to retrieve the object, you call the get() method and again pass the key object. This time again key object generate same hash code (it\'s mandatory for it to do so to retrieve the object and that\'s why HashMap keys are immutable e.g. String) and we end up at same bucket location. If there is only one object then it is returned and that\'s your value object which you have stored earlier. Things get little tricky when collisions occur. It\'s easy to answer this question if you have read good books on data structure and algorithms like this one. If you know how hash table data structure works then this is a piece of cake.\r\n\r\nSince the internal array of HashMap is of fixed size, and if you keep storing objects, at some point of time hash function will return same bucket location for two different keys, this is called collision in HashMap. In this case, a linked list is formed at that bucket location and a new entry is stored as next node.\r\n\r\n',1,7),(14,'nhgjhgjhg','',1,7),(15,'asdadasdas','',1,7);
/*!40000 ALTER TABLE `questionmaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-03 12:59:01
