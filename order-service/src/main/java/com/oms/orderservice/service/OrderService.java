package com.oms.orderservice.service;

import com.oms.orderservice.entity.Order;

public interface OrderService {
	
	Order findById(Long id);
	
	Order save(Order order);

}
