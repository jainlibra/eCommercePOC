package com.publicissapient.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.dto.ProductRequest;
import com.publicissapient.inventoryservice.exception.ProductNotFoundException;
import com.publicissapient.inventoryservice.repository.ProductWriteRepository;
import com.publicissapient.inventoryservice.repository.ProductWriteTemplate;

@Service
public class ProductWriteService implements IProductWriteService {
	
	@Autowired
	ProductWriteRepository productWriteRepository;
	@Autowired
	ProductWriteTemplate productWriteTemplate;
	
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
	
	public boolean updateProductInventory(ProductRequest productRequest) {
		if(null == productRequest.getProductId() 
				|| "".equals(productRequest.getProductId()) 
				|| 0==productRequest.getQuantity()) {
			throw new ProductNotFoundException("Product Not Found");
		}
		return productWriteTemplate.updateProductWithLocking(productRequest.getProductId(), productRequest.getQuantity());
	}

}
