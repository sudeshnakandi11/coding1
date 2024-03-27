create database ecom;
use ecom;
-- Customers table
create table customers (
    customer_id int primary key auto_increment,
    name varchar(100),
    email varchar(100),
    password varchar(100)
);
-- products table
create table products (
    product_id int primary key,
    name varchar(100),
    price decimal(10, 2),
    description text,
    stockQuantity int
);
-- cart table
create table cart (
    cart_id int primary key ,
    customer_id int,
    product_id int,
    quantity int,
    foreign key (customer_id) references customers(customer_id),
    foreign key  (product_id) references products(product_id)
);
alter table cart modify  cart_id int auto_increment;
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATE DEFAULT (CURRENT_DATE),
    total_price DECIMAL(10, 2),
    shipping_address TEXT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
 
alter table orders modify column order_id int  auto_increment ;
drop table orders;
drop table order_items;
create table order_items (
    order_item_id int primary key,
    order_id int,
    product_id int,
    quantity int,
    foreign key  (order_id) references orders(order_id),
    foreign key (product_id) references products(product_id)
);


select * from customers;
select * from cart;