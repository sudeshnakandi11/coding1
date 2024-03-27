package com.hexaware.model;

/**
 * This class represents a cart containing items added by a customer.
 */
public class Cart {
    public int cart_id;
    public int customer_id;
    public int product_id;
    public int quantity;

    /**
     * Constructs a new Cart object with the specified parameters.
     * 
     * @param cart_id The ID of the cart.
     * @param customer_id The ID of the customer who owns the cart.
     * @param product_id The ID of the product in the cart.
     * @param quantity The quantity of the product in the cart.
     */
    public Cart(int cart_id, int customer_id, int product_id, int quantity) {
        super();
        this.cart_id = cart_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    /**
     * Default constructor for Cart class.
     */
    public Cart() {
        super();
    }

    /**
     * Retrieves the cart ID.
     * 
     * @return int The cart ID.
     */
    public int getCart_id() {
        return cart_id;
    }

    /**
     * Sets the cart ID.
     * 
     * @param cart_id The cart ID to be set.
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    /**
     * Retrieves the customer ID.
     * 
     * @return int The customer ID.
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * Sets the customer ID.
     * 
     * @param customer_id The customer ID to be set.
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * Retrieves the product ID.
     * 
     * @return int The product ID.
     */
    public int getProduct_id() {
        return product_id;
    }

    /**
     * Sets the product ID.
     * 
     * @param product_id The product ID to be set.
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    /**
     * Retrieves the quantity of the product in the cart.
     * 
     * @return int The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the cart.
     * 
     * @param quantity The quantity of the product to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Checks if the cart is empty.
     * 
     * @return boolean True if the cart is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Displays the contents of the cart.
     */
    public void displayCart() {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        return "Cart [cart_id=" + cart_id + ", customer_id=" + customer_id + ", product_id=" + product_id
                + ", quantity=" + quantity + "]";
    }
}
