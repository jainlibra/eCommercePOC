package com.publicissapient.inventoryservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.publicissapient.inventoryservice.dto.Product;

public interface ProductReadRepository extends MongoRepository<Product, String> {
	public List<Product> findByCategory(String category);

}
