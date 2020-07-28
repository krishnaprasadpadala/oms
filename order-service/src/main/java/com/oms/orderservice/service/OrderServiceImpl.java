package com.oms.orderservice.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.orderservice.dao.OrderRepository;
import com.oms.orderservice.dao.ProductRepository;
import com.oms.orderservice.entity.Order;
import com.oms.orderservice.entity.OrderItem;
import com.oms.orderservice.entity.Product;
import com.oms.orderservice.exception.OrderNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;
	
	@Override
	public Order findById(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> {
					String message = String.format("No Order present for Order Id '%s'", id);
					throw new OrderNotFoundException(message);
				});
		List<OrderItem> orderItems = orderItemServiceProxy.getOrderItems(id);
		order.setOrderItems(orderItems);
		return order;
	}
	
	@Override
	public Order save(Order order) {
		order.setOrderDate(new Date());
		determineAndSetTotalOrderValue(order);
		Order savedOrder = orderRepository.saveAndFlush(order);
		order.getOrderItems().forEach(item -> item.setOrderId(savedOrder.getId()));
		List<OrderItem> orderItems = orderItemServiceProxy.createOrderItems(order.getOrderItems());
		savedOrder.setOrderItems(orderItems);
		return savedOrder;
	}
	
	private void determineAndSetTotalOrderValue(Order order) {
		BigDecimal total = new BigDecimal(0);
		List<Product> products = productRepository.findAll();
		Map<String,Long> productsMap = products.stream()
				.collect(Collectors.toMap(Product::getProductCode, Product::getProductValue));
		List<OrderItem> items = order.getOrderItems();
		total = items.stream().map(item -> new BigDecimal((productsMap.get(item.getProductCode()) * item.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		order.setTotal(total);
				
	}

}
