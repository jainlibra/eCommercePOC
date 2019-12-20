package com.publicissapient.service;

import com.publicissapient.handler.ResourceNotFoundException;

public interface OrderService {

	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException;


}
