DROP TABLE IF EXISTS PRODUCT;  
CREATE TABLE PRODUCT (  
	ID NUMBER AUTO_INCREMENT  PRIMARY KEY,  
	PRODUCT_NAME VARCHAR(50) NOT NULL,  
	QUANTITY NUMBER(8) NOT NULL  
);  
INSERT INTO product (PRODUCT_NAME, QUANTITY) VALUES ('Orange', 100);  
INSERT INTO product (PRODUCT_NAME, QUANTITY) VALUES ('Banana', 200);  
INSERT INTO product (PRODUCT_NAME, QUANTITY) VALUES ('Apple', 300); 