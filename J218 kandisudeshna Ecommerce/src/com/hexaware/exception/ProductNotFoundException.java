package com.hexaware.exception;

public class ProductNotFoundException extends Exception {
	
	public ProductNotFoundException(String response)
	{
		super(response);
	}

}