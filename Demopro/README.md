#Title 
Demopro

#Description
Signup and login in spring boot application using emailid and password that is accessed from mysql with rhe aid of spring data JPA

### Prerequisites

Need 
1.jdk8.0 
2.Sts and 
3.Mysql server
4.mysql client (Mysql workbench 8 tool)
5.mysql server (version 8)


### Installing

step1:install jdk 8

step2:import as the maven project in sts and configure build path by setting java_home 

step3: clear the active maven profile pom.xml(right click project -> properties -> maven ->clear/delete "pom.xml" -> click Apply)

step4: create a mysqlconnection using the following info

-- Host:localhost
-- port:3306
-- Connection Method: Standard(TCP/IP)
-- Username: root
-- Password: root


step5:after opening the connection, run the following sql scripts in mysql 

-- 1. 
CREATE DATABASE `localdbase`;

-- 2.
CREATE TABLE `demouser` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

## Deployment

Note:
need to set/check in application.properties prior building and running application

#DB
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/localdbase
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#JPA
spring.data.jpa.repositories.enabled=true
spring.jpa.show-sql=false

server.port=9090

spring.jpa.hibernate.ddl-auto=update

#view settings
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

Demopro application runs on embedded tomcat server

step 1:
right click the project->maven build-> Enter "clean install" in Goals field(maven goal)

step 2:
right click the DemoproApplication.java and select "run as" and click "java application" 

step 3:hit the following URLs to run

a)GET: http://localhost:9090/getUserList
api to get registerd user list

b)POST: http://localhost:9090/signup
i)Need to feed email and password and to pass the constraint which checks the equality of password and confirm password fields to get registered

c)POST: http://localhost:9090/login
Need to feed email and password to login into the system if the user gets through the authentication process.

## Authors

* **karthikrajan V** - 

