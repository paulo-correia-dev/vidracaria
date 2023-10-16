CREATE DATABASE  IF NOT EXISTS `vidracaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vidracaria`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: vidracaria
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `peca_orcamento`
--

DROP TABLE IF EXISTS `peca_orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peca_orcamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `largura` double NOT NULL,
  `altura` double NOT NULL,
  `id_orcamento` int NOT NULL,
  `id_peca` int NOT NULL,
  `id_pelicula` int DEFAULT NULL,
  `id_vidro` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_peca_orcamento_n1` (`id_orcamento`),
  KEY `fk_peca_orcamento_n2` (`id_peca`),
  KEY `fk_peca_orcamento_n3` (`id_pelicula`),
  KEY `fk_peca_orcamento_n4` (`id_vidro`),
  CONSTRAINT `fk_peca_orcamento_n1` FOREIGN KEY (`id_orcamento`) REFERENCES `orcamento` (`id`),
  CONSTRAINT `fk_peca_orcamento_n2` FOREIGN KEY (`id_peca`) REFERENCES `peca` (`id`),
  CONSTRAINT `fk_peca_orcamento_n3` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `fk_peca_orcamento_n4` FOREIGN KEY (`id_vidro`) REFERENCES `vidro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peca_orcamento`
--

LOCK TABLES `peca_orcamento` WRITE;
/*!40000 ALTER TABLE `peca_orcamento` DISABLE KEYS */;
INSERT INTO `peca_orcamento` VALUES (4,80,210,3,4,4,4),(5,90,210,3,4,NULL,4);
/*!40000 ALTER TABLE `peca_orcamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-12 22:13:41
