-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.19-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for megalodondb
CREATE DATABASE IF NOT EXISTS `megalodondb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `megalodondb`;

-- Dumping structure for table megalodondb.active_game
CREATE TABLE IF NOT EXISTS `active_game` (
  `Id_users` int(11) NOT NULL,
  `Id_game` int(11) NOT NULL,
  `Status` int(11) DEFAULT NULL,
  KEY `FK_Active_game_Id_users_Users_Id_users` (`Id_users`),
  KEY `FK_Active_game_Id_game_Game_Id_game` (`Id_game`),
  CONSTRAINT `FK_Active_game_Id_game_Game_Id_game` FOREIGN KEY (`Id_game`) REFERENCES `games` (`Id_game`),
  CONSTRAINT `FK_Active_game_Id_users_Users_Id_users` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.active_game: ~0 rows (approximately)
/*!40000 ALTER TABLE `active_game` DISABLE KEYS */;
INSERT INTO `active_game` (`Id_users`, `Id_game`, `Status`) VALUES
	(24, 6, 1);
/*!40000 ALTER TABLE `active_game` ENABLE KEYS */;

-- Dumping structure for table megalodondb.bill
CREATE TABLE IF NOT EXISTS `bill` (
  `Id_bill` int(11) NOT NULL AUTO_INCREMENT,
  `Id_users` int(11) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Total_price` decimal(18,0) DEFAULT NULL,
  PRIMARY KEY (`Id_bill`),
  KEY `FK_Bill_Id_users_Users_Id_users` (`Id_users`),
  CONSTRAINT `FK_Bill_Id_users_Users_Id_users` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.bill: ~0 rows (approximately)
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` (`Id_bill`, `Id_users`, `Date`, `Total_price`) VALUES
	(1, 24, '2021-07-08 08:21:46', 0),
	(2, 20, '2021-07-08 09:32:13', 120),
	(3, 24, '2021-07-08 09:32:25', 50),
	(4, 20, '2021-07-08 09:32:37', 0),
	(5, 23, '2021-07-08 09:32:47', 100),
	(6, 24, '2021-07-08 09:54:41', 60);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;

-- Dumping structure for table megalodondb.bill_detail
CREATE TABLE IF NOT EXISTS `bill_detail` (
  `Id_bill_detail` int(11) NOT NULL AUTO_INCREMENT,
  `Id_bill` int(11) DEFAULT NULL,
  `Id_game` int(11) DEFAULT NULL,
  `Price` decimal(18,0) DEFAULT NULL,
  PRIMARY KEY (`Id_bill_detail`),
  KEY `FK_Bill_detail_Id_bill_Bill_Id_bill` (`Id_bill`),
  KEY `FK_Bill_detail_Id_game_Game_Id_game` (`Id_game`),
  CONSTRAINT `FK_Bill_detail_Id_bill_Bill_Id_bill` FOREIGN KEY (`Id_bill`) REFERENCES `bill` (`Id_bill`),
  CONSTRAINT `FK_Bill_detail_Id_game_Game_Id_game` FOREIGN KEY (`Id_game`) REFERENCES `games` (`Id_game`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.bill_detail: ~0 rows (approximately)
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
INSERT INTO `bill_detail` (`Id_bill_detail`, `Id_bill`, `Id_game`, `Price`) VALUES
	(1, 1, 6, 0);
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;

-- Dumping structure for table megalodondb.blog
CREATE TABLE IF NOT EXISTS `blog` (
  `Id_blog` int(11) NOT NULL AUTO_INCREMENT,
  `Title_blog` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Author_blog` int(11) NOT NULL,
  `Content_blog` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Date_blog` date DEFAULT NULL,
  `Image_blog` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_view_blog` int(11) NOT NULL,
  PRIMARY KEY (`Id_blog`),
  KEY `FK_Blog_Author_blog_Users_Id_users` (`Author_blog`),
  KEY `FK_Blog_Id_view_blog_View_blog_Id_view_blog` (`Id_view_blog`),
  CONSTRAINT `FK_Blog_Author_blog_Users_Id_users` FOREIGN KEY (`Author_blog`) REFERENCES `users` (`Id_users`),
  CONSTRAINT `FK_Blog_Id_view_blog_View_blog_Id_view_blog` FOREIGN KEY (`Id_view_blog`) REFERENCES `view_blog` (`Id_view_blog`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.blog: ~0 rows (approximately)
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;

-- Dumping structure for table megalodondb.category
CREATE TABLE IF NOT EXISTS `category` (
  `Id_category` int(11) NOT NULL AUTO_INCREMENT,
  `Name_category` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.category: ~18 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`Id_category`, `Name_category`) VALUES
	(1, 'Puzzle, find pairs'),
	(2, 'Racing'),
	(3, 'Sport'),
	(4, 'Countervailing'),
	(5, 'Tactic'),
	(6, 'Searching for objects'),
	(7, 'Playing cards, board games'),
	(8, 'Horror'),
	(9, 'Fashion'),
	(10, 'Role Playing - RPG'),
	(11, 'Wisdom'),
	(12, 'Simulation'),
	(13, 'Time management'),
	(14, 'Adventure'),
	(15, 'Action'),
	(16, 'Other'),
	(17, 'Free Games'),
	(18, 'Paid Games');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table megalodondb.comment_blog
CREATE TABLE IF NOT EXISTS `comment_blog` (
  `Id_commnet_blog` int(11) NOT NULL AUTO_INCREMENT,
  `Content_comment_blog` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Name_user` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_blog` int(11) NOT NULL,
  `Id_users` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_commnet_blog`),
  KEY `FK_Comment_blog_Id_blog_Blog_Id_blog` (`Id_blog`),
  KEY `FK_Comment_blog_Id_users_Users_Id_users` (`Id_users`),
  CONSTRAINT `FK_Comment_blog_Id_blog_Blog_Id_blog` FOREIGN KEY (`Id_blog`) REFERENCES `blog` (`Id_blog`),
  CONSTRAINT `FK_Comment_blog_Id_users_Users_Id_users` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.comment_blog: ~0 rows (approximately)
/*!40000 ALTER TABLE `comment_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_blog` ENABLE KEYS */;

-- Dumping structure for table megalodondb.comment_game
CREATE TABLE IF NOT EXISTS `comment_game` (
  `Id_comment_game` int(11) NOT NULL AUTO_INCREMENT,
  `Id_game` int(11) DEFAULT NULL,
  `Id_users` int(11) DEFAULT NULL,
  `Content_comment_game` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_comment_game`),
  KEY `FK_Comment_game_Id_game_Game_Id_game` (`Id_game`),
  KEY `FK_Comment_game_Id_users_Users_Id_users` (`Id_users`),
  CONSTRAINT `FK_Comment_game_Id_game_Game_Id_game` FOREIGN KEY (`Id_game`) REFERENCES `games` (`Id_game`),
  CONSTRAINT `FK_Comment_game_Id_users_Users_Id_users` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.comment_game: ~0 rows (approximately)
/*!40000 ALTER TABLE `comment_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_game` ENABLE KEYS */;

-- Dumping structure for table megalodondb.discount
CREATE TABLE IF NOT EXISTS `discount` (
  `Id_discount` int(11) NOT NULL AUTO_INCREMENT,
  `Date_start` date DEFAULT NULL,
  `Date_end` date DEFAULT NULL,
  `Value` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_discount`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.discount: ~0 rows (approximately)
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` (`Id_discount`, `Date_start`, `Date_end`, `Value`, `Status`) VALUES
	(1, '2021-07-05', '2021-07-05', 0, 1);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;

-- Dumping structure for table megalodondb.games
CREATE TABLE IF NOT EXISTS `games` (
  `Id_game` int(11) NOT NULL AUTO_INCREMENT,
  `Name_game` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Producter_game` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Publisher_game` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ReleaseYear_game` date DEFAULT NULL,
  `Description_game` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Link_video` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Price` decimal(18,0) DEFAULT NULL,
  `Price_fix` decimal(18,0) DEFAULT NULL,
  `Rate_game` float DEFAULT NULL,
  `Count_sell` int(11) DEFAULT NULL,
  `Link_game` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Id_discount` int(11) DEFAULT NULL,
  `count_rate` int(11) DEFAULT NULL,
  `Processor` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RAM` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Free_storage` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `VGA` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_game`),
  KEY `FK_Game_Id_discount_Discount_Id_discount` (`Id_discount`),
  CONSTRAINT `FK_Game_Id_discount_Discount_Id_discount` FOREIGN KEY (`Id_discount`) REFERENCES `discount` (`Id_discount`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.games: ~6 rows (approximately)
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` (`Id_game`, `Name_game`, `Producter_game`, `Publisher_game`, `ReleaseYear_game`, `Description_game`, `Link_video`, `Price`, `Price_fix`, `Rate_game`, `Count_sell`, `Link_game`, `Id_discount`, `count_rate`, `Processor`, `RAM`, `Free_storage`, `VGA`) VALUES
	(3, '123', '123', '123', '1231-07-05', '123', 'linkneverdie', 70, 50, 4.8, 18, 'linkneverdie.com', 1, 17, 'Intel i5', '4GB', '20GB', 'Nvidia 1080Ti Super'),
	(4, 'Pubg', 'krypton', 'unknow', '2021-07-14', '<h1 style="color: #ff0000; text-align: left;"><img src="../plugins/tinymce/plugins/emoticons/img/smiley-cry.gif" alt="cry" />&nbsp;<img src="../plugins/tinymce/plugins/emoticons/img/smiley-cool.gif" alt="cool" /><img src="../plugins/tinymce/plugins/emoticons/img/smiley-cool.gif" alt="cool" /><img src="../plugins/tinymce/plugins/emoticons/img/smiley-cool.gif" alt="cool" />&nbsp; PUBG&nbsp;<img src="../plugins/tinymce/plugins/emoticons/img/smiley-innocent.gif" alt="innocent" /><img src="../plugins/tinymce/plugins/emoticons/img/smiley-kiss.gif" alt="kiss" /><img src="../plugins/tinymce/plugins/emoticons/img/smiley-kiss.gif" alt="kiss" />&nbsp;</h1>', 'youtube.com', 120, 0, 0, 6, 'google.com', NULL, 0, 'Intel i7', '8Gb', '40Gb', 'NVIDIA 1080'),
	(5, 'League Of Legends', 'Riot', 'Garena', '2021-07-06', '', 'youtube.com', 0, 0, 0, 5, 'google.com', NULL, 0, 'i5', '4Gb', '20Gb', 'No'),
	(6, 'CrossFire', 'Unknow', 'Unknow', '2021-07-12', '<p>asdgyaugfV e</p>', 'youtube.com', 0, 0, 0, 8, 'google.com', NULL, 0, 'i3', '4Gb', '20Gb', 'No'),
	(7, 'League Of Legends', 'krypton', 'unknow', '2021-07-09', '', 'youtube.com', 0, 0, 0, 12, 'google.com', NULL, 0, 'i5', '4Gb', '20Gb', 'No'),
	(8, 'Pubg', 'krypton', 'Unknow', '2021-07-31', '<p>wefqGEW</p>', 'youtube.com', 120, 0, 0, 1, 'google.com', NULL, 0, 'i5', '8Gb', '40Gb', 'NVIDIA 1080');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;

-- Dumping structure for table megalodondb.game_category
CREATE TABLE IF NOT EXISTS `game_category` (
  `Id_game` int(11) NOT NULL,
  `Id_category` int(11) NOT NULL,
  KEY `FK_Game_Category_Id_game_Game_Id_game` (`Id_game`),
  KEY `FK_Game_Category_Id_category_Category_Id_category` (`Id_category`),
  CONSTRAINT `FK_Game_Category_Id_category_Category_Id_category` FOREIGN KEY (`Id_category`) REFERENCES `category` (`Id_category`),
  CONSTRAINT `FK_Game_Category_Id_game_Game_Id_game` FOREIGN KEY (`Id_game`) REFERENCES `games` (`Id_game`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.game_category: ~18 rows (approximately)
/*!40000 ALTER TABLE `game_category` DISABLE KEYS */;
INSERT INTO `game_category` (`Id_game`, `Id_category`) VALUES
	(3, 1),
	(3, 4),
	(3, 2),
	(4, 2),
	(4, 3),
	(4, 15),
	(4, 18),
	(5, 15),
	(5, 16),
	(5, 17),
	(6, 15),
	(6, 17),
	(7, 3),
	(7, 15),
	(7, 16),
	(7, 17),
	(8, 2),
	(8, 3),
	(8, 15),
	(8, 16),
	(8, 18);
/*!40000 ALTER TABLE `game_category` ENABLE KEYS */;

-- Dumping structure for table megalodondb.image_data
CREATE TABLE IF NOT EXISTS `image_data` (
  `Id_image` int(11) NOT NULL AUTO_INCREMENT,
  `Name_image` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Id_game` int(11) NOT NULL,
  PRIMARY KEY (`Id_image`),
  KEY `FK_Image_data_Id_game_Game_Id_game` (`Id_game`),
  CONSTRAINT `FK_Image_data_Id_game_Game_Id_game` FOREIGN KEY (`Id_game`) REFERENCES `games` (`Id_game`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.image_data: ~0 rows (approximately)
/*!40000 ALTER TABLE `image_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_data` ENABLE KEYS */;

-- Dumping structure for table megalodondb.reply_comment_blog
CREATE TABLE IF NOT EXISTS `reply_comment_blog` (
  `Id_reply_comment_blog` int(11) NOT NULL AUTO_INCREMENT,
  `Id_commnet_blog` int(11) NOT NULL,
  `Id_users` int(11) NOT NULL,
  `Content_comment` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_reply_comment_blog`),
  KEY `FK_Reply_comment_blog_Id_commnet_blog` (`Id_commnet_blog`),
  CONSTRAINT `FK_Reply_comment_blog_Id_commnet_blog` FOREIGN KEY (`Id_commnet_blog`) REFERENCES `comment_blog` (`Id_commnet_blog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.reply_comment_blog: ~0 rows (approximately)
/*!40000 ALTER TABLE `reply_comment_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply_comment_blog` ENABLE KEYS */;

-- Dumping structure for table megalodondb.reply_comment_game
CREATE TABLE IF NOT EXISTS `reply_comment_game` (
  `Id_reply_comment_game` int(11) NOT NULL AUTO_INCREMENT,
  `Id_comment_game` int(11) DEFAULT NULL,
  `Id_users` int(11) DEFAULT NULL,
  `Content_comment` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_reply_comment_game`),
  KEY `FK_Reply_comment_game_Idpppp` (`Id_comment_game`),
  CONSTRAINT `FK_Reply_comment_game_Idpppp` FOREIGN KEY (`Id_comment_game`) REFERENCES `comment_game` (`Id_comment_game`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.reply_comment_game: ~0 rows (approximately)
/*!40000 ALTER TABLE `reply_comment_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply_comment_game` ENABLE KEYS */;

-- Dumping structure for table megalodondb.role
CREATE TABLE IF NOT EXISTS `role` (
  `Id_role` int(11) NOT NULL AUTO_INCREMENT,
  `Name_role` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.role: ~3 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`Id_role`, `Name_role`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_EMPLOYEE'),
	(3, 'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table megalodondb.slide_show
CREATE TABLE IF NOT EXISTS `slide_show` (
  `Id_slide_show` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Id_game` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_slide_show`),
  KEY `FK_Slide_show_Id_game_Game_Id_game` (`Id_game`),
  CONSTRAINT `FK_Slide_show_Id_game_Game_Id_game` FOREIGN KEY (`Id_game`) REFERENCES `games` (`Id_game`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.slide_show: ~2 rows (approximately)
/*!40000 ALTER TABLE `slide_show` DISABLE KEYS */;
/*!40000 ALTER TABLE `slide_show` ENABLE KEYS */;

-- Dumping structure for table megalodondb.system
CREATE TABLE IF NOT EXISTS `system` (
  `Dowload_system` int(11) NOT NULL,
  `views_system` int(11) NOT NULL,
  `Date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.system: ~0 rows (approximately)
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
/*!40000 ALTER TABLE `system` ENABLE KEYS */;

-- Dumping structure for table megalodondb.system_requirements
CREATE TABLE IF NOT EXISTS `system_requirements` (
  `Id_system_rerequirements` int(11) NOT NULL AUTO_INCREMENT,
  `Processor` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RAM` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `VGA` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Storage` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id_system_rerequirements`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.system_requirements: ~0 rows (approximately)
/*!40000 ALTER TABLE `system_requirements` DISABLE KEYS */;
INSERT INTO `system_requirements` (`Id_system_rerequirements`, `Processor`, `RAM`, `VGA`, `Storage`) VALUES
	(1, 'Intel I5', '4GB', 'Nvidia 1050', '40GB');
/*!40000 ALTER TABLE `system_requirements` ENABLE KEYS */;

-- Dumping structure for table megalodondb.token_user
CREATE TABLE IF NOT EXISTS `token_user` (
  `Id_token_users` int(11) NOT NULL AUTO_INCREMENT,
  `value_token_users` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Id_users` int(11) NOT NULL,
  PRIMARY KEY (`Id_token_users`),
  KEY `FK_Token_user_Id_users_Users_Id_users` (`Id_users`),
  CONSTRAINT `FK_Token_user_Id_users_Users_Id_users` FOREIGN KEY (`Id_users`) REFERENCES `users` (`Id_users`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.token_user: ~6 rows (approximately)
/*!40000 ALTER TABLE `token_user` DISABLE KEYS */;
INSERT INTO `token_user` (`Id_token_users`, `value_token_users`, `Date`, `Id_users`) VALUES
	(1, 'e52617d1-2cf5-4cd1-aa36-881d386d7f2d', '2021-07-03 16:47:25', 15),
	(2, '6bda439a-6ffb-473f-b754-22069a46a568', '2021-07-03 19:56:04', 20),
	(3, '6b62d251-b25b-4b9d-b7be-2b33b7b61e89', '2021-07-03 22:56:29', 21),
	(4, 'e59ab3e4-b716-41b9-85e9-f5f72fb6166e', '2021-07-05 08:31:12', 22),
	(5, 'd07fd65b-edd6-421b-8a4a-27971c65dad6', '2021-07-08 10:19:55', 23),
	(9, 'e364d9a5-1a60-4e1a-a73d-9f9e57cf4a56', '2021-07-08 10:28:12', 26),
	(10, '16dde2ec-47fa-4e49-a42a-0d56004fd327', '2021-07-08 10:28:46', 27),
	(11, '178f82a0-db97-450a-9e60-9204634788b7', '2021-07-08 10:29:34', 28);
/*!40000 ALTER TABLE `token_user` ENABLE KEYS */;

-- Dumping structure for table megalodondb.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id_users` int(11) NOT NULL AUTO_INCREMENT,
  `Name_users` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Username_users` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password_users` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email_users` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Phone_users` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Image_users` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address_users` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Date_of_birthday` date DEFAULT NULL,
  `Gender` int(11) DEFAULT NULL,
  `Id_role` int(11) NOT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_users`),
  KEY `FK_Users_Id_role_Role_Id_role` (`Id_role`),
  CONSTRAINT `FK_Users_Id_role_Role_Id_role` FOREIGN KEY (`Id_role`) REFERENCES `role` (`Id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.users: ~6 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id_users`, `Name_users`, `Username_users`, `Password_users`, `Email_users`, `Phone_users`, `Image_users`, `Address_users`, `Date_of_birthday`, `Gender`, `Id_role`, `Status`) VALUES
	(15, 'de', 'c', '$2a$10$xUU2AxdARPruGSqBnppdjuRGTeDVfCNe8eqNwuF/0Q74p6s1RInm.', 'shivalcrow.nq@gmail.com', '123', 'image.png', '123abc', '2021-07-05', 1, 1, 0),
	(20, 'de', 'lm', '$2a$10$iJmeqrp.gkeQYZrB.7g0ceMOL2z1s0o719bzT4DubsmTwF6yZHOYK', 'aqqq11@gmail.com', '123', 'image.png', '123abc', '2021-07-05', 1, 3, 0),
	(21, 'qqqq', '1234', '$2a$10$qxY0sMHcxNJmLGD43JOE.uQtSAXTwJ8LFlQt1Mhqj3Zj6AMocQhGW', 'shivascrow.nq@gmail.com', '123', 'image.png', '123abc', '2021-07-05', 1, 3, 0),
	(22, '159', 'poik', '$2a$10$jXLQhTLjon4FPqeRXiLh3eAEffbud4mEEeS1zdWqe/ayLEdFJogPC', 'mjp@gmail.com', '123', 'image.png', '123abc', '2021-07-05', 1, 3, 0),
	(23, 'Nguyen Van An', 'a', '$2a$10$I/XXDmSboPd3hbGkpRB3wOfDNnEXxuJyYWtDrGlTVS2MMpI9Psuo6', 'conandold@gmail.com', '2312321321', 'noavatar.png', 'Binh Chanh', '2021-07-05', 1, 2, 1),
	(24, 'Ha Vu Dat', 'conandoldsdfdf', '$2a$10$rE9wl46.ZOipGzSy2n6n0eNmBaDR7ZQrxLJp8Nw2Ha3DoxV01C9re', 'conandld@gmail.com', '244343', 'noavatar.png', 'asdaw', '2021-07-21', 1, 2, 1),
	(25, 'Son', 'Son123', '$2a$10$nG5sAPGVrUQ1FSKWhKdAjeleI6pPCpIM62seUcvN.2h.f/E3H78PO', 'son123@gmail.com', NULL, NULL, NULL, NULL, NULL, 3, NULL),
	(26, 'Admin ', 'admin', '$2a$10$7eQuzE80yD.1JB7/Ap6Ls.TdqmuGG/.NaOPJdpuL/IAFWGHxXjAwy', 'admin@mail.com', '123456', 'noavatar.png', 'admin page', '2021-07-08', 1, 1, 1),
	(27, 'Employee', 'employee', '$2a$10$gtkuOC7u9EqeVZk0TenM3umWYxrnjwH/dWHLMGbpG9QrjJA1js6rC', 'employee@mail.com', '123456', 'noavatar.png', 'admin page', '2021-07-08', 1, 2, 1),
	(28, 'Customer', 'customer', '$2a$10$oxkN5IITXDYjjq7.kP3bFO7m47Pan9lLCPydaLoZC3Uqz9QvTp8GK', 'customer@mail.com', NULL, NULL, NULL, NULL, NULL, 3, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table megalodondb.view_blog
CREATE TABLE IF NOT EXISTS `view_blog` (
  `Id_view_blog` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `count_view` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_view_blog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table megalodondb.view_blog: ~0 rows (approximately)
/*!40000 ALTER TABLE `view_blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `view_blog` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
megalodondb