package com.publicissapient.inventoryservice.service;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.dto.ProductRequest;

public interface IProductWriteService {
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);	
	
	public void deleteProduct(Product product);
	
	public boolean updateProductInventory(ProductRequest productRequest);

}
