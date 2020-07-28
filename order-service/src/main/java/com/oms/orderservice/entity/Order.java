package com.oms.orderservice.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity(name = "oms_order_service")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@NotEmpty(message = "address cannot be enpty")
	@Column(name = "address")
	private String address;
	
	@Transient
	private List<OrderItem> orderItems;
	
	@Column(name = "total")
	private BigDecimal total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
