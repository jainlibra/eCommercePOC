package com.publicissapient.inventoryservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.publicissapient.inventoryservice.dto.Product;


//@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	public List<Product> findByCategory(String category);

}
