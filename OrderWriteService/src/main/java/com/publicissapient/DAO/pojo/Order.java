package com.publicissapient.DAO.pojo;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
@Document
public class Order {
	@Id
	@Field
	
	private long orderId;
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
	@NonNull
	private String cardNo;
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId,String itemId,String skuId,String status,String quantity,String userId) {
	this.orderId=orderId;
	this.itemId=itemId;
	this.skuId=skuId;
	this.status=status;
	this.quantity=quantity;
	this.userId=userId;
	}
	

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
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
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
