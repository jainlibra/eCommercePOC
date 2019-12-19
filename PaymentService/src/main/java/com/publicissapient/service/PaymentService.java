package com.publicissapient.service;

import com.publicissapient.pojo.OrderPaymentInfo;
import com.publicissapient.pojo.PaymentDetail;

public interface PaymentService {
    PaymentDetail savePaymentDetail(String orderId, PaymentDetail payment);

    OrderPaymentInfo getPaymentDetail(String orderId);
}
