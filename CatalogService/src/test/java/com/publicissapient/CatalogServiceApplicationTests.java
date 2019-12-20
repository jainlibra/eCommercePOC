package com.publicissapient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.publicissapient.catalog.controller.CatalogController;
import com.publicissapient.catalog.dto.Product;
import com.publicissapient.catalog.dto.ProductList;
import com.publicissapient.catalog.service.CatalogService;

@RunWith(MockitoJUnitRunner.class) 
class CatalogServiceApplicationTests {

	@Mock
	private CatalogService catalogService;
	
	@Mock
	private CatalogController catalogController;
	
	/*
	 * @Before public void setupMock() { catalogService =
	 * mock(CatalogService.class); catalogController =
	 * mock(CatalogController.class); }
	 */
	
	  @Before 
	  public void init() { 
		  MockitoAnnotations.initMocks(this); 
	  }
	 
	
	@Test
	public void testFindAll() 
    {
        // give
        Product product1 = new Product("1", "alexa", "assitant device", "entertainment", "8000",10);
        Product product2 = new Product("2", "bluetooth speaker", "music device", "entertainment", "5000",5);
        ProductList products = new ProductList();
        products.setProducts(Arrays.asList(product1,product2));
        String category="entertainment";
        when(catalogService.getInventoryProductByCategory(category)).thenReturn(products);
 
        
 
        // when
        ProductList result = catalogController.getInventoryProductByCategory(category);
 
        // then
        assertThat(result.getProducts().size()).isEqualTo(2); 
         
        assertThat(result.getProducts().get(0).getProductName())
                        .isEqualTo(product1.getProductName());
         
        assertThat(result.getProducts().get(1).getProductName())
                       .isEqualTo(product2.getProductName());
    }

}
