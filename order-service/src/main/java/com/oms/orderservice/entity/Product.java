package com.oms.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {
	
	@Id
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "product_value")
	private Long productValue;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Long getProductValue() {
		return productValue;
	}

	public void setProductValue(Long productValue) {
		this.productValue = productValue;
	}
	
	

}
