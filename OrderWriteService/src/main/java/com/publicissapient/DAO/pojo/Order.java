package com.publicissapient.DAO.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

public class Order {
	
	private int orderId;
	@NonNull
	private String itemId;
	@NonNull
	private String  skuId;
	@NonNull
	private String status;
	@NonNull
	private String quantity;
	@NonNull
	private String userId;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId,String itemId,String skuId,String status,String quantity,String userId) {
	this.orderId=orderId;
	this.itemId=itemId;
	this.skuId=skuId;
	this.status=status;
	this.quantity=quantity;
	this.userId=userId;
	}
	

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
