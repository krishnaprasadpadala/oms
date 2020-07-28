package com.oms.orderitem.service;

import java.util.List;

import com.oms.orderitem.entity.OrderItem;

public interface OrderItemService {
	
	List<OrderItem> findByOrderId(Long orderId);
	
	List<OrderItem> save(List<OrderItem> orderItems);

}
