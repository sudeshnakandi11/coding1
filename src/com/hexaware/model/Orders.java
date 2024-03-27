package com.hexaware.model;

import java.sql.Date;

/**
 * This class represents an order placed by a customer.
 */
public class Orders {
    public int order_id;
    public int customer_id;
    public Date order_date;
    public int total_price;
    public String shipping_address;

    /**
     * Constructs a new Orders object with the specified parameters.
     * 
     * @param order_id The ID of the order.
     * @param customer_id The ID of the customer who placed the order.
     * @param order_date The date when the order was placed.
     * @param total_price The total price of the order.
     * @param shipping_address The shipping address for the order.
     */
    public Orders(int order_id, int customer_id, Date order_date, int total_price, String shipping_address) {
        super();
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.shipping_address = shipping_address;
    }

    /**
     * Default constructor for Orders class.
     */
    public Orders() {
        super();
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
     * Retrieves the date when the order was placed.
     * 
     * @return Date The order date.
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * Sets the date when the order was placed.
     * 
     * @param date The order date to be set.
     */
    public void setOrder_date(Date date) {
        this.order_date = date;
    }

    /**
     * Retrieves the total price of the order.
     * 
     * @return int The total price of the order.
     */
    public int getTotal_price() {
        return total_price;
    }

    /**
     * Sets the total price of the order.
     * 
     * @param total_price The total price of the order to be set.
     */
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    /**
     * Retrieves the shipping address for the order.
     * 
     * @return String The shipping address.
     */
    public String getShipping_address() {
        return shipping_address;
    }

    /**
     * Sets the shipping address for the order.
     * 
     * @param shipping_address The shipping address to be set.
     */
    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    @Override
    public String toString() {
        return "Orders [order_id=" + order_id + ", customer_id=" + customer_id + ", order_date=" + order_date
                + ", total_price=" + total_price + ", shipping_address=" + shipping_address + "]";
    }
}
