package com.publicissapient.DAO.pojo;

import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	String productId;
	String productName;
	String productDescription;
	String category;
	String price;
	long quantity;
	
	public Product() {
		
	}
	
	public Product(String productId, String productName, String productDescription, String category, String price,
			long quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", category=" + category + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	

}
