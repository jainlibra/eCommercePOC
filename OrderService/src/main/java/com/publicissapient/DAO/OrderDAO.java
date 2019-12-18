package com.publicissapient.DAO;

import com.publicissapient.handler.ResourceNotFoundException;

public interface OrderDAO {
	public String getOrderByOrderId(Integer orderId) throws ResourceNotFoundException;
	

}
