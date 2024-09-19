-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: bancotechacademy3
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `cenas`
--

DROP TABLE IF EXISTS `cenas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cenas` (
  `id_cena` int(11) NOT NULL,
  `nome_cena` varchar(50) NOT NULL,
  `descricao_cena` varchar(500) DEFAULT NULL,
  `descricao_positiva` varchar(1000) DEFAULT NULL,
  `descricao_negativa` varchar(1000) DEFAULT NULL,
  `itensCena_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cena`),
  KEY `itensCena_id` (`itensCena_id`),
  CONSTRAINT `cenas_ibfk_1` FOREIGN KEY (`itensCena_id`) REFERENCES `itenscena` (`id_itensCenas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cenas`
--

LOCK TABLES `cenas` WRITE;
/*!40000 ALTER TABLE `cenas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `id_inventario` int(11) NOT NULL,
  `usuarioSave_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_inventario`),
  KEY `usuarioSave_id` (`usuarioSave_id`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`usuarioSave_id`) REFERENCES `usuario_save` (`id_save`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id_item` int(11) NOT NULL,
  `nome_item` varchar(50) NOT NULL,
  `comando_use` varchar(50) NOT NULL,
  `inventario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `inventario_id` (`inventario_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`inventario_id`) REFERENCES `inventario` (`id_inventario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'MACHADO','MACHADO',NULL),(2,'CORDA','CORDA',NULL),(3,'PAPEL','PAPEL',NULL),(4,'FABRICAR PICARETA','FABRICAR PICARETA',NULL),(5,'LAPIS','LAPIS',NULL),(6,'PICARETA','PICARETA',NULL),(7,'PEDRA','PEDRA',NULL),(8,'TERRA','TERRA',NULL),(9,'POLVORA','POLVORA',NULL),(10,'FERRO','FERRO',NULL),(11,'EXPLORAR','EXPLORAR',NULL),(12,'BAUS','BAUS',NULL),(13,'ESPADA','ESPADA',NULL),(14,'ENIGMAS ','ENIGMAS ',NULL),(15,'CHAVE','CHAVE',NULL),(16,'PORTAL','PORTAL',NULL),(17,'POLVORA  ','POLVORA ',NULL),(18,'FERRO','FERRO',NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itenscena`
--

DROP TABLE IF EXISTS `itenscena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itenscena` (
  `id_itensCenas` int(11) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `cena_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_itensCenas`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `itenscena_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itenscena`
--

LOCK TABLES `itenscena` WRITE;
/*!40000 ALTER TABLE `itenscena` DISABLE KEYS */;
/*!40000 ALTER TABLE `itenscena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_save`
--

DROP TABLE IF EXISTS `usuario_save`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_save` (
  `id_save` int(11) NOT NULL,
  `nome_save` varchar(50) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_save`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `usuario_save_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_save`
--

LOCK TABLES `usuario_save` WRITE;
/*!40000 ALTER TABLE `usuario_save` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_save` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bancotechacademy3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-02 20:30:37
