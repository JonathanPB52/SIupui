/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.9-MariaDB : Database - archivos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE archivos;

USE `archivos`;

/*Table structure for table `pdf` */

DROP TABLE IF EXISTS `pdf`;

CREATE TABLE `pdf` (
  `codigopdf` int(10) NOT NULL AUTO_INCREMENT,
  `nombrepdf` varchar(50) DEFAULT NULL,
  `archivopdf` mediumblob,
  PRIMARY KEY (`codigopdf`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `pdf` */

insert  into `pdf`(`codigopdf`,`nombrepdf`,`archivopdf`) values (8,'Jugos',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
