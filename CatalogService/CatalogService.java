package com.publicissapient.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.publicissapient.catalog.dto.Product;

@Service
public class CatalogService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Product> getInventoryProductByCategory(String category){
		//? ask him to change it object not in list form
		List<Product> products=(List<Product>) restTemplate.getForObject("http://inventory-service/inventory/{category}", Product.class);
		return products;
		
	}
	
	public List<Product> getInventoryProductById(String productId){
		//? ask him to change it object not in list form
		List<Product> products=(List<Product>) restTemplate.getForObject("http://inventory-service/inventory/{productId}", Product.class);
		return products;
		
	}
	
	

}
