DROP DATABASE IF EXISTS cs351_db;
CREATE DATABASE cs351_db;
USE cs351_db;

CREATE TABLE addresses (
  id        		INT UNSIGNED  PRIMARY KEY   AUTO_INCREMENT NOT NULL,
  fname       		VARCHAR(80),
  sname				VARCHAR(80),
  telephone			VARCHAR(30),
  mobile			VARCHAR(30),
  email				VARCHAR(80),
  address			VARCHAR(100),
  postalnr			VARCHAR(10),
  town				VARCHAR(40),
  country			VARCHAR(30)
);