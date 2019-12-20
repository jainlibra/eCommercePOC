package com.publicissapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.handler.ResourceNotFoundException;
import com.publicissapient.DAO.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException {
		
		return orderDAO.getOrderByOrderId(orderId);
	}


}
