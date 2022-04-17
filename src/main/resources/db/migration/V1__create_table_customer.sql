CREATE TABLE customer(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
) DEFAULT CHARSET UTF8 COMMENT 'Customer table';