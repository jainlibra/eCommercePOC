package com.publicissapient.inventoryservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.publicissapient.inventoryservice.dto.Product;

public interface IProductReadService {
	
	public List<Product> allProductInventory();
	
	public Product getInventoryProductById(String productId);
	
	public List<Product> getInventoryProductByCategory(String category);

}
