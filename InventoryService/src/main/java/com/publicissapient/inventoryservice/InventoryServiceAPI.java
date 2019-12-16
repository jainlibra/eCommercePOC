package com.publicissapient.inventoryservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.inventoryservice.dto.Product;

@RestController
public class InventoryServiceAPI {
	
	@GetMapping("/inventory")
	public List<Product> allProductInventory(){	
		return null;		
	}
	
	@GetMapping("/inventory/{productId}")
	public List<Product> getInventoryProductById(@PathVariable String productId){	
		return null;		
	}
	
	@GetMapping("/inventory/{category}")
	public List<Product> getInventoryProductByCategory(@PathVariable String category){	
		return null;		
	}
	
	@PostMapping("/inventory")
	public void addProducts(@RequestBody Product product){	
	}
	
	@PutMapping("/inventory/{productId}")
	public void updateProduct(@RequestBody Product product,@PathVariable String productId){
		
	}
	
	@DeleteMapping("/inventory")
	public void deleteProduct(@RequestBody Product product){	
	}	
	
}
