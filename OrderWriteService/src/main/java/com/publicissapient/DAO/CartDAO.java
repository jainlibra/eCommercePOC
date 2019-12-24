package com.publicissapient.DAO;

import com.couchbase.client.java.document.JsonDocument;
import com.publicissapient.handler.ResourceNotFoundException;

public interface CartDAO {
	
		
		public String saveCart(JsonDocument cart);
		public String deleteCartItem(String cartItemDocId);
		public String getCartItem(long cartItemId) throws ResourceNotFoundException;



}
