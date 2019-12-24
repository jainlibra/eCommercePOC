package com.publicissapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.handler.ResourceNotFoundException;
import com.publicissapient.service.CartService;
import com.publicissapient.service.OrderService;

@RestController
public class OrderController {
       
       @Autowired
       private OrderService orderService;
       @Autowired
       private CartService cartService;
       
       @GetMapping(path="/order/bucket/{orderId}")
       public String getOrderById(@PathVariable long orderId) throws ResourceNotFoundException {
              return orderService.getOrderByOrderId(orderId);
       }
       
       @GetMapping(path="/cart/bucket/{cartItemId}")
       public String getCartItemById(@PathVariable long cartItemId) throws ResourceNotFoundException {
              return cartService.getCartItem(cartItemId);
       }
       
     
}

