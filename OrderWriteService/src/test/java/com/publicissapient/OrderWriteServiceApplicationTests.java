package com.publicissapient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicissapient.DAO.OrderDAO;
import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.controller.OrderController;
import com.publicissapient.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderWriteServiceApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private OrderService orderService;

	@MockBean
	private OrderDAO orderDAO;

	@Test
	public void createOrder() throws Exception {

		ObjectMapper obj = new ObjectMapper();

		
		//Order order=Order.builder().orderId(1).itemId("123").skuId("12345").status("confirmed").quantity("4").userId("3").build();
		/*
		 * //Order order = new Order(10, "122", "1235", "draft", "4", "1"); String
		 * writeValueAsString = obj.writeValueAsString(order);
		 * 
		 * MockHttpServletResponse response = mvc
		 * .perform(post("/order/add").contentType(MediaType.APPLICATION_JSON).content(
		 * writeValueAsString)) .andReturn().getResponse();
		 * 
		 * assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		 */

	}

}
