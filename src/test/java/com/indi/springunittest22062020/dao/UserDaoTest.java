package com.indi.springunittest22062020.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.indi.springunittest22062020.entity.User;
import com.indi.springunittest22062020.prototype.UserPrototype;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	void findByUsername() {
		User user = UserPrototype.testUser();
		userDao.save(user);
		User foundUser = userDao.findByUsername(user.getUsername());
		assertNotNull(foundUser);
		assertEquals(user.getUsername(), foundUser.getUsername());
	}
	
}
