package com.hexaware.exception;

public class CustomerNotFoundException extends Exception{

	
	public  CustomerNotFoundException(String response)
	{
		super(response);
	}
}