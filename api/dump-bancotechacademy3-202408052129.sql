-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bancotechacademy3
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
-- Table structure for table `itens`
--

DROP TABLE IF EXISTS `itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens` (
  `ID_ITEM` int(11) NOT NULL,
  `NOME_ITEM` varchar(50) NOT NULL,
  `DESCRICAO_ITEM` varchar(255) DEFAULT NULL,
  `CRIACAO_ITEM` char(1) NOT NULL,
  `MATERIAL1_ITEM` varchar(20) DEFAULT NULL,
  `MATERIAL2_ITEM` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ITEM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens`
--

LOCK TABLES `itens` WRITE;
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` VALUES (1,'MADEIRA','Item coletável que pode ser extraído de árvores, usando SOCO ou um MACHADO. Usado para FABRICAR uma série de itens, sendo a base para quase tudo.','N',NULL,NULL),(2,'SOCO','Comandos primitivos do jogador para coletar itens básicos antes de conseguir as ferramentas necessárias.','N',NULL,NULL),(3,'PEDRA','Item coletável que é extraído de rochas em cavernas ou camadas mais baixas do solo.\r\n','N',NULL,NULL),(4,'FABRICADOR','Uma bancada usada para a fabricação de todos os itens do jogo, do mais básico até ITEM mais complexos. Utiliza-se o comando FABRICAR para se utilizar. Usa-se 4 MADEIRA para sua fabricação.','S','4 MADEIRA',NULL),(5,'MACHADO','Item fabricável utilizado para coleta de madeira. Pode ser usado como arma de combate. Usa-se 3 PEDRA e 2 MADEIRA para sua fabricação.','S','3 PEDRA','2 MADEIRA'),(6,'PICARETA','Item fabricável utilizado para coleta de PEDRA. Usa-se 5 MADEIRA para sua fabricação.','S','5 MADEIRA',NULL),(7,'PICARETA MELHORADA','Item fabricável usado para coleta de DIAMANTE em cavernas. Usa-se 3 FERRO e 2 MADEIRA para sua fabricação','S','3 FERRO','2 MADEIRA'),(8,'PICARETA AVANÇADA','Item fabricável usado para coleta de OBSIDIANA. Usa-se 3 DIAMANTE e 2 MADEIRA para sua fabricação.','S','3 DIAMANTES','2 MADEIRA'),(9,'FERRO','Item coletável em paredes de vales ou pequenas cavernas. Este item possibilita a criação de ARMADURA e ferramentas.','N',NULL,NULL),(10,'ESPADA','Item fabricável usado para combates intensos. Usa-se 3 DIAMANTE e 2 MADEIRA para sua fabricação.','S','2 DIAMANTES','1 MADEIRA');
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;
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

-- Dump completed on 2024-08-05 21:29:35
