package com.indi.springunittest22062020.controller;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.indi.springunittest22062020.UserService;
import com.indi.springunittest22062020.entity.User;
import com.indi.springunittest22062020.prototype.UserPrototype;
import com.indi.springunittest22062020.rest.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void findUserByUsernameTest() {
		User u = UserPrototype.testUser();
		Mockito.when(userService.findByUsername(u.getUsername())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/" + u.getUsername())
				.accept(MediaType.APPLICATION_JSON);
		try {
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			JSONAssert.assertEquals(UserPrototype.expectedStr(), result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			fail("Error received when calling /api/{username} API");
		}
	}

}
