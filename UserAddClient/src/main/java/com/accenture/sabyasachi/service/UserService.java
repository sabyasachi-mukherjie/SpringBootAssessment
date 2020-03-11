package com.accenture.sabyasachi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	/* Gets all the student entities saved so far from H2 database */
	public List<User> getAll() {
		final List<User> users = new ArrayList<>();
		repository.findAll().forEach(user -> users.add(user));
		return users;
	}

	/* Updates the student entity into H2 database */
	public Object update(final User user) {
		Optional<User> existingStudent = repository.findById(user.getEmplId());
		if (existingStudent.isPresent()) {
			save(user);
			return user;
		}
		return "No student record found for update in DB";
	}
}
