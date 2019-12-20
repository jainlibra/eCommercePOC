package com.publicissapient.inventoryservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.dto.ProductList;
import com.publicissapient.inventoryservice.service.IProductReadService;
import com.publicissapient.inventoryservice.service.IProductWriteService;

@RestController()
public class InventoryServiceAPI {
	
	@Autowired
	IProductReadService productReadService;
	
	@Autowired
	IProductWriteService productWriteService;
	
	@GetMapping("/inventory")
	public ProductList allProductInventory(){	
		List<Product> products = productReadService.allProductInventory();
		return new ProductList(products);
	}
	
	@GetMapping("/inventory/{productId}")
	public Product getInventoryProductById(@PathVariable String productId){	
		return productReadService.getInventoryProductById(productId);		
	}
	
	@GetMapping("/inventory/category/{category}")
	public ProductList getInventoryProductByCategory(@PathVariable String category){	
		 List<Product> products = productReadService.getInventoryProductByCategory(category);
		 return new ProductList(products);
	}
	
	@PostMapping("/inventory")
	public ResponseEntity<Object> addProduct(@RequestBody Product product){
		productWriteService.addProduct(product);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	@PutMapping("/inventory")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product){
		productWriteService.updateProduct(product);
		return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/inventory")
	public ResponseEntity<Object> deleteProduct(@RequestBody Product product){
		productWriteService.deleteProduct(product);
		return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
	}	
	
}
