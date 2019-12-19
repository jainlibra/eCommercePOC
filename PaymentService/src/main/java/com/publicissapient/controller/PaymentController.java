package com.publicissapient.controller;

import com.publicissapient.pojo.OrderPaymentInfo;
import com.publicissapient.pojo.PaymentDetail;
import com.publicissapient.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping("/paymentInfo/{orderId}")
    OrderPaymentInfo getPaymentDetail(@PathVariable String orderId)
    {
        return paymentService.getPaymentDetail(orderId);
    }

    @RequestMapping(value = "/paymentInfo/{orderId}" ,method = RequestMethod.POST)
    PaymentDetail savePaymentDetail(@RequestBody PaymentDetail payment, @PathVariable String orderId)
    {
       return paymentService.savePaymentDetail(orderId,payment );

    }

}
