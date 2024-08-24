CREATE DATABASE IF NOT EXISTS db_evualacion2;
USE db_evualacion2;

INSERT INTO customers (customer_name, customer_email, customer_address)
VALUES ('John Doe', 'johndoe@example.com', '123 Main St'),
       ('Jane Smith', 'janesmith@example.com', '456 Oak Ave'),
       ('Michael Johnson', 'michaelj@example.com', '789 Pine Rd'),
       ('Emily Davis', 'emilyd@example.com', '321 Elm St'),
       ('David Brown', 'davidb@example.com', '654 Maple Ave');


INSERT INTO categories (category_name, category_type)
VALUES ('Electronics', 'Gadgets'),
       ('Books', 'Media'),
       ('Clothing', 'Apparel'),
       ('Furniture', 'Home'),
       ('Toys', 'Children');

INSERT INTO products (product_name, category_id)
VALUES ('Smartphone', 1),
       ('Laptop', 1),
       ('Novel', 2),
       ('T-shirt', 3),
       ('Sofa', 4);

INSERT INTO deliveries (type, status)
VALUES ('Standard', 'In Transit'),
       ('Express', 'Delivered'),
       ('Overnight', 'Shipped'),
       ('Pickup', 'Ready for Pickup'),
       ('Drone', 'In Transit');

INSERT INTO orders (order_date, delivery_id, customer_id)
VALUES ('2024-08-01', 1, 1),
       ('2024-08-02', 2, 2),
       ('2024-08-03', 3, 3),
       ('2024-08-04', 4, 4),
       ('2024-08-05', 5, 5);

INSERT INTO Order_Product (order_id, product_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4),
       (4, 5);


-- Selects
SELECT *
FROM customers;

SELECT *
FROM categories;

SELECT *
FROM products;

SELECT *
FROM deliveries;

SELECT *
FROM orders;

SELECT *
FROM Order_Product;

DELETE
FROM customers
WHERE customer_id = 6;

-- Get products for each order
SELECT o.order_id, p.product_name, c.customer_name
FROM orders o
         JOIN order_product op ON o.order_id = op.order_id
         JOIN products p ON op.product_id = p.product_id
         JOIN customers c ON o.customer_id = c.customer_id;



