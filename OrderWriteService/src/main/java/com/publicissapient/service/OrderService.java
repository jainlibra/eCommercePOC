package com.publicissapient.service;

import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.handler.ResourceNotFoundException;

public interface OrderService {

	//public String getOrderByOrderId(Integer orderId);
	public String saveOrder(Order orderInfo);

	public String deleteOrder(Order order);
	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException;

}
