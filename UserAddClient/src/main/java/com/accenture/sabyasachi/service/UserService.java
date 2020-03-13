package com.accenture.sabyasachi.service;

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

}
