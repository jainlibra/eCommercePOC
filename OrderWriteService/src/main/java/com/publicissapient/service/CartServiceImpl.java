package com.publicissapient.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.publicissapient.DAO.CartDAO;
import com.publicissapient.DAO.pojo.CartItem;
import com.publicissapient.DAO.pojo.Product;
import com.publicissapient.handler.ResourceNotFoundException;

public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String saveCart(CartItem orderInfo) {
		ObjectMapper objectMapper = new ObjectMapper();

		JsonObject orderJson = null;
		JsonDocument customerDoc = null;
		String response = "Some issue in creating order. Please try again later";
		try {
			
			boolean checkInventroy = checkInventroy(orderInfo);
			if(checkInventroy) {
				response = "item added to cart successfully";
						
				orderInfo.setCartItemId(getGeneratedCartItemId());
			
				orderJson = JsonObject.fromJson(objectMapper.writeValueAsString(orderInfo));
				customerDoc = JsonDocument.create("cart" + "::" + orderJson.get("cartItemId"), orderJson);
				response = cartDAO.saveCart(customerDoc);
			
				return response+" "+orderInfo.getCartItemId();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	private boolean checkInventroy(CartItem orderInfo) {
		
		Product product = restTemplate.getForObject("http://inventory-service/inventory/"+orderInfo.getItemId(), Product.class);
		if(product.getQuantity() >= Long.parseLong(orderInfo.getQuantity())) {
			product.setQuantity(product.getQuantity()-Long.parseLong(orderInfo.getQuantity()));
			 return true;
		}
		return false;	
		
	}
	private long getGeneratedCartItemId() {
		
		return new Date().getTime();
	}

	@Override
	public String deleteCart(String cartItemDocId) {
		return cartDAO.deleteCartItem(cartItemDocId);
		//return null;
	}

	@Override
	public String getCartItem(long cartItemId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return cartDAO.getCartItem(cartItemId);
	}

}
