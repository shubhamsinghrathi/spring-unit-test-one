package com.indi.springunittest22062020;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.indi.springunittest22062020.entity.User;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		User u = userService.findByUsername("mr_test_2");
		if (u != null) return;
		User user = new User();
		user.setName("Mr. Test 2");
		user.setUsername("mr_test_2");
		userService.save(user);
	}

}
