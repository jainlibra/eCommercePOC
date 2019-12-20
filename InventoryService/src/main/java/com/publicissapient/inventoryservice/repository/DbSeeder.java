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
	ProductWriteRepository productWriteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product book1 = new Product(
				"BK-001",
				"IMMORTALS OF MELUHA",
				"SHIVA TRILOGY PART 1",
				"Book",
				"300.00",
				20);
		
		Product book2 = new Product(
				"BK-002",
				"SECRETS OF NAGA",
				"SHIVA TRILOGY PART 2",
				"Book",
				"300.00",
				20);
		
		Product book3 = new Product(
				"BK-003",
				"OATH OF VAYUPUTRAS",
				"SHIVA TRILOGY PART 2",
				"Book",
				"300.00",
				20);
		
		Product mobile1 = new Product(
				"ML-001",
				"ONEPLUS 7T",
				"ONEPLUS PHONES",
				"Mobile",
				"35000.00",
				20);
		
		Product mobile2 = new Product(
				"ML-002",
				"iPHONE 11",
				"APPLE MOBILE PHONES",
				"Mobile",
				"50000.00",
				20);
		
		Product mobile3 = new Product(
				"ML-003",
				"VIVO 11 PRO",
				"VIVO MOBILE PHONES",
				"Mobile",
				"15000.00",
				20);
		
		//drop All Collections
		this.productWriteRepository.deleteAll();
		
		List<Product> initialList = Arrays.asList(book1,book2,book3,mobile1,mobile2,mobile3);
		this.productWriteRepository.saveAll(initialList);
		
	}
	
	

}
