package com.indi.springunittest22062020.prototype;

import com.indi.springunittest22062020.entity.User;

public class UserPrototype {
	
	public static User testUser() {
		User user = new User();
		user.setName("Mr. Test");
		user.setUsername("mr_test");
		return user;
	}
	
	public static String expectedStr() {
		return "{\"id\":0,\"name\":\"Mr. Test\",\"username\":\"mr_test\"}";
	}
	
	public static User testUser2() {
		User user = new User();
		user.setName("Mr. Test 2");
		user.setUsername("mr_test_2");
		return user;
	}
	
	public static String expectedStrTwo() {
		return "{\"id\":1,\"name\":\"Mr. Test 2\",\"username\":\"mr_test_2\"}";
	}
	
}
