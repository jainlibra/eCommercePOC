package com.publicissapient.inventoryservice.service;

import com.publicissapient.inventoryservice.dto.Product;

public interface IProductWriteService {
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);	
	
	public void deleteProduct(Product product);

}
