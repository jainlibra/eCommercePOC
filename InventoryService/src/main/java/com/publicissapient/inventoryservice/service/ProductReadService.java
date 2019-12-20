package com.publicissapient.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.exception.ProductNotFoundException;
import com.publicissapient.inventoryservice.repository.ProductReadRepository;

@Service
public class ProductReadService implements IProductReadService {
	
	@Autowired
	ProductReadRepository productReadRepository;
	
	public List<Product> allProductInventory(){	
		return productReadRepository.findAll();		
	}
	
	public Product getInventoryProductById(String productId) throws ProductNotFoundException{
		Optional<Product> product = productReadRepository.findById(productId);
		if(!product.isPresent())
			throw new ProductNotFoundException("Invalid Product Id- "+productId);
		return product.get();
	}
	
	public List<Product> getInventoryProductByCategory(String category){	
		return productReadRepository.findByCategory(category);		
	}

}
