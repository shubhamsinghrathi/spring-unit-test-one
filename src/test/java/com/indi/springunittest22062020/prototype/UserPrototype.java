package com.indi.springunittest22062020.prototype;

import com.indi.springunittest22062020.entity.User;

public class UserPrototype {
	
	public static User testUser() {
		User user = new User();
//		user.setId(1);
		user.setName("Mr. Test");
		user.setUsername("mr_test");
		return user;
	}
	
}
