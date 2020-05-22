package com.indi.springunittest22062020.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indi.springunittest22062020.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public User save(User user) {
		entityManager.persist(user);
		return user;
	}
	
	@Transactional
	public User findByUsername(String username) {
		Query query = entityManager.createQuery("from User where username=:username", User.class);
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}
	
}
