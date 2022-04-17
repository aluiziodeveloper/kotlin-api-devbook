CREATE TABLE book(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status VARCHAR(255) NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
) DEFAULT CHARSET UTF8 COMMENT 'Book table';