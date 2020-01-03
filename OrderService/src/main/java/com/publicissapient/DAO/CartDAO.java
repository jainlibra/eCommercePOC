package com.publicissapient.DAO;

import com.publicissapient.handler.ResourceNotFoundException;

public interface CartDAO {		
		public String getCartItem(long cartItemId) throws ResourceNotFoundException;

}
