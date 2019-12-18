package com.publicissapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.publicissapient.DAO.OrderDAO;
import com.publicissapient.DAO.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@HystrixCommand(fallbackMethod = "errorHandler")
	public String saveOrder(Order orderInfo) {
		ObjectMapper objectMapper = new ObjectMapper();

		JsonObject orderJson = null;
		JsonDocument customerDoc = null;
		String response = null;
		try {
			
			String responsefromPayment="success";
			if(responsefromPayment.equals("success")) {
				orderInfo.setStatus("confirmed");
				orderJson = JsonObject.fromJson(objectMapper.writeValueAsString(orderInfo));
				customerDoc = JsonDocument.create("order" + "::" + orderJson.get("orderId"), orderJson);
				response = orderDAO.saveOrder(customerDoc);
			}else {
				orderJson = JsonObject.fromJson(objectMapper.writeValueAsString(orderInfo));
				customerDoc = JsonDocument.create("order" + "::" + orderJson.get("orderId"), orderJson);
				response = orderDAO.saveOrder(customerDoc);
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public String errorHandler(Order orderInfo) {

		return "Service is down . Please try again later.";
	}
}
