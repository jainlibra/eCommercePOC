package com.publicissapient.dao;

import com.publicissapient.pojo.OrderPaymentInfo;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CouchbaseRepository<OrderPaymentInfo,String> {
}
