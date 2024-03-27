package com.hexaware.exception;

/**
 * The CustomerNotFoundException is a custom exception class used when a customer is not found.
 */
public class CustomerNotFoundException extends Exception {

    /**
     * Constructs a new CustomerNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
