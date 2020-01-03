package com.publicissapient.inventoryservice.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;
import com.publicissapient.inventoryservice.dto.Product;

@Repository
public class ProductWriteTemplate {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public boolean updateProductWithLocking(String productId,int quantity) {
		Product product = mongoTemplate.find(query(where("id").is(productId)), Product.class).get(0);
		long prodQtyTable = product.getQuantity();
		if(prodQtyTable >= (long)quantity) {
			product.setQuantity(prodQtyTable-(long)quantity);
		}
		try {
			mongoTemplate.save(product);
		}catch(OptimisticLockingFailureException ex) {
			return false;
		}
		return true;		
	}
	
	public boolean updateProductWithOverbooking(String productId,int quantity) {
		Update update = new Update().inc("quantity", -quantity);
		Query query = new Query(Criteria.where("id").is(productId).and("quantity").gte(-10+quantity));
		try {
			UpdateResult result = mongoTemplate.updateFirst(query,update,Product.class);
			if(null != result && result.getModifiedCount() == 1)
			{
				return true;
			}
		}catch(OptimisticLockingFailureException ex) {
			return false;
		}
		return true;
	}

}
