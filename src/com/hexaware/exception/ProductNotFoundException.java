package com.hexaware.exception;

/**
 * The ProductNotFoundException is a custom exception class used when a product is not found.
 */
public class ProductNotFoundException extends Exception {
    
    /**
     * Constructs a new ProductNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}
