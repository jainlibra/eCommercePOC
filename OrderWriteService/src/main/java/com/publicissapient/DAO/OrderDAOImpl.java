package com.publicissapient.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.document.JsonDocument;
import com.publicissapient.config.OrderConfig;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private OrderConfig orderConfig;
    
  
	@Override
	public String saveOrder(JsonDocument orderInfo) {
	orderConfig.getBucket().upsert(orderInfo);
	//orderRepository.getCouchbaseOperations().update(objectToUpdate);
		return "record inserted";
	}

}
