package com.hexaware.model;

/**
 * This class represents an item in an order.
 */
public class OrderItems {
    public int order_item_id;
    public int order_id;
    public int product_id;
    public int quantity;

    /**
     * Constructs a new OrderItems object with the specified parameters.
     * 
     * @param order_item_id The ID of the order item.
     * @param order_id The ID of the order to which the item belongs.
     * @param product_id The ID of the product in the item.
     * @param quantity The quantity of the product in the item.
     */
    public OrderItems(int order_item_id, int order_id, int product_id, int quantity) {
        super();
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    /**
     * Default constructor for OrderItems class.
     */
    public OrderItems() {
        super();
    }

    /**
     * Retrieves the order item ID.
     * 
     * @return int The order item ID.
     */
    public int getOrder_item_id() {
        return order_item_id;
    }

    /**
     * Sets the order item ID.
     * 
     * @param order_item_id The order item ID to be set.
     */
    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    /**
     * Retrieves the order ID.
     * 
     * @return int The order ID.
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Sets the order ID.
     * 
     * @param order_id The order ID to be set.
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
     * Retrieves the quantity of the product in the item.
     * 
     * @return int The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the item.
     * 
     * @param quantity The quantity of the product to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
