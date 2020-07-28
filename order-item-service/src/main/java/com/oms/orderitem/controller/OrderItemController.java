package com.oms.orderitem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.orderitem.entity.OrderItem;
import com.oms.orderitem.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderService;
	
	@GetMapping(value = "/order-item/{orderId}")
	public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Long orderId) {
		List<OrderItem> orderItems;
		orderItems = orderService.findByOrderId(orderId);
		return ResponseEntity.ok(orderItems);
	}
	
	@PostMapping(value = "/order-item")
	public ResponseEntity<List<OrderItem>> createOrderItem(@RequestBody List<OrderItem> orderItems) {
		List<OrderItem> persistedOrderItem = orderService.save(orderItems);
		return ResponseEntity.ok(persistedOrderItem);
	}

}
