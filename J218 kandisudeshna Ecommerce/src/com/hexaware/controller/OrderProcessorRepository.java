package com.hexaware.controller;

import java.util.List;
import java.util.Map;

import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.model.Customers;
import com.hexaware.model.Products;

/**
 * This interface defines methods for processing orders and interacting with the repository.
 */
public interface OrderProcessorRepository {
    
    /**
     * Creates a new customer.
     */
    void createCustomer();
    
    /**
     * Creates a new product.
     */
    void createProduct();
    
    /**
     * Deletes a product based on the given product ID.
     * 
     * @param product_id The ID of the product to be deleted.
     * @return boolean True if the product is successfully deleted, false otherwise.
     */
    boolean deleteProduct(int product_id);
    
    /**
     * Adds an item to the cart.
     * 
     * @return boolean True if the item is successfully added to the cart, false otherwise.
     */
    boolean addItemToCart();
    
    /**
     * Views the cart for a specific customer.
     * 
     * @param customerid The ID of the customer whose cart is to be viewed.
     */
    void viewcart(int customerid);
    
    /**
     * Places an order for a specific customer.
     * 
     * @param cid The ID of the customer for whom the order is placed.
     * @return boolean True if the order is successfully placed, false otherwise.
     */
    boolean placeOrder(int cid);
}
