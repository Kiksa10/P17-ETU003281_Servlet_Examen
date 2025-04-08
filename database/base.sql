CREATE DATABASE db_s2_ETU003281;
USE db_s2_ETU003281;

CREATE TABLE users_servlet (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(50) NOT NULL,
        email VARCHAR(50) NOT NULL,
        pwd VARCHAR(50)
);

CREATE TABLE credit_servlet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    libeller VARCHAR(100) NOT NULL,
    montant INT
);

CREATE TABLE depense_servlet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idCredit INT,
    montant INT,
    dates DATETIME
    
);



INSERT INTO users_servlet (name,email,pwd) VALUES (
    "Madoda","fitia@gmail.com","12345"
);

SELECT *FROM credit_servlet LEFT JOIN depense_servlet ON credit_servlet.id = depense_servlet.idCredit;