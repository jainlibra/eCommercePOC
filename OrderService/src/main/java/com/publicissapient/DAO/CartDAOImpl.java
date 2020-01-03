package com.publicissapient.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.document.JsonDocument;
import com.publicissapient.config.OrderConfig;
import com.publicissapient.handler.ResourceNotFoundException;
@Repository
public class CartDAOImpl implements CartDAO{
	
	@Autowired
    private OrderConfig orderConfig;

	@Override
	public String getCartItem(long cartItemId) throws ResourceNotFoundException {
		JsonDocument jsonDocument = orderConfig.getBucket().get("cart::"+cartItemId);
		if(jsonDocument==null) {
			throw new ResourceNotFoundException("resouce not found");
		}
		return jsonDocument.content().toString();
	}

}
