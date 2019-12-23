package com.publicissapient.DAO;

import com.couchbase.client.java.document.JsonDocument;
import com.publicissapient.handler.ResourceNotFoundException;


public interface OrderDAO {
	
	//public String getOrderByOrderId(Integer customerName);
	public String saveOrder(JsonDocument orderInfo);

	public String deleteOrder(JsonDocument customerDoc);

	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException;

}
