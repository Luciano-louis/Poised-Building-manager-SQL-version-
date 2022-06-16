create database if not exists poisedPMS_db;

use poisedPMS_db;

drop table if exists TASKS;
create table TASKS(
	PRO_NUM int(10)NOT NULL AUTO_INCREMENT,
	PRO_NAME varchar(225),
	BUILDING varchar(225),
	ADDRESS varchar(225),
	ERF int(10),
	PRICE int(10),
	PAID int(10),
	DEADLINE Date,
	ARCHITECT varchar(225),
	CONTRACTOR varchar(225),
	CUSTOMER varchar(225),
	PRIMARY KEY (PRO_NUM));

INSERT INTO tasks(PRO_NUM, PRO_NAME, BUILDING, ADDRESS, ERF, PRICE, PAID, DEADLINE, ARCHITECT, CONTRACTOR, CUSTOMER)
VALUES('1', 'Louis house 1', 'flat', '10 Pelican street meredale', '001', '1000000', '100000', '2019-10-10', 'Luciano', 'Kaykz', 'Louisness');

INSERT INTO tasks(PRO_NUM, PRO_NAME, BUILDING, ADDRESS, ERF, PRICE, PAID, DEADLINE, ARCHITECT, CONTRACTOR, CUSTOMER)
VALUES('2', 'Louis house 2', 'flat', '10 Pelican street meredale', '002', '1000000', '100000', '2019-10-10', 'Luciano', 'Kaykz', 'Louisness'); 


CREATE TABLE CUSTOMERS(
	CU_NUM int(10)NOT NULL AUTO_INCREMENT,
	CU_NAME varchar(255),
	CU_PHONE varchar(15),
	CU_EMAIL char(255),
	CU_ADDRESS char(255),
	PRIMARY KEY (CU_NUM));

INSERT INTO CUSTOMERS (CU_NAME, CU_PHONE, CU_EMAIL, CU_ADDRESS)
VALUES('Luciano', '0781861677', 'louisness92@gmail.com', '10 Pelican street');


INSERT INTO CUSTOMERS (CU_NAME, CU_PHONE, CU_EMAIL, CU_ADDRESS)
VALUES('Louisness', '0781861677', 'louisness92@gmail.com', '10 Pelican street');

CREATE TABLE ARCHITECTS(
	ID int(10)NOT NULL AUTO_INCREMENT,
	AR_NAME varchar(255),
	AR_PHONE varchar(15),
	AR_EMAIL char(255),
	AR_ADDRESS char(255),
	PRIMARY KEY (ID)
);


INSERT INTO ARCHITECTS (AR_NAME, AR_PHONE, AR_EMAIL, AR_ADDRESS)
VALUES('Luciano', '0781861677', 'louisness92@gmail.com', '10 Pelican street');


INSERT INTO ARCHITECTS (AR_NAME, AR_PHONE, AR_EMAIL, AR_ADDRESS)
VALUES('Louisness', '0781861677', 'louisness92@gmail.com', '10 Pelican street');


CREATE TABLE CONTRACTORS (
	PRO_NUM int(10)NOT NULL AUTO_INCREMENT,
	CO_NAME varchar(255),
	CO_PHONE varchar(15),
	CO_EMAIL char(255),
	CO_ADDRESS char(255),
	PRIMARY KEY (PRO_NUM)
);


INSERT INTO CONTRACTORS(CO_NAME, CO_PHONE, CO_EMAIL, CO_ADDRESS)
VALUES('Luciano', '0781861677', 'louisness92@gmail.com', '10 Pelican street');


INSERT INTO CONTRACTORS(CO_NAME, CO_PHONE, CO_EMAIL, CO_ADDRESS)
VALUES('Louisness', '0781861677', 'louisness92@gmail.com', '10 Pelican street');

drop table if exists FINALISED;
create table FINALISED(
	PRO_NAME varchar(225),
	BUILDING varchar(225),
	ADDRESS varchar(225),
	ERF varchar(225),
	ARCHITECT varchar(225),
	CONTRACTOR varchar(225),
	CUSTOMER varchar(225),
	DATE Date);