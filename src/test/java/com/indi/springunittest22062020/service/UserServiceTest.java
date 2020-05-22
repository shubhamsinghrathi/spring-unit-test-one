package com.indi.springunittest22062020.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.indi.springunittest22062020.UserService;
import com.indi.springunittest22062020.dao.UserDao;
import com.indi.springunittest22062020.prototype.UserPrototype;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserDao userDao;

	@Test
	public void getUserByUsernameTest() {
		Mockito.when(userDao.findByUsername(UserPrototype.testUser().getUsername()))
				.thenReturn(UserPrototype.testUser());
		assertEquals(UserPrototype.testUser().getName(),
				userService.findByUsername(UserPrototype.testUser().getUsername()).getName());
	}

}
