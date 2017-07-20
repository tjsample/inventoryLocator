DROP TABLE IF EXISTS Inventory;

CREATE TABLE Inventory (
    inventory_id bigint NOT NULL AUTO_INCREMENT,
	product_id bigint NOT NULL,
	product_name varchar(100),
	product_amount int(100),
	PRIMARY KEY (inventory_id)
);

DROP TABLE IF EXISTS CustomerOrder;

CREATE TABLE CustomerOrder (
    customerOrderId bigint NOT NULL AUTO_INCREMENT, 
	header char(36) NOT NULL, 
	product_id bigint NOT NULL,
    order_amount int NOT NULL,
    allocated_amount int NOT NULL,
    backOrdered_amount int NOT NULL,
    order_received TIMESTAMP AS CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY (customerOrderId)
);


