package com.publicissapient.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.publicissapient.DAO.CartDAO;
import com.publicissapient.handler.ResourceNotFoundException;

public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	

	@Override
	public String getCartItem(long cartItemId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return cartDAO.getCartItem(cartItemId);
	}

}
