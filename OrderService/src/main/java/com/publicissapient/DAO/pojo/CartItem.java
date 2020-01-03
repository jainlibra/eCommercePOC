package com.publicissapient.DAO.pojo;

public class CartItem {
	
	private long cartItemId;
	public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	private String itemId;
	
	private String  skuId;
	
	private String status;
	
	private String quantity;
	
	private String userId;
	
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(long cartItemId,String itemId,String skuId,String status,String quantity,String userId) {
	this.cartItemId=cartItemId;
	this.itemId=itemId;
	this.skuId=skuId;
	this.status=status;
	this.quantity=quantity;
	this.userId=userId;
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
