package com.publicissapient.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.document.JsonDocument;
import com.publicissapient.config.OrderConfig;
import com.publicissapient.handler.ResourceNotFoundException;

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


	@Override
	public String deleteOrder(JsonDocument customerDoc) {
		orderConfig.getBucket().remove(customerDoc);
		return "record deleted";
	}


	@Override
	public String getOrderByOrderId(long orderId) throws ResourceNotFoundException {
		 JsonDocument jsonDocument = orderConfig.getBucket().get("order::"+orderId);
			if(jsonDocument==null) {
				throw new ResourceNotFoundException("resouce not found");
			}
			return jsonDocument.content().toString();
	}

}
