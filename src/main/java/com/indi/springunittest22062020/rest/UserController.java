package com.indi.springunittest22062020.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indi.springunittest22062020.UserService;
import com.indi.springunittest22062020.entity.User;
import com.indi.springunittest22062020.model.UserBody;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public User saveUser(@RequestBody UserBody u) {
		User user = new User();
		user.setName(u.getName());
		user.setUsername(u.getUsername());
		userService.save(user);
		return user;
	}
	
	@GetMapping("{username}")
	public User findUserByUsername(@PathVariable String username) {
		User user = userService.findByUsername(username);
		return user;
	}
	
}
