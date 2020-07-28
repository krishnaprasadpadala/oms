package com.oms.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.orderservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
