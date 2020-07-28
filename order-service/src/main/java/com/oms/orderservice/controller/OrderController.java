package com.oms.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.orderservice.entity.Order;
import com.oms.orderservice.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/order/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable Long orderId){
		Order order = orderService.findById(orderId);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping(value = "/order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		order = orderService.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

}
