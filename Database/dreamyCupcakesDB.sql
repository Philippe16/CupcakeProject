-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dreamycupcakesdb
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `cupcakeflavors`
--

DROP TABLE IF EXISTS `cupcakeflavors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupcakeflavors` (
  `cupcakeFlavor_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`cupcakeFlavor_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupcakeflavors`
--

LOCK TABLES `cupcakeflavors` WRITE;
/*!40000 ALTER TABLE `cupcakeflavors` DISABLE KEYS */;
INSERT INTO `cupcakeflavors` VALUES (1,'Chocolate',5),(2,'Vanilla',5),(3,'Nutmeg',5),(4,'Pistacio',6),(5,'Almond',7);
/*!40000 ALTER TABLE `cupcakeflavors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupcaketoppings`
--

DROP TABLE IF EXISTS `cupcaketoppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupcaketoppings` (
  `cupcakeTopping_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`cupcakeTopping_id`),
  UNIQUE KEY `cupcakeTopping_id_UNIQUE` (`cupcakeTopping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupcaketoppings`
--

LOCK TABLES `cupcaketoppings` WRITE;
/*!40000 ALTER TABLE `cupcaketoppings` DISABLE KEYS */;
INSERT INTO `cupcaketoppings` VALUES (1,'Chocolate',5),(2,'Blueberry',5),(3,'Raspberry',5),(4,'Crispy',6),(5,'Strawberry',6),(6,'Rum/Raisin',7),(7,'Orange',8),(8,'Lemon',8),(9,'Blue cheese',9);
/*!40000 ALTER TABLE `cupcaketoppings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderedcupcakes`
--

DROP TABLE IF EXISTS `orderedcupcakes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderedcupcakes` (
  `orderedCupcake_id` int NOT NULL AUTO_INCREMENT,
  `fk_order_id` int NOT NULL,
  `fk_cupcakeFlavor_id` int NOT NULL,
  `fk_cupcakeTopping_id` int NOT NULL,
  `amount` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`orderedCupcake_id`),
  UNIQUE KEY `orderedCupcake_id_UNIQUE` (`orderedCupcake_id`),
  KEY `fk_order_id_idx` (`fk_order_id`),
  KEY `fk_cupcakeFlavor_id_idx` (`fk_cupcakeFlavor_id`),
  KEY `fk_cupcakeTopping_id_idx` (`fk_cupcakeTopping_id`),
  CONSTRAINT `fk_cupcakeFlavor_id` FOREIGN KEY (`fk_cupcakeFlavor_id`) REFERENCES `cupcakeflavors` (`cupcakeFlavor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_cupcakeTopping_id` FOREIGN KEY (`fk_cupcakeTopping_id`) REFERENCES `cupcaketoppings` (`cupcakeTopping_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_id` FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderedcupcakes`
--

LOCK TABLES `orderedcupcakes` WRITE;
/*!40000 ALTER TABLE `orderedcupcakes` DISABLE KEYS */;
INSERT INTO `orderedcupcakes` VALUES (12,1,1,1,2,20),(13,1,1,3,6,60),(14,2,2,1,2,20),(15,3,3,4,12,132),(16,3,3,2,2,20),(17,4,4,5,6,72),(18,4,1,5,6,66),(19,4,4,2,4,44),(20,5,3,1,2,20),(21,6,2,3,4,10),(22,6,5,4,2,13);
/*!40000 ALTER TABLE `orderedcupcakes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `fk_customer_id` int NOT NULL,
  `status` varchar(10) NOT NULL,
  `orderDate` date NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `fk_customer_id_idx` (`fk_customer_id`),
  CONSTRAINT `fk_customer_id` FOREIGN KEY (`fk_customer_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'completed','2021-09-25'),(2,1,'pending','2021-11-10'),(3,2,'completed','2021-11-05'),(4,2,'cancelled','2021-10-11'),(5,2,'completed','2021-09-25'),(6,1,'completed','2021-06-16');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `accountBalance` double DEFAULT '0',
  `role` varchar(10) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'customer1_firstName','customer1_lastName','customer1@gmail.com','123',100,'customer'),(2,'customer2_firstName','customer2_lastName','customer2@gmail.com','123',200,'customer'),(3,'admin1_firstName','admin1_lastName','admin1@gmail.com','123',0,'admin'),(4,'customer3_firstName','customer3_lastName','customer3@gmail.com','123',0,'customer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-11 11:55:51
