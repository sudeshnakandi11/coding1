package com.hexaware.model;

/**
 * This class represents a customer entity.
 */
public class Customers {
    public int customer_id;
    public String name;
    public String email;
    public String password;

    /**
     * Default constructor for Customers class.
     */
    public Customers() {
        super();
    }

    /**
     * Constructs a new Customers object with the specified parameters.
     * 
     * @param customer_id The ID of the customer.
     * @param name The name of the customer.
     * @param email The email address of the customer.
     * @param password The password of the customer.
     */
    public Customers(int customer_id, String name, String email, String password) {
        super();
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.password = password;
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
     * Retrieves the name of the customer.
     * 
     * @return String The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     * 
     * @param name The name of the customer to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the email address of the customer.
     * 
     * @return String The email address of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     * 
     * @param email The email address of the customer to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the password of the customer.
     * 
     * @return String The password of the customer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the customer.
     * 
     * @param password The password of the customer to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customers [customer_id=" + customer_id + ", name=" + name + ", email=" + email + ", password="
                + password + "]";
    }
}
