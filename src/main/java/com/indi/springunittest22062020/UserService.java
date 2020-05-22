package com.indi.springunittest22062020;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indi.springunittest22062020.dao.UserDao;
import com.indi.springunittest22062020.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User save(User user) {
		return userDao.save(user);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
}
