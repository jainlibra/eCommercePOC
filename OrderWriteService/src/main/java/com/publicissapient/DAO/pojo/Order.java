package com.publicissapient.DAO.pojo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.NonNull;
@Document
public class Order {
	@Id
	@Field
	
	private long orderId;
	@NonNull
	private  Collection<Product> itemList;
	
	
	@NonNull
	private String quantity;
	@NonNull
	private String userId;
	@NonNull
	private String cardNo;
	private List<OrderEvent> orderEvent;
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId,Collection<Product> itemId,String quantity,String userId) {
	this.orderId=orderId;
	this.itemList=itemId;
	this.quantity=quantity;
	this.userId=userId;
	}
	

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public Collection<Product> getItemList() {
		return itemList;
	}
	public void setItemList(Collection<Product> itemList) {
		this.itemList = itemList;
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
	public List<OrderEvent> getOrderEvent() {
		return orderEvent;
	}
	public void setOrderEvent(List<OrderEvent> orderEvent) {
		this.orderEvent = orderEvent;
	}
	
	

}
