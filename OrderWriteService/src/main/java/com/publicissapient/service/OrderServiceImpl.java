package com.publicissapient.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.publicissapient.DAO.OrderDAO;
import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.DAO.pojo.OrderEvent;
import com.publicissapient.DAO.pojo.PaymentDetail;
import com.publicissapient.DAO.pojo.Product;
import com.publicissapient.handler.ResourceNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private RestTemplate restTemplate;

	//@HystrixCommand(fallbackMethod = "errorHandler")
	public String saveOrder(Order orderInfo) {
		
		String response = "Some issue in creating order. Please try again later";
		String responsefromPayment=null;
		String status=null;
		try {
			
			//boolean checkInventroy = checkInventroy(orderInfo);
			List<OrderEvent> orderEvents=new ArrayList<>();
			long orderId = getGeneratedOrderId();
			
			orderInfo.setOrderId(orderId);
			boolean checkInventroy = true;
			status="verified Inventory";
			saveEvent(orderInfo,status,orderEvents);
			if(checkInventroy) {
				response = "order created with orderId";
			//PaymentDetail postForObject = getPaymentInfo(orderInfo);
			PaymentDetail postForObject = new PaymentDetail();
			postForObject.setStatus("SUCCESS");
			responsefromPayment=postForObject.getStatus();
			if(responsefromPayment.equals("SUCCESS")) {
					
				 status="Payment success";
				saveEvent(orderInfo,status,orderEvents);
					
				 status="Order Confirmed";
				 saveEvent(orderInfo,status,orderEvents);
			}else {
					
				 status="Payment Failed";
				 saveEvent(orderInfo,status,orderEvents);
				updateInventroy(orderInfo);
			}
			return response+" "+orderInfo.getOrderId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	private void saveEvent(Order orderInfo, String status, List<OrderEvent> orderEvents) {
		
		OrderEvent orderEvent=new OrderEvent();
		orderEvent.setEvent_timestramp(new Date().toLocaleString());
		orderEvent.setEventType(status);
		orderInfo.setOrderEvent(orderEvents);
		orderEvents.add(orderEvent);
		JsonObject orderJson = null;
		JsonDocument customerDoc = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			orderJson = JsonObject.fromJson(objectMapper.writeValueAsString(orderInfo));
			customerDoc = JsonDocument.create("order" + "::" + orderJson.get("orderId"), orderJson);
			orderDAO.saveOrder(customerDoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private boolean checkInventroy(Order orderInfo) {
		Collection<Product> itemList = orderInfo.getItemList();
		for (Product productid : itemList) {
			Product product = restTemplate.getForObject("http://inventory-service/inventory/"+productid.getProductId(), Product.class);
			if(product.getQuantity() >= Long.parseLong(orderInfo.getQuantity())) {
				product.setQuantity(product.getQuantity()-Long.parseLong(orderInfo.getQuantity()));
				 restTemplate.put("http://inventory-service/inventory/", product);
				 return true;
			}
		}
		
		return false;
		
		
	}
	private PaymentDetail getPaymentInfo(Order orderInfo) {
		PaymentDetail paymentDetail=new PaymentDetail();
		paymentDetail.setUserId(orderInfo.getUserId());
		paymentDetail.setCardNo(orderInfo.getCardNo());
		PaymentDetail postForObject=restTemplate.postForObject("http://payment-service/paymentInfo/"+orderInfo.getOrderId(), paymentDetail, PaymentDetail.class);
		return postForObject;
		
		
	}

	private long getGeneratedOrderId() {
		
		return new Date().getTime();
	}
	private void updateInventroy(Order orderInfo) {
		Collection<Product> itemList = orderInfo.getItemList();
		for (Product productid : itemList) {
			Product product = restTemplate.getForObject("http://inventory-service/inventory/"+productid.getProductId(), Product.class);
			
			product.setQuantity(product.getQuantity()+Long.parseLong(orderInfo.getQuantity()));
			 restTemplate.put("http://inventory-service/inventory/", product);
		}
		
			
		
		
		
	}

	public String errorHandler(Order orderInfo) {

		return "Service is down . Please try again later.";
	}

	public String deleteOrder(Order order) {
		updateInventroy(order);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonObject orderJson = null;
		JsonDocument customerDoc = null;
		String response = "Order has been deleted";
		//the logic to not allow order to be deleted once payment done should be in UI
		try {
			orderJson = JsonObject.fromJson(objectMapper.writeValueAsString(order));
			customerDoc = JsonDocument.create("order" + "::" + orderJson.get("orderId"), orderJson);
			response = orderDAO.deleteOrder(customerDoc);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
		
		
	}

	@Override
	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException {
		return orderDAO.getOrderByOrderId(orderId);
	}
}
