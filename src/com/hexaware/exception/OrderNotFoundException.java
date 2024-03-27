package com.hexaware.exception;

/**
 * The OrderNotFoundException is a custom exception class used when an order is not found.
 */
public class OrderNotFoundException extends Exception {
    
    /**
     * Constructs a new OrderNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public OrderNotFoundException(String message) {
        super(message);
    }
}
