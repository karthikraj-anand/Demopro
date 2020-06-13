-- step1: create a mysqlconnection using the following info

-- Host:localhost
-- port:3306
-- Connection Method: Standard(TCP/IP)
-- Username: root
-- Password: root


-- step2:after opening the connection, run the following sql scripts in mysql 

-- 1. 
CREATE DATABASE `localdbase`;

-- 2.
CREATE TABLE `demouser` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);
