-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: planet
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto` (
  `id` int NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `registro_id` int NOT NULL,
  `data` datetime(6) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj4w7fwjgpyg916p3wv0wa1wt0` (`registro_id`),
  KEY `FKa0f65cn3ajv3ihjtc3pgt652s` (`usuario_id`),
  CONSTRAINT `FKa0f65cn3ajv3ihjtc3pgt652s` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKj4w7fwjgpyg916p3wv0wa1wt0` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (92,'Parachoque Frontal','aaaaaaa',91,'2022-04-13 15:55:37.751000','',1),(93,'Parachoque Traseiro','aaaaaaa',91,'2022-04-13 15:56:08.627000','',1),(94,'Lanterna Traseira Esquerda','aaaaaaa',91,'2022-04-13 15:56:12.970000','',1),(95,'Farol Esquerdo','aaaaaaa',91,'2022-04-13 15:56:16.425000','',1),(96,'Lanterna Traseira Direita','aaaaaaa',91,'2022-04-13 15:56:20.273000','',1),(97,'Farol Direito','aaaaaaa',91,'2022-04-13 15:56:25.343000','',1),(98,'Vidro Traseiro','aaaaaaa',91,'2022-04-13 15:56:31.717000','',1),(99,'Parabrisa','aaaaaaa',91,'2022-04-13 15:56:35.724000','',1),(100,'Retrovisor Direito','aaaaaaa',91,'2022-04-13 15:56:38.857000','',1),(101,'Retrovisor Esquerdo','aaaaaaa',91,'2022-04-13 15:56:46.207000','',1),(102,'Porta-Malas','aaaaaaa',91,'2022-04-13 15:56:42.811000','',1),(103,'Capô','aaaaaaa',91,'2022-04-13 15:56:51.137000','',1),(104,'Teto','aaaaaaa',91,'2022-04-13 15:56:54.542000','',1),(105,'Roda Dianteira Esquerda','aaaaaaa',91,'2022-04-13 15:56:57.767000','',1),(106,'Roda Dianteira Direita','aaaaaaa',91,'2022-04-13 15:57:01.038000','',1),(107,'Roda Traseira Esquerda','aaaaaaa',91,'2022-04-13 15:57:04.177000','',1),(108,'Roda Traseira Direita','aaaaaaa',91,'2022-04-13 15:57:07.428000','',1),(109,'Porta Motorista','aaaaaaa',91,'2022-04-13 15:57:11.379000','',1),(110,'Porta Carona','aaaaaaa',91,'2022-04-13 15:57:18.301000','',1),(111,'Vidro Dianteiro Direito','bbbbbbbbb',91,'2022-04-13 15:57:47.143000','',1),(112,'Vidro Dianteiro Esquerdo','aaaaaaa',91,'2022-04-13 15:57:21.797000','',1),(113,'Vidro Traseiro Direito','aaaaaaa',91,'2022-04-13 15:57:24.769000','',1),(114,'Vidro Traseiro Esquerdo','aaaaaaa',91,'2022-04-13 15:57:28.879000','',1),(116,'asdas','asdasd',91,'2022-04-13 15:59:32.139000','asdad',1),(118,'Parachoque Frontal','blablalbal',117,'2022-04-13 16:23:09.703000','',84);
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 17:51:26
