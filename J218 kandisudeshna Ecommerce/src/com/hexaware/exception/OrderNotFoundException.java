package com.hexaware.exception;

public class OrderNotFoundException extends Exception {
	
	public OrderNotFoundException(String response)
	{
		super(response);
	}

}