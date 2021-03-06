-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: webapp
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `accesscode`
--

DROP TABLE IF EXISTS `accesscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accesscode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(60) DEFAULT NULL,
  `province_id` int(11) NOT NULL,
  `citylookup_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_accessCode_province1_idx` (`province_id`),
  KEY `fk_accesscode_citylookup1_idx` (`citylookup_id`),
  CONSTRAINT `fk_accessCode_province1` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_accesscode_citylookup1` FOREIGN KEY (`citylookup_id`) REFERENCES `citylookup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesscode`
--

LOCK TABLES `accesscode` WRITE;
/*!40000 ALTER TABLE `accesscode` DISABLE KEYS */;
INSERT INTO `accesscode` VALUES (1,'web1try',1,1);
/*!40000 ALTER TABLE `accesscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citylookup`
--

DROP TABLE IF EXISTS `citylookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citylookup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(45) DEFAULT NULL,
  `province_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_citylookup_province1_idx` (`province_id`),
  CONSTRAINT `fk_citylookup_province1` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citylookup`
--

LOCK TABLES `citylookup` WRITE;
/*!40000 ALTER TABLE `citylookup` DISABLE KEYS */;
INSERT INTO `citylookup` VALUES (1,'Ottawa',1),(2,'Toronto',1),(3,'Calgary',2),(4,'Vancouver',3),(5,'Winnipeg',4),(6,'Saint John',5),(7,'St. John',6),(8,'Yellowknife',7),(9,'Halifax',8),(10,'Iqaluit',9),(11,'Charlottetown',10),(12,'Montreal',11),(13,'Regina',12),(14,'Whitehorse',13),(16,'Windsor',1),(17,'Hamilton',1),(18,'Guelph',1),(19,'Edmonton',2),(20,'ottawa',2),(21,'Sasskatoon',12),(22,'Blargh',5);
/*!40000 ALTER TABLE `citylookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incident_action`
--

DROP TABLE IF EXISTS `incident_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incident_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(1023) DEFAULT NULL,
  `userInfos_id` int(11) NOT NULL,
  `incidentReports_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_incident_action_userInfos1_idx` (`userInfos_id`),
  KEY `fk_incident_action_incidentReports1_idx` (`incidentReports_id`),
  CONSTRAINT `fk_incident_action_incidentReports1` FOREIGN KEY (`incidentReports_id`) REFERENCES `incidentreports` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_incident_action_userInfos1` FOREIGN KEY (`userInfos_id`) REFERENCES `userinfos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incident_action`
--

LOCK TABLES `incident_action` WRITE;
/*!40000 ALTER TABLE `incident_action` DISABLE KEYS */;
INSERT INTO `incident_action` VALUES (1,'\nCase was declined - 2015/03/05 20:01:06',1,1),(2,'Case was taken - 2015/03/05 20:01:12\r\nblargh',1,4),(3,'Case was taken - 2015/03/10 10:37:50\r\n\r\nhello\nCase was closed - 2015/03/10 10:38:20',1,19),(4,'\nCase was declined - 2015/03/10 10:38:50',1,18),(5,'Case was taken - 2015/04/07 10:28:42\r\nghjfhskjhlkdfjghsjhkj\nCase was closed - 2015/04/07 10:29:10',1,23);
/*!40000 ALTER TABLE `incident_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incident_status`
--

DROP TABLE IF EXISTS `incident_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incident_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incident_status`
--

LOCK TABLES `incident_status` WRITE;
/*!40000 ALTER TABLE `incident_status` DISABLE KEYS */;
INSERT INTO `incident_status` VALUES (1,'new'),(2,'in progress'),(3,'reviewed'),(4,'declined'),(5,'completed');
/*!40000 ALTER TABLE `incident_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidentreports`
--

DROP TABLE IF EXISTS `incidentreports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidentreports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(45) DEFAULT NULL,
  `plateNumber` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `description` varchar(1023) DEFAULT NULL,
  `incident_status_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_incidentReports_incident_status1_idx` (`incident_status_id`),
  KEY `fk_incidentReports_location1_idx` (`location_id`),
  CONSTRAINT `fk_incidentReports_incident_status1` FOREIGN KEY (`incident_status_id`) REFERENCES `incident_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_incidentReports_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidentreports`
--

LOCK TABLES `incidentreports` WRITE;
/*!40000 ALTER TABLE `incidentreports` DISABLE KEYS */;
INSERT INTO `incidentreports` VALUES (1,'user','BBBB777','https://www.youtube.com/embed/GuHiXRgXn6I','Calgary\'s Worst Driver',4,1),(4,'Anonymous','121','1212','1212',2,4),(5,'Anonymous','1212','1212','sdsd',1,5),(6,'bobsmith@smith.com','abcd 987','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,6),(7,'','abcd 987','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,7),(8,'Anonymous','admp 077','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,8),(9,'Anonymous','BPEP 033','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,9),(10,'Anonymous','abc 123','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,10),(11,'Anonymous','abcd 987','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,11),(12,'Anonymous','zyxw 987','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,12),(13,'Anonymous','13214654','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,13),(14,'Anonymous','admp 077','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,14),(15,'Anonymous','zyxw 987','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,15),(16,'Anonymous','admp 077','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,16),(17,'Anonymous','BPEP 033','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,17),(18,'Anonymous','13214654','https://www.youtube.com/embed/3PUH-bA3IiI','blah',4,18),(19,'Anonymous','BPEP 033','https://www.youtube.com/embed/3PUH-bA3IiI','blah',5,19),(20,'Anonymous','admp 077','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,20),(21,'Anonymous','admp 077','https://www.youtube.com/embed/3PUH-bA3IiI','blah',1,21),(22,'Anonymous','123 abcd','https://www.youtube.com/embed/3PUH-bA3IiI','blargh',1,22),(23,'Anonymous','123 abcd','https://www.youtube.com/embed/3PUH-bA3IiI','blah',5,23);
/*!40000 ALTER TABLE `incidentreports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_intersection` varchar(45) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `province_id` int(11) NOT NULL,
  `citylookup_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_location_province1_idx` (`province_id`),
  KEY `fk_location_citylookup1_idx` (`citylookup_id`),
  CONSTRAINT `fk_location_citylookup1` FOREIGN KEY (`citylookup_id`) REFERENCES `citylookup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_province1` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'123 main street','1Q2W3E',1,1),(4,'122','1212',1,1),(5,'12212','dda',1,1),(6,'123 main st','123 abc',1,1),(7,'789 first st','a1b 2c3',2,3),(8,'456 milford rd','e4f 5g6',3,4),(9,'132 main st','jfdhfjlaksdflk',4,5),(10,'0 second st','123 abc',5,6),(11,'132 main st','a1b2c3',6,7),(12,'789 first st','k1p 2v1',7,8),(13,'132fakjhadlfk','a1b 2c3',8,9),(14,'456 milford rd','a1b2c3',9,10),(15,'132fakjhadlfk','123 abc',10,11),(16,'0 second st','a1b 2c3',11,12),(17,'123 main st','jfdhfjlaksdflk',12,13),(18,'132 main st','e4f 5g6',13,14),(19,'123 main st','123 abc',1,2),(20,'132 main st','123 abc',1,16),(21,'123 main st','123 abc',1,17),(22,'123 main st','111fgh',2,19),(23,'123 main st','123 abc',5,6);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(45) DEFAULT NULL,
  `twitter_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'Ontario','106470258'),(2,'Alberta','2535425082'),(3,'British Columbia','58360124'),(4,'Manitoba','1580783731'),(5,'New Brunswick','96176697'),(6,'Newfoundland and Labrador','2320904928'),(7,'Northwest Territories','481308864'),(8,'Nova Scotia','33671152'),(9,'Nunavut','55576995'),(10,'Prince Edward Island','2329278007'),(11,'Quebec','92858317'),(12,'Saskatchewan','575646270'),(13,'Yukon','78752164');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfos`
--

DROP TABLE IF EXISTS `userinfos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `budgeNumber` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `province_id` int(11) NOT NULL,
  `citylookup_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userInfos_province1_idx` (`province_id`),
  KEY `fk_userinfos_citylookup1_idx` (`citylookup_id`),
  CONSTRAINT `fk_userInfos_province1` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userinfos_citylookup1` FOREIGN KEY (`citylookup_id`) REFERENCES `citylookup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfos`
--

LOCK TABLES `userinfos` WRITE;
/*!40000 ALTER TABLE `userinfos` DISABLE KEYS */;
INSERT INTO `userinfos` VALUES (1,'123456','admin','Joe','Barber','fAO8kl0zusvNrASeAUBP3w==','police@mail.com','911',1,1),(2,'111222','bobs','bob','s','fAO8kl0zusvNrASeAUBP3w==','bobs@email.com','123-456-7890',1,1),(3,'100001','FrankSmith','Frank','Smith','fAO8kl0zusvNrASeAUBP3w==','franks@email.com','123-4567890',1,1),(4,'987654','AaronD','Aaron','Deslauriers','fAO8kl0zusvNrASeAUBP3w==','aarond@home.com','123-456-7890',1,1);
/*!40000 ALTER TABLE `userinfos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-07 10:45:54
