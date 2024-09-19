-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: bancoforge2
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
-- Table structure for table `cena`
--

DROP TABLE IF EXISTS `cena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cena` (
  `id_cena` int(11) NOT NULL,
  `descricao_cena` varchar(1000) DEFAULT NULL,
  `id_useWith` int(11) DEFAULT NULL,
  `item_cenario` varchar(50) DEFAULT NULL,
  `nome_cena` varchar(50) DEFAULT NULL,
  `textoPositivo_cena` varchar(1000) DEFAULT NULL,
  `textoNegativo_cena` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id_cena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cena`
--

LOCK TABLES `cena` WRITE;
/*!40000 ALTER TABLE `cena` DISABLE KEYS */;
/*!40000 ALTER TABLE `cena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `id_save` int(11) NOT NULL,
  `id_cenaAtual` int(11) DEFAULT NULL,
  `id_progresso` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_save`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`)
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
  `nome_item` varchar(50) DEFAULT NULL,
  `check_item` varchar(500) DEFAULT NULL,
  `use_item` varchar(50) DEFAULT NULL,
  `get_item` tinyint(1) DEFAULT NULL,
  `id_proxCena` int(11) DEFAULT NULL,
  `id_cena` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `id_cena` (`id_cena`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`id_cena`) REFERENCES `cena` (`id_cena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'MACHADO','Um machado, uma ferramenta muito eficiente para se derrubar arvores.','MACHADO',1,2,NULL),(2,'FABRICADOR','Uma bancada usada para fabricacao de itens e ferramentas','FABRICADOR',1,3,NULL),(3,'PICARETA','Uma ferramenta usada para coletar recursos minerais como pedras.','PICARETA',1,4,NULL),(4,'CORDA ','Um item que pode usado para laçar objetos ou escalar.','CORDA',1,5,NULL),(5,'ESPADA','Uma ferramenta usada para ataque. Use isso para se defender de monstros.','ESPADA',1,6,NULL),(6,'BAU','Um elemento do cenario que pode conter tesouros ou itens importantes dentro.','BAU',1,7,NULL),(7,'CHAVE','Um item usado para destrancar portas ou cofres.','CHAVE',1,8,NULL),(8,'PORTAL','Um obelisco sombrio, antigo e uma estrutura sem muitas informacoes. Os ancaos acreditam que pode ser possivel viajar entre dimensoes.','PORTAL',1,NULL,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usewith`
--

DROP TABLE IF EXISTS `usewith`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usewith` (
  `id_useWith` int(11) NOT NULL,
  `id_cena` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_useWith`),
  KEY `id_cena` (`id_cena`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `usewith_ibfk_1` FOREIGN KEY (`id_cena`) REFERENCES `cena` (`id_cena`),
  CONSTRAINT `usewith_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usewith`
--

LOCK TABLES `usewith` WRITE;
/*!40000 ALTER TABLE `usewith` DISABLE KEYS */;
/*!40000 ALTER TABLE `usewith` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bancoforge2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-14 16:32:11
