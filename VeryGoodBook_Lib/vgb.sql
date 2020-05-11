/*DROP DATABASE IF EXISTS vgb;*/

CREATE DATABASE vgb DEFAULT CHARACTER SET utf8mb4;
/*40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */
/*80016 DEFAULT ENCRYPTION='N' */

USE vgb;

CREATE TABLE `customers` (
  `id` char(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` char(1) NOT NULL,
  `email` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `phone` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `married` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int NOT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `description` varchar(300) NOT NULL DEFAULT '',
  `discount` int NOT NULL DEFAULT '0',
  `class_name` varchar(25) NOT NULL DEFAULT 'Product',
  `category` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
