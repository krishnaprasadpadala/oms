package com.oms.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.orderservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
