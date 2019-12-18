package com.publicissapient.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.repository.ProductRepository;

@Service
public class ProductReadService implements IProductReadService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> allProductInventory(){	
		return productRepository.findAll();		
	}
	
	public Product getInventoryProductById(String productId){	
		return productRepository.findById(productId).get();		
	}
	
	public List<Product> getInventoryProductByCategory(String category){	
		return productRepository.findByCategory(category);		
	}

}
