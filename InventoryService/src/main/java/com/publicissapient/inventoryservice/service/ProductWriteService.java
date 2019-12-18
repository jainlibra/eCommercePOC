package com.publicissapient.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.repository.ProductRepository;

@Service
public class ProductWriteService implements IProductWriteService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.insert(product);
	}
	
	public void updateProduct(Product product){
		 productRepository.save(product);		
	}
	
	
	public void deleteProduct(Product product){
		productRepository.delete(product);
	}	

}
