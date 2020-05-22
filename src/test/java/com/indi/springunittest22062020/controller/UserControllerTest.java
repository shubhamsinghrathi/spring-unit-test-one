package com.indi.springunittest22062020.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.indi.springunittest22062020.UserService;
import com.indi.springunittest22062020.entity.User;
import com.indi.springunittest22062020.prototype.UserPrototype;
import com.indi.springunittest22062020.rest.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void findUserByUsernameTest() {
		User u = UserPrototype.testUser();
		Mockito.when(userService.findByUsername(u.getUsername())).thenReturn(u);
		assertEquals(u.getName(), userController.findUserByUsername(u.getUsername()).getName());
	}
	
}
