package com.publicissapient.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.catalog.dto.Product;
import com.publicissapient.catalog.dto.ProductList;
import com.publicissapient.catalog.service.CatalogService;

@RestController
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	

	@RequestMapping("/catalog/category/{category}")
	public ProductList getInventoryProductByCategory(@PathVariable String category){	
		return catalogService.getInventoryProductByCategory(category);		
	}
	
	@RequestMapping("/catalog/product/{productId}")
	public Product getInventoryProductById(@PathVariable String productId){	
		return catalogService.getInventoryProductById(productId);		
	}
	
	

}
