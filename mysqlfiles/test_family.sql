-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `family_id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `power` int(10) NOT NULL DEFAULT '0',
  `universe_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `universe_id` (`universe_id`),
  CONSTRAINT `family_ibfk_1` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_2` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_3` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_4` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_5` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_6` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_7` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`),
  CONSTRAINT `family_ibfk_8` FOREIGN KEY (`universe_id`) REFERENCES `universe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES (1,'1','family1',21,1),(2,'1','family1',21,2),(3,'1','family1',21,3),(4,'2','family2',11,1),(5,'4','family4',11,3),(6,'5','family5',5,1),(7,'5','family5',0,2);
/*!40000 ALTER TABLE `family` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-27 11:10:27
