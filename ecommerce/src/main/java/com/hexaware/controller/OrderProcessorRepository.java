package com.hexaware.controller;

import java.util.List;
import java.util.Map;

import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.model.Customers;
import com.hexaware.model.Products;

public interface OrderProcessorRepository {
 void createCustomer();
 void createProduct();
 boolean deleteProduct(int product_id);
 boolean addItemToCart();
 void viewcart(int customerid);
 void placeOrder(int cid);
}
