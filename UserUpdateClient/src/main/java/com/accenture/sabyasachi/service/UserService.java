package com.accenture.sabyasachi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sabyasachi.model.User;
import com.accenture.sabyasachi.model.UserEntity;
import com.accenture.sabyasachi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	/* Saves the student entity into H2 database */
	public Object save(final User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		repository.save(userEntity);
		user.setEmplId(userEntity.getEmplId());
		return user;
	}

	/* Updates the student entity into H2 database */
	public Object update(final User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		Optional<UserEntity> existingStudent = repository.findById(userEntity.getEmplId());
		if (existingStudent.isPresent()) {
			save(user);
			return user;
		}
		return "No student record found for update in DB";
	}
}
