CREATE TABLE customer(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    name VARCHAR(255) COMMENT 'Name field',
    email VARCHAR(255) COMMENT 'Email field'
) DEFAULT CHARSET UTF8 COMMENT 'Customer table';