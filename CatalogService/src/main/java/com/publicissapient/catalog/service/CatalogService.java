package com.publicissapient.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.publicissapient.catalog.dto.Product;
import com.publicissapient.catalog.dto.ProductList;

@Service
public class CatalogService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ProductList getInventoryProductByCategory(String category){
		ProductList products= restTemplate.getForObject("http://inventory-service/inventory/category/"+category,ProductList.class);
		for(Product product:products.getProducts()) {
			if(product.getQuantity()==0) {	
				product.setStatus(product.getProductName() +" is out of stock");		
			}else {
				product.setStatus(product.getProductName() +" is availble");
			}
		}
		return products;
		
	}
	
	public Product getInventoryProductById(String productId){
		
		Product product= restTemplate.getForObject("http://inventory-service/inventory/"+productId, Product.class);
		if(product.getQuantity()==0) {			
			product.setStatus(product.getProductName() +" is out of stock");
		}else {
			product.setStatus(product.getProductName() +" is availble");
		}
		
		return product;
		
	}
	
	public ProductList getInventoryProduct(){
		ProductList products= restTemplate.getForObject("http://inventory-service/inventory",ProductList.class);
		for(Product product:products.getProducts()) {
			if(product.getQuantity()==0) {
				product.setStatus(product.getProductName() +" is out of stock");	
			}else {
				product.setStatus(product.getProductName() +" is availble");
			}
		}
		return products;
		
	}

}
