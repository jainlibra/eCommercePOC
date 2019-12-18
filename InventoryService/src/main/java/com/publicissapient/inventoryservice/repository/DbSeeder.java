package com.publicissapient.inventoryservice.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.publicissapient.inventoryservice.dto.Product;

@Component
public class DbSeeder implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product book1 = new Product(
				"BK-001",
				"IMMORTALS OF MELUHA",
				"SHIVA TRILOGY PART 1",
				"Book",
				"300.00",
				20);
		
		//drop All Collections
		this.productRepository.deleteAll();
		
		List<Product> initialList = Arrays.asList(book1);
		this.productRepository.saveAll(initialList);
		
	}
	
	

}
