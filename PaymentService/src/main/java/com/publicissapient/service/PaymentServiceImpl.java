package com.publicissapient.service;

import com.publicissapient.Exception.CardDetailNotFound;
import com.publicissapient.dao.PaymentDaoImpl;
import com.publicissapient.pojo.OrderPaymentInfo;
import com.publicissapient.pojo.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDaoImpl paymentDao;

    @Autowired
    CardService cardService;
    @Override
    public PaymentDetail savePaymentDetail(String orderId, PaymentDetail payment) throws CardDetailNotFound {
        cardService.getCardDetail(payment.getUserId(),payment.getCardNo());
        return paymentDao.savePaymentDetail(orderId,payment);
    }

    @Override
    public OrderPaymentInfo getPaymentDetail(String orderId) {
        return paymentDao.getPaymentDetail(orderId);
    }
}
