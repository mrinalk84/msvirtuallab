DROP TABLE IF EXISTS DISCOUNT;  
CREATE TABLE DISCOUNT (  
	ID NUMBER AUTO_INCREMENT  PRIMARY KEY,  
	PRODUCT_NAME VARCHAR(50) NOT NULL,  
	DISCOUNT DOUBLE NOT NULL  
);  
INSERT INTO DISCOUNT (PRODUCT_NAME, DISCOUNT) VALUES ('Orange', 10.5);  
INSERT INTO DISCOUNT (PRODUCT_NAME, DISCOUNT) VALUES ('Banana', 12.5);  
INSERT INTO DISCOUNT (PRODUCT_NAME, DISCOUNT) VALUES ('Apple', 25.0); 