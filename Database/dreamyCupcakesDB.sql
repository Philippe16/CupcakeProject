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
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitems` (
  `orderitem_id` int NOT NULL AUTO_INCREMENT,
  `fk_order_id` int NOT NULL,
  `fk_cupcakeFlavor_id` int NOT NULL,
  `fk_cupcakeTopping_id` int NOT NULL,
  `amount` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`orderitem_id`),
  UNIQUE KEY `orderitem_id_UNIQUE` (`orderitem_id`),
  KEY `fk_cupcakeFlavor_id_idx` (`fk_cupcakeFlavor_id`),
  KEY `fk_cupcakeTopping_id_idx` (`fk_cupcakeTopping_id`),
  KEY `fk_order_id_idx` (`fk_order_id`),
  CONSTRAINT `fk_cupcakeFlavor_id` FOREIGN KEY (`fk_cupcakeFlavor_id`) REFERENCES `cupcakeflavors` (`cupcakeFlavor_id`),
  CONSTRAINT `fk_cupcakeTopping_id` FOREIGN KEY (`fk_cupcakeTopping_id`) REFERENCES `cupcaketoppings` (`cupcakeTopping_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
INSERT INTO `orderitems` VALUES (1,1,1,1,2,20),(2,1,1,2,4,40),(3,1,2,3,6,60);
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `fk_user_id` int NOT NULL,
  `orderDate` date NOT NULL,
  `pickupDate` date NOT NULL DEFAULT '2021-11-11',
  `fk_orderStatus_id` int DEFAULT '1',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `fk_user_id_idx` (`fk_user_id`),
  KEY `fk_orderstatus_id_idx` (`fk_orderStatus_id`),
  CONSTRAINT `fk_orderstatus_id` FOREIGN KEY (`fk_orderStatus_id`) REFERENCES `orderstatuses` (`orderStatus_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'2021-09-25','2021-11-12',1),(3,1,'2021-10-11','2021-11-11',1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstatuses`
--

DROP TABLE IF EXISTS `orderstatuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderstatuses` (
  `orderStatus_id` int NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`orderStatus_id`),
  UNIQUE KEY `orderStatus_id_UNIQUE` (`orderStatus_id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstatuses`
--

LOCK TABLES `orderstatuses` WRITE;
/*!40000 ALTER TABLE `orderstatuses` DISABLE KEYS */;
INSERT INTO `orderstatuses` VALUES (3,'cancelled'),(2,'completed'),(1,'pending');
/*!40000 ALTER TABLE `orderstatuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userroles` (
  `userRole_id` int NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`userRole_id`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (1,'admin'),(2,'customer');
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
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
  `accountBalance` double NOT NULL DEFAULT '0',
  `fk_userRole_id` int DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `customer_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_userRole_id_idx` (`fk_userRole_id`),
  CONSTRAINT `fk_userRole_id` FOREIGN KEY (`fk_userRole_id`) REFERENCES `userroles` (`userRole_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'customer1_firstName','customer1_lastName','customer1@gmail.com','123',50,2),(2,'customer2_firstName','customer2_lastName','customer2@gmail.com','123',200,2),(3,'admin1_firstName','admin1_lastName','admin1@gmail.com','123',0,1),(4,'customer3_firstName','customer3_lastName','customer3@gmail.com','123',0,2),(5,'testInsertFn','testInsertLn','testInsert@gmail.com','testInsert',20,2);
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

-- Dump completed on 2021-11-12  1:25:34
