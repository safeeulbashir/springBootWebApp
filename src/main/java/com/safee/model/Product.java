package com.safee.model;

public class Product {
	private String productId;
	private String name;
	private float price;
	
	
	
	public Product() {
		super();
	}
	public Product(String productId, String name, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
