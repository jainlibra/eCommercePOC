package com.publicissapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.service.OrderService;

@RestController

public class OrderController {
       
       @Autowired
       private OrderService orderService;
	
       
       @PostMapping(path="/order/add")
       public String addOrder(@RequestBody String productjson) {
    	   ObjectMapper mapper = new ObjectMapper();
    	   Order order=null;
    	try {
			 order = mapper.readValue(productjson, Order.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
          return orderService.saveOrder(order);
		 
       }

}

