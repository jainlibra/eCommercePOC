package com.publicissapient.service;

import com.publicissapient.handler.ResourceNotFoundException;

public interface OrderService {

	public String getOrderByOrderId(Integer orderId) throws ResourceNotFoundException;


}
