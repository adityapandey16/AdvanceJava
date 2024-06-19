package com.app.custom_exception;


public class ResourceNotFoundException extends RuntimeException {
   
	public ResourceNotFoundException(String messg)
	{
		super(messg);
	}
}
