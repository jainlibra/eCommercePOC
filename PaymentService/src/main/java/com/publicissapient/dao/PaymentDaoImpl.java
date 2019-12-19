package com.publicissapient.dao;

import com.publicissapient.pojo.OrderPaymentInfo;
import com.publicissapient.pojo.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

@Component

public class PaymentDaoImpl {
    @Autowired
    PaymentRepository paymentRepository;

    private ArrayList<String> paymentStatus=new ArrayList<>(Arrays.asList("SUCCESS","FAILED"));


    public PaymentDetail savePaymentDetail(String orderId, PaymentDetail payment) {
        ArrayList<PaymentDetail> cardList=new ArrayList<>();
        OrderPaymentInfo orderPaymentInfo;
        payment.setStatus(makePayment());
        payment.setpID(orderId+"_"+generatePid());
        if(!paymentRepository.existsById(orderId)) {
            orderPaymentInfo=new OrderPaymentInfo();
            orderPaymentInfo.setOrderId(orderId);
            cardList.add(payment);
            orderPaymentInfo.setPaymentDetail(cardList);
            paymentRepository.save(orderPaymentInfo);
        }
        else
        {
            orderPaymentInfo=paymentRepository.findById(orderId).get();
            orderPaymentInfo.getPaymentDetail().add(payment);
            paymentRepository.save(orderPaymentInfo);
        }
        return payment;

    }

    public OrderPaymentInfo getPaymentDetail(String orderId) {
        return paymentRepository.findById(orderId).get();
    }

    private String makePayment()
    {
        Random rand = new Random();
        return paymentStatus.get(rand.nextInt(paymentStatus.size()));
    }
    private String generatePid()
    {
        return String.valueOf( new Date().getTime());
    }
}
