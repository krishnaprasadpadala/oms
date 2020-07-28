package com.oms.orderitem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity(name = "oms_order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "productCode is mandatory")
	@Column(name = "product_code")
	private String productCode;
	
	@NotEmpty(message = "productName is mandatory")
	@Column(name = "product_name")
	private String productName;
	
	@NotNull(message = "quantity is mandatory")
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "order_id")
	private Long orderId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public static class Builder {
		OrderItem orderItem = new OrderItem();
		
		public Builder id(Long id) {
			this.orderItem.id = id;
			return this;
		}

		public Builder orderId(Long orderId) {
			this.orderItem.orderId = orderId;
			return this;
		}
		
		public Builder productCode(String productCode) {
			this.orderItem.productCode = productCode;
			return this;
		}
		
		public Builder productName(String productName) {
			this.orderItem.productName = productName;
			return this;
		}
		
		public Builder quantity(Long quantity) {
			this.orderItem.quantity = quantity;
			return this;
		}
		
		
		public OrderItem build() {
			return this.orderItem;
		}
	}


}
