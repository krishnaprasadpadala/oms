package com.oms.orderitem.exceptions;

public class OrderItemNotFoundException extends RuntimeException {
	
	public OrderItemNotFoundException(String message) {
		super(message);
	}

}
