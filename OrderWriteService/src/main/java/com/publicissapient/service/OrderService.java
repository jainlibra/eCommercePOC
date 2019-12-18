package com.publicissapient.service;

import com.publicissapient.DAO.pojo.Order;

public interface OrderService {

	//public String getOrderByOrderId(Integer orderId);
	public String saveOrder(Order orderInfo);

}
