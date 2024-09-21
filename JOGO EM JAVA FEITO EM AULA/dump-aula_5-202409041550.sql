-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: aula_5
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `cenas`
--

DROP TABLE IF EXISTS `cenas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cenas` (
  `id_cena` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cena`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cenas`
--

LOCK TABLES `cenas` WRITE;
/*!40000 ALTER TABLE `cenas` DISABLE KEYS */;
INSERT INTO `cenas` VALUES (1,'João paulo se matriculou no curso de tads, em seu quarto tinha NOTEBOOK, CADERNO e um PLAYSTATION. Ajude joão a ir para sua primeira aula'),(2,'João paulo chegou feliz na aula com seu notebook.'),(3,'Nova cena que foi inserida pelo java brabíssimo'),(4,'Nova cena que foi inserida pelo java brabíssimo'),(5,'Nova cena que foi inserida pelo java brabíssimo'),(6,'Nova cena que foi inserida pelo java brabíssimo'),(7,'Nova cena que foi inserida pelo java brabíssimo'),(8,'Nova cena que foi inserida pelo java brabíssimo');
/*!40000 ALTER TABLE `cenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens`
--

DROP TABLE IF EXISTS `itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `descricao_positiva` varchar(255) DEFAULT NULL,
  `descricao_negativa` varchar(255) DEFAULT NULL,
  `comando_correto` varchar(255) DEFAULT NULL,
  `id_cena_atual` int(11) DEFAULT NULL,
  `id_cena_destino` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `id_cena_atual` (`id_cena_atual`),
  CONSTRAINT `itens_ibfk_1` FOREIGN KEY (`id_cena_atual`) REFERENCES `cenas` (`id_cena`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens`
--

LOCK TABLES `itens` WRITE;
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` VALUES (1,'NOTEBOOK','Notebook parece ótimo, vamos levá-lo','Olha, parece promissor, que tal tentar outro comando?','USE NOTEBOOK',1,2),(2,'CADERNO','','Que gracinha, caderno é muito bom, mas a galera de tecnologia quase não usa caderno','USE NOTEBOOK',1,NULL),(3,'PLAYSTATION','','Tem certeza que é para a faculdade que você está indo?','USE NOTEBOOK',1,NULL);
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saves`
--

DROP TABLE IF EXISTS `saves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saves` (
  `id_save` int(11) NOT NULL AUTO_INCREMENT,
  `id_cena_atual` int(11) NOT NULL,
  PRIMARY KEY (`id_save`),
  KEY `id_cena_atual` (`id_cena_atual`),
  CONSTRAINT `saves_ibfk_1` FOREIGN KEY (`id_cena_atual`) REFERENCES `cenas` (`id_cena`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saves`
--

LOCK TABLES `saves` WRITE;
/*!40000 ALTER TABLE `saves` DISABLE KEYS */;
INSERT INTO `saves` VALUES (1,1),(2,1),(3,1),(4,1),(5,1);
/*!40000 ALTER TABLE `saves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'aula_5'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-04 15:50:00
