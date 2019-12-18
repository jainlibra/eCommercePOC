package com.publicissapient.DAO;

import com.couchbase.client.java.document.JsonDocument;


public interface OrderDAO {
	//public String getOrderByOrderId(Integer customerName);
	public String saveOrder(JsonDocument orderInfo);

}
