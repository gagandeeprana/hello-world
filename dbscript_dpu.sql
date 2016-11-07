/*
SQLyog Community Edition- MySQL GUI v8.02 
MySQL - 5.0.67-community-nt : Database - dpu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

drop database if exists dpu;
create database dpu;
use dpu;

/*Table structure for table `acipassengermaster` */

DROP TABLE IF EXISTS `acipassengermaster`;

CREATE TABLE `acipassengermaster` (
  `passenger_id` int(11) NOT NULL auto_increment,
  `first_name` varchar(45) default NULL,
  `last_name` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  `present_state` varchar(45) default NULL,
  `zip` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  `cell_no` varchar(45) default NULL,
  `email_id` varchar(45) default NULL,
  `dob` datetime default NULL,
  PRIMARY KEY  (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `acipassengermaster` */

/*Table structure for table `additionalcontactforshipper` */

DROP TABLE IF EXISTS `additionalcontactforshipper`;

CREATE TABLE `additionalcontactforshipper` (
  `contactid` int(11) NOT NULL auto_increment,
  `contactname` varchar(40) default NULL,
  `position` varchar(40) default NULL,
  `phone` varchar(40) default NULL,
  `fax` varchar(40) default NULL,
  `cellular` varchar(40) default NULL,
  `email` varchar(40) default NULL,
  `ext` varchar(40) default NULL,
  `prefix` varchar(40) default NULL,
  `status` int(11) default NULL,
  `shipperid` int(11) default NULL,
  PRIMARY KEY  (`contactid`),
  KEY `shipperid` (`shipperid`),
  CONSTRAINT `additionalcontactforshipper_ibfk_1` FOREIGN KEY (`shipperid`) REFERENCES `shippermaster` (`shipper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `additionalcontactforshipper` */

insert  into `additionalcontactforshipper`(`contactid`,`contactname`,`position`,`phone`,`fax`,`cellular`,`email`,`ext`,`prefix`,`status`,`shipperid`) values (1,'jkj','kj','kj','kj','jk','kj','kj','jk',1,13),(2,'hjh','hjgh','76786','8789','7897','hgf','979','798',1,13),(3,'jkg','5765','765','76565','576','jhgbv','765','6',1,13);

/*Table structure for table `additionalcontactmaster` */

DROP TABLE IF EXISTS `additionalcontactmaster`;

CREATE TABLE `additionalcontactmaster` (
  `add_contact_id` int(11) NOT NULL auto_increment,
  `company_id` int(11) default NULL,
  `customer_name` varchar(30) default NULL,
  `position` varchar(40) default NULL,
  `phone` varchar(30) default NULL,
  `ext` varchar(30) default NULL,
  `fax` varchar(30) default NULL,
  `cellular` varchar(40) default NULL,
  `additional_contact_prefix` varchar(30) default NULL,
  `status` int(11) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`add_contact_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `additionalcontactmaster_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companymaster` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Data for the table `additionalcontactmaster` */

insert  into `additionalcontactmaster`(`add_contact_id`,`company_id`,`customer_name`,`position`,`phone`,`ext`,`fax`,`cellular`,`additional_contact_prefix`,`status`,`email`) values (5,30,'JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ',NULL,'JJJJJJJJJJJ',0,'JJJJJJJJJJJ'),(7,31,'JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ','JJJJJJJJJJJ',1,'JJJJJJJJJJJ'),(8,32,'AAAAAAA','AAAAAAAAAA','AAAAAAAAAA','AAAAAAAAAA','AAAAAAAAAA','AAAAAAAAAA','AAAAAAAAAA',1,'AAAAAAAAAA'),(9,33,'TTTTT','TTTTT','TTTTT','TTTTT','TTTTT','TTTTT','TTTTT',1,'TTTTT'),(29,30,'AAA','AAA','(222) 222-2222','AAA','(222) 222-2222','(222) 222-2222','AAA',1,'AAA'),(30,46,'OOKOK','OOKOK','(222) 222-2222','OOKOK','(222) 222-2222','(222) 222-2222','OOKOK',1,'OOKOK');

/*Table structure for table `billinglocationmaster` */

DROP TABLE IF EXISTS `billinglocationmaster`;

CREATE TABLE `billinglocationmaster` (
  `billing_location_id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `address` varchar(30) default NULL,
  `unit_no` varchar(30) default NULL,
  `city` varchar(30) default NULL,
  `province_state` varchar(30) default NULL,
  `zip` varchar(30) default NULL,
  `ar_cdn` varchar(30) default NULL,
  `ar_us` varchar(30) default NULL,
  `status` int(11) default NULL,
  `contact` varchar(30) default NULL,
  `position` varchar(30) default NULL,
  `email` varchar(30) default NULL,
  `cellular` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `ext` varchar(30) default NULL,
  `fax` varchar(30) default NULL,
  `billing_prefix` varchar(30) default NULL,
  `tollfree` varchar(30) default NULL,
  `company_id` int(11) default NULL,
  PRIMARY KEY  (`billing_location_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `billinglocationmaster_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companymaster` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `billinglocationmaster` */

insert  into `billinglocationmaster`(`billing_location_id`,`name`,`address`,`unit_no`,`city`,`province_state`,`zip`,`ar_cdn`,`ar_us`,`status`,`contact`,`position`,`email`,`cellular`,`phone`,`ext`,`fax`,`billing_prefix`,`tollfree`,`company_id`) values (15,'KKKKKKa','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO',1,'OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','KKKKK',32),(17,'JJJJJ','JJJJJ','JJJJJ','JJJJJ','JJJJJ','JJJJJ','JJJJJ','JJJJJ',1,'JJJJJ','JJJJJ','JJJJJ','(444) 444-4444','(444) 444-4444','JJJJJ','(444) 444-4444','JJJJJ','(444) 444-4444',45),(18,'AAA','AAA','AAA','AAA','AAA','6786','86786','86876',1,'AAA','AAA','AAA','(868) 686-8686','(777) 777-7777','7777','(876) 876-8768','876','(___) ___-____',NULL),(19,'HH','HH','HH','HH','HH','HH','HH','HH',1,'HH','HH','HH','(111) 111-1111','(111) 111-1111','HH','(111) 111-1111','HH','(111) 111-1111',30),(20,'asdsdasd','asdas','dasd','asdasdasd','asdasdasd','asdasdasd','asdasdasd','asdasdasd',1,'asdasdasd','asdasdasd','asdasdasd','(222) 222-2222','(222) 222-2222','asdasdasd','(222) 222-2222','asdasdasd','(222) 222-2222',46);

/*Table structure for table `border_agent` */

DROP TABLE IF EXISTS `border_agent`;

CREATE TABLE `border_agent` (
  `border_agent_id` int(11) NOT NULL auto_increment,
  `code` varchar(40) default NULL,
  `border_agent` varchar(30) default NULL,
  `border_crossing` varchar(40) default NULL,
  `phone` varchar(40) default NULL,
  `ext` varchar(30) default NULL,
  `fax` varchar(30) default NULL,
  `after_hour` varchar(50) default NULL,
  `status` int(11) default NULL,
  `email` varchar(30) default NULL,
  `open_from` varchar(20) default NULL,
  `open_to` varchar(30) default NULL,
  `is24Hr` int(11) default NULL,
  `comments` varchar(30) default NULL,
  `custom_broker_id` int(11) default NULL,
  PRIMARY KEY  (`border_agent_id`),
  KEY `border_agent_ibfk_1` (`custom_broker_id`),
  CONSTRAINT `border_agent_ibfk_1` FOREIGN KEY (`custom_broker_id`) REFERENCES `custombrokermaster` (`custom_broker_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `border_agent` */

insert  into `border_agent`(`border_agent_id`,`code`,`border_agent`,`border_crossing`,`phone`,`ext`,`fax`,`after_hour`,`status`,`email`,`open_from`,`open_to`,`is24Hr`,`comments`,`custom_broker_id`) values (1,'sdf','sdf','sdf','sdf','sdf','sdf',NULL,1,'sdf','sdf','dfd',1,'sdf',1);

/*Table structure for table `categorymaster` */

DROP TABLE IF EXISTS `categorymaster`;

CREATE TABLE `categorymaster` (
  `category_id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `status` int(11) default NULL,
  `type_id` int(11) default NULL,
  PRIMARY KEY  (`category_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `categorymaster_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `typemaster` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `categorymaster` */

insert  into `categorymaster`(`category_id`,`name`,`status`,`type_id`) values (1,'sdfsd',1,3),(2,'Cat',0,4);

/*Table structure for table `classmaster` */

DROP TABLE IF EXISTS `classmaster`;

CREATE TABLE `classmaster` (
  `class_id` int(11) NOT NULL auto_increment,
  `title` varchar(150) default NULL,
  PRIMARY KEY  (`class_id`),
  UNIQUE KEY `class_id_UNIQUE` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `classmaster` */

insert  into `classmaster`(`class_id`,`title`) values (1,'CLASSa'),(2,'BB');

/*Table structure for table `companymaster` */

DROP TABLE IF EXISTS `companymaster`;

CREATE TABLE `companymaster` (
  `company_id` int(11) NOT NULL auto_increment,
  `name` varchar(155) default NULL,
  `address` varchar(50) default NULL,
  `unit_no` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `province_state` varchar(50) default NULL,
  `zip` varchar(30) default NULL,
  `email` varchar(50) default NULL,
  `website` varchar(50) default NULL,
  `contact` varchar(30) default NULL,
  `position` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `ext` varchar(20) default NULL,
  `fax` varchar(40) default NULL,
  `company_prefix` varchar(30) default NULL,
  `tollfree` varchar(30) default NULL,
  `cellular` varchar(30) default NULL,
  `pager` varchar(30) default NULL,
  `customer_notes` varchar(500) default NULL,
  `after_hours` varchar(30) default NULL,
  PRIMARY KEY  (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

/*Data for the table `companymaster` */

insert  into `companymaster`(`company_id`,`name`,`address`,`unit_no`,`city`,`province_state`,`zip`,`email`,`website`,`contact`,`position`,`phone`,`ext`,`fax`,`company_prefix`,`tollfree`,`cellular`,`pager`,`customer_notes`,`after_hours`) values (30,'GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG','GGGGG',NULL,'(___) ___-____'),(31,'YYYYY','YYYYY','YYYYY','YYYYY','YYYYY','YYYYY','YYYYY','YYYYY','YYYYY','YYYYY','(222) 222-2222','YYYYY','(222) 222-2222','YYYYY','(222) 222-2222','(222) 222-2222','(222) 222-2222',NULL,'(222) 222-2222'),(32,'OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','OOOOO','(222) 222-2222','OOOOO','(222) 222-2222','OOOOO','(222) 222-2222','(222) 222-2222','(222) 222-2222',NULL,'(222) 222-2222'),(33,'JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','JHJHJHHJH','(222) 222-2222','JHJHJHHJH','(222) 222-2222','JHJHJHHJH','(222) 222-2222','(222) 222-2222','(222) 222-2222',NULL,'(222) 222-2222'),(45,'New Cust111','New Cust111','New Cust111','New Cust111','New Cust111','New Cust111','New Cust111','New Cust111','New Cust111','New Cust111','(777) 777-7777','New Cust111','(777) 777-7777','New Cust111','(777) 777-7777','(777) 777-7777','(777) 777-7777',NULL,'(777) 777-7777'),(46,'WSWS','WSWS','WSWS','WSWS','WSWS','WSWS','WSWS','WSWS','WSWS','WSWS','(222) 222-2222','WSWS','(222) 222-2222','WSWS','(222) 222-2222','(222) 222-2222','(222) 222-2222',NULL,'(222) 222-2222');

/*Table structure for table `containermaster` */

DROP TABLE IF EXISTS `containermaster`;

CREATE TABLE `containermaster` (
  `container_id` int(11) NOT NULL auto_increment,
  `unit_no` varchar(30) default NULL,
  `type` varchar(30) default NULL,
  `terminal_id` int(11) default NULL,
  `status` int(11) default NULL,
  `category_id` int(11) default NULL,
  `owner` varchar(40) default NULL,
  `location` varchar(40) default NULL,
  PRIMARY KEY  (`container_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `containermaster_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`),
  CONSTRAINT `terminal_id_containermaster` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `containermaster` */

/*Table structure for table `countrymaster` */

DROP TABLE IF EXISTS `countrymaster`;

CREATE TABLE `countrymaster` (
  `country_id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  PRIMARY KEY  (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `countrymaster` */

insert  into `countrymaster`(`country_id`,`name`) values (1,'CA');

/*Table structure for table `custombrokermaster` */

DROP TABLE IF EXISTS `custombrokermaster`;

CREATE TABLE `custombrokermaster` (
  `custom_broker_id` int(11) NOT NULL auto_increment,
  `custom_broker` varchar(30) default NULL,
  `contact_name` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `ext` varchar(30) default NULL,
  `fax_no` varchar(30) default NULL,
  `status` int(11) default NULL,
  `email` varchar(30) default NULL,
  `website` varchar(50) default NULL,
  PRIMARY KEY  (`custom_broker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `custombrokermaster` */

insert  into `custombrokermaster`(`custom_broker_id`,`custom_broker`,`contact_name`,`phone`,`ext`,`fax_no`,`status`,`email`,`website`) values (1,'sdf','sdf','sdf','sdfsd','(333) 333-3333',0,'sdfs','sdf'),(7,'JJJJJJJJ','JJJJJJJJ','(345) 345-3535','JJJJJJJJ','(345) 345-3453',1,'JJJJJJJJ','JJJJJJJJ');

/*Table structure for table `divisionmaster` */

DROP TABLE IF EXISTS `divisionmaster`;

CREATE TABLE `divisionmaster` (
  `division_id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  PRIMARY KEY  (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `divisionmaster` */

insert  into `divisionmaster`(`division_id`,`name`) values (1,'Toronto'),(2,'Calgary111'),(3,'Alberta'),(4,'Missisauga'),(5,'Ontario'),(6,'Ottawa'),(7,'Regina'),(8,'London'),(9,'Niagara');

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `driver_id` bigint(45) NOT NULL auto_increment,
  `driver_code` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) default NULL,
  `address` varchar(250) default NULL,
  `unit` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `pvs` varchar(50) default NULL,
  `postal_code` varchar(50) default NULL,
  `e_mail` varchar(50) default NULL,
  `home` varchar(50) default NULL,
  `fax_no` varchar(50) default NULL,
  `cellular` varchar(50) default NULL,
  `pager` varchar(50) default NULL,
  `division` varchar(50) default NULL,
  `terminal` bigint(50) default NULL,
  `category` bigint(50) default NULL,
  `role` bigint(50) default NULL,
  `status` bigint(50) default NULL,
  `class` bigint(50) default NULL,
  PRIMARY KEY  (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `driver` */

insert  into `driver`(`driver_id`,`driver_code`,`first_name`,`last_name`,`address`,`unit`,`city`,`pvs`,`postal_code`,`e_mail`,`home`,`fax_no`,`cellular`,`pager`,`division`,`terminal`,`category`,`role`,`status`,`class`) values (1,' qwqwe',' weew',' we',' we',' ',' ','',' ',' ',' ',' ',' ',' ',' ',1,1,1,1,1),(2,' hj',' ko',' po',' ',' ',' ','',' ',' ',' ',' ',' ',' ',' ',1,1,1,1,1),(3,' ii',' kjk',' ',' ',' ',' ','',' ',' ',' ',' ',' ',' ',' ',1,1,1,1,1),(4,' 52626',' sumit',' singh',' Lotton',' Naraingarh',' Ambala','101',' 134203',' sum@gmail.com',' 129291',' 1313',' 133313',' 13313',' 1st',1,1,1,1,1),(5,' 123',' gagan',' deep',' mohali',' punjab',' Mohali','102',' 144004',' gagan@gmail.com',' 23232',' 232233',' 233232',' 23232323',' 1st',1,1,1,1,1),(6,' 123','Joney',' singh',' Lotton',' sd',' Chd','ss',' 134203',' joney@gmail.com','232342',' 23232',' 23434',' 2342342',' second',1,1,1,1,1),(7,' 123',' weweew',' weew',' wewe','ewe ',' weww','ew',' we',' weerew','34546',' 46456',' 2442',' 54643',' snd',1,1,1,1,1),(8,' 33',' sam',' singh',' lal',' aaa',' aa','aga','443',' akaka',' aaa',' aaa',' aa',' 7',' gg',1,1,1,1,1);

/*Table structure for table `drivermaster` */

DROP TABLE IF EXISTS `drivermaster`;

CREATE TABLE `drivermaster` (
  `driver_id` int(11) NOT NULL auto_increment,
  `driver_code` varchar(45) default NULL,
  `first_name` varchar(45) default NULL,
  `last_name` varchar(45) default NULL,
  `def_truck` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `home_phone` varchar(45) default NULL,
  `cellular` varchar(45) default NULL,
  `pager` varchar(45) default NULL,
  `status` int(11) default NULL,
  `last_trip` varchar(45) default NULL,
  `last_ETA` date default NULL,
  `last_event` varchar(45) default NULL,
  `last_location` varchar(45) default NULL,
  `last_city` varchar(45) default NULL,
  `L/S` varchar(45) default NULL,
  `fax_no` varchar(45) default NULL,
  `division_id` int(11) default NULL,
  `terminal_id` int(11) default NULL,
  `category_id` int(11) default NULL,
  `class_id` int(11) default NULL,
  `zip` varchar(45) default NULL,
  `role_id` int(11) default NULL,
  PRIMARY KEY  (`driver_id`),
  KEY `division_id_idx` (`division_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  KEY `category_id_idx` (`category_id`),
  KEY `class_id_idx` (`class_id`),
  CONSTRAINT `category_id_drivermaster` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `class_id_drivermaster` FOREIGN KEY (`class_id`) REFERENCES `classmaster` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `division_id_drivermaster` FOREIGN KEY (`division_id`) REFERENCES `divisionmaster` (`division_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id_drivermaster` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `drivermaster` */

/*Table structure for table `equipmaster` */

DROP TABLE IF EXISTS `equipmaster`;

CREATE TABLE `equipmaster` (
  `equipment_id` int(11) NOT NULL auto_increment,
  `equipment_name` varchar(150) default NULL,
  `description` varchar(150) default NULL,
  PRIMARY KEY  (`equipment_id`),
  UNIQUE KEY `container_id_UNIQUE` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `equipmaster` */

/*Table structure for table `equipmentmaster` */

DROP TABLE IF EXISTS `equipmentmaster`;

CREATE TABLE `equipmentmaster` (
  `equipment_id` int(11) NOT NULL auto_increment,
  `equipment_name` varchar(50) default NULL,
  `description` varchar(50) default NULL,
  PRIMARY KEY  (`equipment_id`),
  UNIQUE KEY `container_id_UNIQUE` (`equipment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `equipmentmaster` */

insert  into `equipmentmaster`(`equipment_id`,`equipment_name`,`description`) values (1,'JJJGG',NULL),(2,'Power Unit','asas');

/*Table structure for table `jurisdictionmaster` */

DROP TABLE IF EXISTS `jurisdictionmaster`;

CREATE TABLE `jurisdictionmaster` (
  `jurisdiction_id` int(11) NOT NULL auto_increment,
  `jurisdiction_name` varchar(30) default NULL,
  `jurisdiction_IFA` varchar(30) default NULL,
  `country_id` int(11) default NULL,
  `road_tax` decimal(10,2) default NULL,
  PRIMARY KEY  (`jurisdiction_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `jurisdictionmaster_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countrymaster` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jurisdictionmaster` */

/*Table structure for table `ordermaster` */

DROP TABLE IF EXISTS `ordermaster`;

CREATE TABLE `ordermaster` (
  `order_id` int(11) NOT NULL auto_increment,
  `customer_id` int(11) default NULL,
  `bill_to` varchar(50) default NULL,
  `caller_name` varchar(50) default NULL,
  `po_number` varchar(50) default NULL,
  `payment` int(11) default NULL,
  `probill` int(11) default NULL,
  `category_id` int(11) default NULL,
  `shipper_id` int(11) default NULL,
  `consignee_id` int(11) default NULL,
  PRIMARY KEY  (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `category_id` (`category_id`),
  KEY `shipper_id` (`shipper_id`),
  KEY `consignee_id` (`consignee_id`),
  CONSTRAINT `ordermaster_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `companymaster` (`company_id`),
  CONSTRAINT `ordermaster_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`),
  CONSTRAINT `ordermaster_ibfk_3` FOREIGN KEY (`shipper_id`) REFERENCES `shippermaster` (`shipper_id`),
  CONSTRAINT `ordermaster_ibfk_4` FOREIGN KEY (`consignee_id`) REFERENCES `shippermaster` (`shipper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ordermaster` */

/*Table structure for table `payment_terms` */

DROP TABLE IF EXISTS `payment_terms`;

CREATE TABLE `payment_terms` (
  `term_id` int(11) NOT NULL auto_increment,
  `term` varchar(50) default NULL,
  `net_due_in` int(11) default NULL,
  `discount_percent` decimal(10,2) default NULL,
  `is_discount_paid` int(11) default NULL,
  `discount_within_days` int(11) default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`term_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `payment_terms` */

insert  into `payment_terms`(`term_id`,`term`,`net_due_in`,`discount_percent`,`is_discount_paid`,`discount_within_days`,`status`) values (2,'New11',12,'34.80',1,4,0);

/*Table structure for table `powerunitmaster` */

DROP TABLE IF EXISTS `powerunitmaster`;

CREATE TABLE `powerunitmaster` (
  `unit_no` int(11) NOT NULL auto_increment,
  `status` varchar(45) default NULL,
  `truck_class` varchar(45) default NULL,
  `owner_id` int(11) default NULL,
  `VIN` varchar(45) default NULL,
  `make` varchar(45) default NULL,
  `model` varchar(45) default NULL,
  `truck_year` int(11) default NULL,
  `plate_no` varchar(45) default NULL,
  `jurisdiction` varchar(10) default NULL,
  `tare_weight` int(11) default NULL,
  `rgw` varchar(155) default NULL,
  `tracking_id` int(11) default NULL,
  `current_odometer` varchar(45) default NULL,
  `equipment_type` varchar(45) default NULL,
  `terminal_id` int(11) default NULL,
  PRIMARY KEY  (`unit_no`),
  KEY `owner_id_idx` (`owner_id`),
  KEY `tracking_id_idx` (`tracking_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  CONSTRAINT `owner_id` FOREIGN KEY (`owner_id`) REFERENCES `companymaster` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE CASCADE,
  CONSTRAINT `tracking_id` FOREIGN KEY (`tracking_id`) REFERENCES `trackingmaster` (`tracking_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `powerunitmaster` */

/*Table structure for table `rolemaster` */

DROP TABLE IF EXISTS `rolemaster`;

CREATE TABLE `rolemaster` (
  `role_id` int(11) NOT NULL auto_increment,
  `title` varchar(45) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rolemaster` */

/*Table structure for table `salespersonmaster` */

DROP TABLE IF EXISTS `salespersonmaster`;

CREATE TABLE `salespersonmaster` (
  `person_id` int(11) NOT NULL auto_increment,
  `code` varchar(30) default NULL,
  `status` int(11) default NULL,
  `name` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `unit_no` varchar(30) default NULL,
  `city` varchar(45) default NULL,
  `present_state` varchar(45) default NULL,
  `postal_code` varchar(45) default NULL,
  `phone_no` varchar(45) default NULL,
  `fax_no` varchar(45) default NULL,
  `cellular_no` varchar(45) default NULL,
  `pager_no` varchar(45) default NULL,
  `ext` varchar(30) default NULL,
  `sales_person_prefix` varchar(30) default NULL,
  `email` varchar(50) default NULL,
  `ar_cdn` varchar(30) default NULL,
  `ar_us` varchar(30) default NULL,
  `base_salary` decimal(10,2) default NULL,
  `paid` int(11) default NULL,
  `percent_on_applicable_revenue` varchar(30) default NULL,
  `percent_on_gross_profit` varchar(30) default NULL,
  `max_commission_paid` varchar(30) default NULL,
  PRIMARY KEY  (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `salespersonmaster` */

insert  into `salespersonmaster`(`person_id`,`code`,`status`,`name`,`address`,`unit_no`,`city`,`present_state`,`postal_code`,`phone_no`,`fax_no`,`cellular_no`,`pager_no`,`ext`,`sales_person_prefix`,`email`,`ar_cdn`,`ar_us`,`base_salary`,`paid`,`percent_on_applicable_revenue`,`percent_on_gross_profit`,`max_commission_paid`) values (2,'GGG',1,'GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','GGG','234.00',4,'34','56','12'),(3,'asas',1,'asas','asas','asa','sasa','sas','asa','sasa','asa','as','222','sas','sas','asas','asasas','asas','232.00',0,'223','23','23');

/*Table structure for table `shippermaster` */

DROP TABLE IF EXISTS `shippermaster`;

CREATE TABLE `shippermaster` (
  `shipper_id` int(11) NOT NULL auto_increment,
  `company` varchar(40) default NULL,
  `Address` varchar(100) default NULL,
  `unit` varchar(40) default NULL,
  `city` varchar(40) default NULL,
  `prov_state` varchar(40) default NULL,
  `postal_zip` varchar(40) default NULL,
  `zone` varchar(40) default NULL,
  `status` int(11) default NULL,
  `lead_time` varchar(40) default NULL,
  `time_zone` varchar(40) default NULL,
  `internam_notes` varchar(100) default NULL,
  `contact` varchar(40) default NULL,
  `position` varchar(40) default NULL,
  `phone` varchar(40) default NULL,
  `fax` varchar(40) default NULL,
  `toll_free` varchar(40) default NULL,
  `ext` varchar(40) default NULL,
  `prefix` varchar(40) default NULL,
  `plant` varchar(40) default NULL,
  `email` varchar(40) default NULL,
  `importer` varchar(40) default NULL,
  `standard_notes` varchar(100) default NULL,
  PRIMARY KEY  (`shipper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `shippermaster` */

insert  into `shippermaster`(`shipper_id`,`company`,`Address`,`unit`,`city`,`prov_state`,`postal_zip`,`zone`,`status`,`lead_time`,`time_zone`,`internam_notes`,`contact`,`position`,`phone`,`fax`,`toll_free`,`ext`,`prefix`,`plant`,`email`,`importer`,`standard_notes`) values (1,'hj','fghj','fgh','hjg','j','45','gh',0,' gj','Item 2','fghjkl','678','gh','87687','8767','567','jh','6786','fg','dfgh','ghjk','fghjkl');

/*Table structure for table `standard_charges` */

DROP TABLE IF EXISTS `standard_charges`;

CREATE TABLE `standard_charges` (
  `standard_charges_id` int(11) NOT NULL auto_increment,
  `code` varchar(30) default NULL,
  `charge_type1` int(11) default NULL,
  `description` varchar(60) default NULL,
  `amount_as` int(11) default NULL,
  `base_charge` varchar(50) default NULL,
  `max_charge` varchar(50) default NULL,
  `charge_type2` int(11) default NULL,
  `status` int(11) default NULL,
  `include_charge_amount` int(11) default NULL,
  `calculate_fuel_surcharge` int(11) default NULL,
  `include_driver_payroll` int(11) default NULL,
  PRIMARY KEY  (`standard_charges_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `standard_charges` */

insert  into `standard_charges`(`standard_charges_id`,`code`,`charge_type1`,`description`,`amount_as`,`base_charge`,`max_charge`,`charge_type2`,`status`,`include_charge_amount`,`calculate_fuel_surcharge`,`include_driver_payroll`) values (3,'aaaaa',1,'aaaaaaa',1,'34543','35666',1,1,1,1,1),(6,'aas',1,'asas',3,'3434','65765',1,1,1,1,1);

/*Table structure for table `straighttruckmaster` */

DROP TABLE IF EXISTS `straighttruckmaster`;

CREATE TABLE `straighttruckmaster` (
  `unit_no` int(11) NOT NULL auto_increment,
  `class` varchar(45) default NULL,
  `VIN` varchar(45) default NULL,
  `make` varchar(45) default NULL,
  `model` varchar(45) default NULL,
  `year` int(11) default NULL,
  `plate_no` varchar(45) default NULL,
  `jurisdiction` varchar(45) default NULL,
  `tare_weight` varchar(45) default NULL,
  `rgw` varchar(45) default NULL,
  `tracking_id` int(11) default NULL,
  `current_odometer` varchar(45) default NULL,
  `reading_taken` date default NULL,
  `created_by` int(11) default NULL,
  `created_on` date default NULL,
  `division` varchar(45) default NULL,
  `terminal_id` int(11) default NULL,
  `category_id` int(11) default NULL,
  `IFTA_account` varchar(45) default NULL,
  PRIMARY KEY  (`unit_no`),
  KEY `tracking_id_idx` (`tracking_id`),
  KEY `terminal_id_idx` (`terminal_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `category_id_straighttruckmaster` FOREIGN KEY (`category_id`) REFERENCES `categorymaster` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `terminal_id_straighttruckmaster` FOREIGN KEY (`terminal_id`) REFERENCES `terminalmaster` (`terminal_id`) ON DELETE CASCADE,
  CONSTRAINT `tracking_id_straighttruckmaster` FOREIGN KEY (`tracking_id`) REFERENCES `trackingmaster` (`tracking_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `straighttruckmaster` */

/*Table structure for table `terminalmaster` */

DROP TABLE IF EXISTS `terminalmaster`;

CREATE TABLE `terminalmaster` (
  `terminal_id` int(11) NOT NULL auto_increment,
  `terminal_name` varchar(50) default NULL,
  `location` varchar(50) default NULL,
  UNIQUE KEY `terminal_id_UNIQUE` (`terminal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `terminalmaster` */

insert  into `terminalmaster`(`terminal_id`,`terminal_name`,`location`) values (4,'abc','ww');

/*Table structure for table `trackingmaster` */

DROP TABLE IF EXISTS `trackingmaster`;

CREATE TABLE `trackingmaster` (
  `tracking_id` int(11) NOT NULL auto_increment,
  `tracking_date` datetime default NULL,
  PRIMARY KEY  (`tracking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `trackingmaster` */

insert  into `trackingmaster`(`tracking_id`,`tracking_date`) values (1,'2016-09-09 00:00:00');

/*Table structure for table `trailermaster` */

DROP TABLE IF EXISTS `trailermaster`;

CREATE TABLE `trailermaster` (
  `trailer_id` int(11) NOT NULL auto_increment,
  `class_id` int(11) default NULL,
  `equipment_id` int(11) default NULL,
  `length` int(11) default NULL,
  `VIN` varchar(45) default NULL,
  `make` varchar(45) default NULL,
  `model` varchar(45) default NULL,
  `year` int(11) default NULL,
  `plate_no` varchar(45) default NULL,
  `jurisdiction` varchar(45) default NULL,
  `tare_weight` varchar(45) default NULL,
  `rgw` varchar(45) default NULL,
  `current_odometer` varchar(45) default NULL,
  `reading_taken_date` datetime default NULL,
  `created_by` int(11) default NULL,
  `created_on` datetime default NULL,
  PRIMARY KEY  (`trailer_id`),
  KEY `class_id_idx` (`class_id`),
  KEY `equipment_id_idx` (`equipment_id`),
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `classmaster` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equipment_id` FOREIGN KEY (`equipment_id`) REFERENCES `equipmentmaster` (`equipment_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `trailermaster` */

insert  into `trailermaster`(`trailer_id`,`class_id`,`equipment_id`,`length`,`VIN`,`make`,`model`,`year`,`plate_no`,`jurisdiction`,`tare_weight`,`rgw`,`current_odometer`,`reading_taken_date`,`created_by`,`created_on`) values (1,1,1,345,'sdfsd','gfhfg','sdfsdf',2016,'dfgdfg','3454','3454','345345','sdfsdf','2015-09-09 00:00:00',1,'2016-08-02 15:26:04');

/*Table structure for table `tripmaster` */

DROP TABLE IF EXISTS `tripmaster`;

CREATE TABLE `tripmaster` (
  `trip_no` int(11) NOT NULL auto_increment,
  `driver_id` int(11) default NULL,
  `truck_id` int(11) default NULL,
  `trailer_id` int(11) default NULL,
  `comment` varchar(45) default NULL,
  `next_date` datetime default NULL,
  `next_event` varchar(45) default NULL,
  `next_location` varchar(45) default NULL,
  `next_city` varchar(45) default NULL,
  `next_state` varchar(45) default NULL,
  `last_location` varchar(45) default NULL,
  `last_city` varchar(45) default NULL,
  `last_state` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  `cellular` varchar(45) default NULL,
  `on_time` int(11) default NULL,
  `check_call_location` varchar(45) default NULL,
  `eta_to_nextstop` varchar(45) default NULL,
  PRIMARY KEY  (`trip_no`),
  KEY `driver_id_idx` (`driver_id`),
  KEY `truck_id_idx` (`truck_id`),
  KEY `trailer_id_idx` (`trailer_id`),
  CONSTRAINT `driver_id` FOREIGN KEY (`driver_id`) REFERENCES `drivermaster` (`driver_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `trailer_id` FOREIGN KEY (`trailer_id`) REFERENCES `trailermaster` (`trailer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `truck_id` FOREIGN KEY (`truck_id`) REFERENCES `powerunitmaster` (`unit_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tripmaster` */

/*Table structure for table `typemaster` */

DROP TABLE IF EXISTS `typemaster`;

CREATE TABLE `typemaster` (
  `type_id` int(11) NOT NULL auto_increment,
  `type_name` varchar(50) default NULL,
  PRIMARY KEY  (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `typemaster` */

insert  into `typemaster`(`type_id`,`type_name`) values (3,'Customers'),(4,'Contract');

/*Table structure for table `usermaster` */

DROP TABLE IF EXISTS `usermaster`;

CREATE TABLE `usermaster` (
  `user_id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `usermaster` */

insert  into `usermaster`(`user_id`,`username`,`password`,`email`) values (1,'jaimal','j4f76g','jaimal20.1990@gmail.com');

/*Table structure for table `working_hours_additionalcontact` */

DROP TABLE IF EXISTS `working_hours_additionalcontact`;

CREATE TABLE `working_hours_additionalcontact` (
  `working_id` int(11) NOT NULL auto_increment,
  `working_day` varchar(30) default NULL,
  `open1` varchar(30) default NULL,
  `open2` varchar(30) default NULL,
  `close1` varchar(30) default NULL,
  `close2` varchar(30) default NULL,
  `is24Hr` int(11) default NULL,
  `additional_contact_id` int(11) default NULL,
  PRIMARY KEY  (`working_id`),
  KEY `additional_contact_id` (`additional_contact_id`),
  CONSTRAINT `working_hours_additionalcontact_ibfk_1` FOREIGN KEY (`additional_contact_id`) REFERENCES `additionalcontactmaster` (`add_contact_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `working_hours_additionalcontact` */

/*Table structure for table `working_hours_additionalshipper` */

DROP TABLE IF EXISTS `working_hours_additionalshipper`;

CREATE TABLE `working_hours_additionalshipper` (
  `working_id` int(10) NOT NULL auto_increment,
  `working_day` varchar(30) default NULL,
  `open1` varchar(30) default NULL,
  `open2` varchar(30) default NULL,
  `close1` varchar(30) default NULL,
  `close2` varchar(30) default NULL,
  `is24Hr` int(11) default NULL,
  `additional_shipper_id` int(11) default NULL,
  `type` varchar(40) default NULL,
  PRIMARY KEY  (`working_id`),
  KEY `additional_shipper_id` (`additional_shipper_id`),
  CONSTRAINT `working_hours_additionalshipper_ibfk_1` FOREIGN KEY (`additional_shipper_id`) REFERENCES `shippermaster` (`shipper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `working_hours_additionalshipper` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
