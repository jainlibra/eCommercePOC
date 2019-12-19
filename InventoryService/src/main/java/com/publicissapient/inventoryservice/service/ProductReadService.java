package com.publicissapient.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.repository.ProductReadRepository;

@Service
public class ProductReadService implements IProductReadService {
	
	@Autowired
	ProductReadRepository productReadRepository;
	
	public List<Product> allProductInventory(){	
		return productReadRepository.findAll();		
	}
	
	public Product getInventoryProductById(String productId){	
		return productReadRepository.findById(productId).get();		
	}
	
	public List<Product> getInventoryProductByCategory(String category){	
		return productReadRepository.findByCategory(category);		
	}

}
