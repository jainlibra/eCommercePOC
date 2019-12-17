package com.publicissapient.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.repository.ProductRepository;
import com.sun.scenario.effect.impl.prism.PrDrawable;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> allProductInventory(){	
		return productRepository.findAll();		
	}
	
	public Product getInventoryProductById(String productId){	
		return productRepository.findById(productId).get();		
	}
	
	public List<Product> getInventoryProductByCategory(String category){	
		return productRepository.findByCategory(category);		
	}
	
	
	public void updateProduct(Product product){
		 productRepository.save(product);		
	}
	
	
	public void deleteProduct(Product product){
		productRepository.delete(product);
	}	
	

}
