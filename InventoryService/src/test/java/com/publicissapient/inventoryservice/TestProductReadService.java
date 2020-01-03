package com.publicissapient.inventoryservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.publicissapient.inventoryservice.dto.Product;
import com.publicissapient.inventoryservice.repository.ProductReadRepository;
import com.publicissapient.inventoryservice.service.ProductReadService;

@RunWith(MockitoJUnitRunner.class)
public class TestProductReadService {
	
	@InjectMocks
	ProductReadService productReadService;
	
	@Mock
	ProductReadRepository productReadRepository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	
	@Test
    public void allProductInventoryTest()
    {
        List<Product> productList = new ArrayList<>();
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
         
		productList.add(mobile1);
		productList.add(mobile2);
                
        when(productReadRepository.findAll()).thenReturn(productList);
         
        //test
        List<Product> prdList = productReadService.allProductInventory();
         
        assertEquals(2, prdList.size());
        verify(productReadRepository, times(1)).findAll();
    }
	
	@Test
    public void productByIdTest()
    {
		Product mobile1 = new Product(
				"ML-001",
				"ONEPLUS 7T",
				"ONEPLUS PHONES",
				"Mobile",
				"35000.00",
				20);
		
		Optional<Product> prodOptional = Optional.of(mobile1);
	   
                
        when(productReadRepository.findById("ML-001")).thenReturn(prodOptional);
         
        //test
        Product product = productReadService.getInventoryProductById("ML-001");
        
        assertEquals("ONEPLUS 7T", product.getProductName());
        assertEquals("ONEPLUS PHONES", product.getProductDescription());
        assertEquals("Mobile", product.getCategory());       
    }

}
