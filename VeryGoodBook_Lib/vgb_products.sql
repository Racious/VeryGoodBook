-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: vgb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int NOT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `description` varchar(200) NOT NULL DEFAULT '',
  `discount` int NOT NULL DEFAULT '0',
  `class_name` varchar(25) NOT NULL DEFAULT 'Product',
  `category` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'從零開始！Java 程式設計入門',580,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/079/54/0010795433.jpg&v=5b642ecb&w=348&h=348','Java 是目前業界使用最廣泛的程式語言，學習 Java 可說是投資報酬率最高的選擇！作者任教程式設計 30 年，深知學習程式設計的困境，\r 	本書不會像坊間程式語言學習書籍一樣，花費大量的篇幅在瑣碎的語法細節，而是介紹關鍵必要的語法，透過大量的範例演練、實作練習，\r讓初學者從零開始製作繪圖程式、經典電腦遊戲…等範例程式，快速窺見程式設計的奧秘與精髓！',21,'Outlet','書籍'),(2,'深入淺出 Java 程式設計 第二版',880,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/031/18/0010311883.jpg&v=4ece1fe7&w=348&h=348','Head First Java 是個完整的物件導向（object-oriented，OO）程式設計與 Java 的學習指引。此書是根據學習理論所設計的、 讓你可以從學習程式語言的基本開始一直到包括執行緒、網路、與分散式程式等項目。最重要的，你會學會如何像個物件導向開發 者一般的思考。',21,'Outlet','書籍'),(3,'最新 Java 程式設計(第六版)',680,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/082/48/0010824846_bc_01.jpg&v=4ece1fe7&w=348&h=348','本書從第一版規劃寫作至今已 15 個年頭，期間配合 Java 版本的演進歷經多次改版，每次改版都匯集了眾多讀者、教師的意見，適當增加了新的題材與語法，同時也因應不同世代的需求，刪除過時的內容，務求讓書中內容更簡明易懂、更符合初學者的需求。',21,'Outlet','書籍'),(4,'Java SE8 OCAJP專業認證指南',620,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/082/40/0010824023_bc_01.jpg&v=4ece1fe7&w=348&h=348','Java技術自1995年誕生迄今已廣泛應用。近年來雖然新興不少程式語言，依據www.tiobe.com的統計資料，Java自2016年起穩居全球熱門排行第一，熟悉Java技術的人才需求居高不下，也讓Java證照炙手可熱。',25,'Outlet','書籍'),(5,'掌握Java SE11程式設計',690,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/082/94/0010829401_bc_01.jpg&v=4ece1fe7&w=348&h=348','自從Oracle接手Java的發展之後，Java開始了天翻地覆的變化，加入了許多新功能，\r這些新功能都是為了跟上最新流行的程式語言與新型態的發布、維護架構。其中最重要的就是SE8的Lambda運算式與SE9的模組（module）。',34,'Outlet','書籍'),(6,'Java SE 12基礎必修課(適用Java 12~10，涵蓋OCJP與MTA Java國際認證)',540,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/083/56/0010835659.jpg&v=5d89f03f&w=348&h=348','※專家與教師共同執筆\r由OCJP（原SCJP）與MTA Java認證講師、科技大學教授程式設計教師共同編著，針對初學者學習程式設計所編寫的入門教材。',21,'Outlet','書籍'),(7,'圖說演算法：使用Java',490,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/084/55/0010845577_bc_01.jpg&v=5d89f03f&w=348&h=348','運算思維是用來培養系統化邏輯概念的基礎，進而學習在面對問題時能有系統的分析與拆解的能力。對於第一次接觸運算思維與演算法的初學者來說，大量的演算邏輯文字說明，常會造成學習障礙與挫折感。為了避免教學及閱讀上的不順暢，書中的演算法不以虛擬碼來說明。',25,'Outlet','書籍'),(8,'Java SE 9 技術手冊',650,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/077/37/0010773787.jpg&v=5a3101af&w=348&h=348','提供Java 9新功能快速索引，深入探討Java模組平臺系統，JDK基礎與IDE操作交相對照，提供Lab實作檔案。',21,'Outlet','書籍'),(9,'全民學程式設計：從插畫學 Java',399,10,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/079/30/0010793049_bc_01.jpg&v=5a3101af&w=348&h=348','Java 至今仍是擁有廣大使用者的第一線程式語言。從用戶端、伺服器環境開始，直到近年來Android 應用程式的開發，Java 都被廣泛地運用。\rJava 最大的特色就是「物件導向」，這是一種將程式功能群組化，並且藉由這些群組的搭配來建構出程式。',21,'Outlet','書籍'),(10,'Java RWD Web企業網站開發指南｜使用Spring MVC與Bootstrap',680,10,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/082/92/0010829294.jpg&v=5d35903a&w=348&h=348','行動應用的潮流裡，隨著前端技術的成熟，響應式網頁設計(RWD)為企業提供比APP更快速、更具成本競爭力的解決方案，是不可忽視的趨勢。\r作者結合實務開發與課堂教學經驗，由淺入深地介紹掌握這波趨勢必要知能。',21,'Outlet','書籍');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-11 20:12:59
