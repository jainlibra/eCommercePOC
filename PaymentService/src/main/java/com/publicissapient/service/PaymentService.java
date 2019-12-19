package com.publicissapient.service;

import com.publicissapient.Exception.CardDetailNotFound;
import com.publicissapient.pojo.OrderPaymentInfo;
import com.publicissapient.pojo.PaymentDetail;

public interface PaymentService {
    PaymentDetail savePaymentDetail(String orderId, PaymentDetail payment) throws CardDetailNotFound;

    OrderPaymentInfo getPaymentDetail(String orderId);
}
