/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.17-log : Database - study
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`study` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `study`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `dynasty` varchar(10) DEFAULT NULL COMMENT '朝代',
  `introduction` blob COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='作者表';

/*Data for the table `author` */

insert  into `author`(`id`,`name`,`dynasty`,`introduction`) values (1,'佚名',NULL,NULL),(3,'李白','唐',NULL),(4,'杜甫','唐',NULL),(5,'李商隐','唐',NULL),(6,'李贺','唐',NULL),(7,'柳宗元','唐',NULL),(8,'刘禹锡','唐',NULL),(10,'纳兰性德','清','饮水词'),(11,'苏轼','宋',NULL),(12,'柳永','宋','职业词人');

/*Table structure for table `poem` */

DROP TABLE IF EXISTS `poem`;

CREATE TABLE `poem` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(100) DEFAULT NULL COMMENT '题目',
  `author` bigint(20) unsigned DEFAULT NULL COMMENT '作者',
  `content` blob COMMENT '内容',
  `annotation` blob COMMENT '注释',
  `appreciate` blob COMMENT '赏析',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`),
  KEY `author_fk` (`author`),
  CONSTRAINT `author_fk` FOREIGN KEY (`author`) REFERENCES `author` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='作品表';

/*Data for the table `poem` */

insert  into `poem`(`id`,`title`,`author`,`content`,`annotation`,`appreciate`,`type`) values (3,'浣溪沙',11,'春未老，风细柳斜斜。试上超然台上看，半壕春水一城花，烟雨暗千家。\r\n清明后，酒醒却咨嗟。休对故人思故国，且将新火试新茶，诗酒趁年华。','','',NULL),(4,'潇湘神',8,'湘水流，湘水流，九疑云物至今愁。若问二妃何处所，零陵芳草露中秋。',NULL,NULL,NULL),(5,'潇湘神',8,'斑竹枝，斑竹枝，泪痕点点寄相思。楚客欲听瑶瑟怨，潇湘深夜月明时。',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
