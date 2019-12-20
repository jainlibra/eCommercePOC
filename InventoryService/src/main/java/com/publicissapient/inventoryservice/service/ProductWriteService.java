package com.publicissapient.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.exception.ProductNotFoundException;
import com.publicissapient.inventoryservice.repository.ProductWriteRepository;

@Service
public class ProductWriteService implements IProductWriteService {
	
	@Autowired
	ProductWriteRepository productWriteRepository;
	
	public void addProduct(Product product) {
		productWriteRepository.insert(product);
	}
	
	public void updateProduct(Product product){
		if(null == product)
			throw new ProductNotFoundException("Product Not Found");
		productWriteRepository.save(product);		
	}
	
	
	public void deleteProduct(Product product){
		if(null == product)
			throw new ProductNotFoundException("Product Not Found");
		productWriteRepository.delete(product);
	}	

}
