package com.accenture.sabyasachi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sabyasachi.model.User;
import com.accenture.sabyasachi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	/* Saves the student entity into H2 database */
	public Object save(final User user) {
		repository.save(user);
		return user;
	}

}
