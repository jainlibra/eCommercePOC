package com.publicissapient.inventoryservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.service.IProductReadService;
import com.publicissapient.inventoryservice.service.IProductWriteService;

@RestController()
public class InventoryServiceAPI {
	
	@Autowired
	IProductReadService productReadService;
	
	@Autowired
	IProductWriteService productWriteService;
	
	@GetMapping("/inventory")
	public List<Product> allProductInventory(){	
		return productReadService.allProductInventory();		
	}
	
	@GetMapping("/inventory/{productId}")
	public Product getInventoryProductById(@PathVariable String productId){	
		return productReadService.getInventoryProductById(productId);		
	}
	
	@GetMapping("/inventory/category/{category}")
	public List<Product> getInventoryProductByCategory(@PathVariable String category){	
		return productReadService.getInventoryProductByCategory(category);		
	}
	
	@PostMapping("/inventory")
	public void addProduct(@RequestBody Product product){
		productWriteService.addProduct(product);		
	}
	
	@PutMapping("/inventory")
	public void updateProduct(@RequestBody Product product){
		productWriteService.updateProduct(product);
		
	}
	
	@DeleteMapping("/inventory")
	public void deleteProduct(@RequestBody Product product){
		productWriteService.deleteProduct(product);
	}	
	
}
