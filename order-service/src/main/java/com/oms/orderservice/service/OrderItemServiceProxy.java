package com.oms.orderservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.oms.orderservice.entity.OrderItem;

@FeignClient(name = "order-item-service", url="localhost:8070")
public interface OrderItemServiceProxy {
	
	@GetMapping(value = "/order-item/{orderId}")
	public List<OrderItem> getOrderItems(@PathVariable("orderId") Long orderId);
	
	@PostMapping(value = "/order-item")
	public List<OrderItem> createOrderItems(@RequestBody List<OrderItem> orderItems);

}
