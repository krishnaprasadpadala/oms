package com.oms.orderitem.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.orderitem.dao.OrderItemRepository;
import com.oms.orderitem.entity.OrderItem;
import com.oms.orderitem.exceptions.OrderItemNotFoundException;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(OrderItemServiceImpl.class);
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public List<OrderItem> findByOrderId(Long orderId){
		List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);
		if(Objects.isNull(orderItems) || orderItems.isEmpty()) {
			String message = String.format("No Order Items present for the given order Id '%s'", orderId);
			LOGGER.error(message);
			throw new OrderItemNotFoundException(message);
		}
		return orderItems;
	}
	
	public List<OrderItem> save(List<OrderItem> orderItems) {
		return orderItemRepository.saveAll(orderItems);
	}
}
