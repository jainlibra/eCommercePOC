package com.publicissapient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
import com.publicissapient.DAO.pojo.Order;
import com.publicissapient.controller.OrderController;
import com.publicissapient.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
class OrderServiceApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private OrderService orderService;

	@Test
	public void canRetrieveByIdWhenExists() throws Exception {
		ObjectMapper obj = new ObjectMapper();

		when(orderService.getOrderByOrderId(2))
				.thenReturn(obj.writeValueAsString(new Order(2, "122", "1235", "draft", "4", "1")));
		MockHttpServletResponse response = mvc.perform(get("/order/bucket/2").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		System.out.println(response.getContentAsString());

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString())
				.isEqualTo(obj.writeValueAsString(new Order(2, "122", "1235", "draft", "4", "1")));
	}

}
