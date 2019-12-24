package com.publicissapient.service;

import com.publicissapient.DAO.pojo.CartItem;
import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.handler.ResourceNotFoundException;

public interface CartService {

	public String saveCart(CartItem orderInfo);

	public String deleteCart(String cartItemDocId);
	public String getCartItem(long cartItemId) throws ResourceNotFoundException;

}