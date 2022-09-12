## Project Name
doctor-patient-app

## Description

Project having 2 controller and every controller have 4 APIs which are as follows:
Patients APIs
1. Fetch Patient data by id:  	Method: GET  		URL: /patient/{ID}
2. Save Patient details:  		Method: POST  		URL: /patient
3. Update Patient details:  	Method: PUT  		URL: /patient
4. Delete Patient details:  	Method: DELETE  	URL: /patient/{ID} 

Doctors APIs
1. Fetch Doctor data by id:  	Method: GET  		URL: /doctor/{ID}
2. Save Doctor details:  		Method: POST  		URL: /doctor
3. Update Doctor details:  		Method: PUT  		URL: /doctor
4. Delete Doctor details:  		Method: DELETE  	URL: /doctor/{ID} 

## Postman Collection

https://www.getpostman.com/collections/c0446871334db16d81b6


## Data base script

--Doctor table: 

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `contact_number` varchar(15) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(50) NOT NULL,
  `specialties` varchar(45) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  `authorization` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  UNIQUE KEY `doctorId_UNIQUE` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--Patient table:

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `doctor_id` int DEFAULT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `contact_number` varchar(15) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  `authorization` varchar(500) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `patient_fk_doctor_idx` (`doctor_id`),
  CONSTRAINT `patient_fk_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Contains Patients related informations';


