package com.publicissapient.service;

import com.publicissapient.handler.ResourceNotFoundException;

public interface CartService {

	public String getCartItem(long cartItemId) throws ResourceNotFoundException;

}