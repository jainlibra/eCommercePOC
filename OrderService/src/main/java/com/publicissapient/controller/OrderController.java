package com.publicissapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.publicissapient.handler.ResourceNotFoundException;
import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.service.OrderService;

@RestController
public class OrderController {
       
       @Autowired
       private OrderService orderService;
       
       @GetMapping(path="/order/bucket/{orderId}")
       public String getOrderById(@PathVariable Integer orderId) throws ResourceNotFoundException {
              return orderService.getOrderByOrderId(orderId);
       }
       
     
}

