package com.publicissapient.DAO;

import com.publicissapient.handler.ResourceNotFoundException;

public interface OrderDAO {
	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException;
	

}
