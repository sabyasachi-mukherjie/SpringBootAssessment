package com.accenture.sabyasachi.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sabyasachi.model.User;
import com.accenture.sabyasachi.service.UserService;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService service;

	/* Update the incoming student request to H2 database */
	@PutMapping(value = "/user/save")
	public Object update(final @RequestBody @Valid User user) {
		log.info("Updating student details in the database.");
		return service.update(user);
	}

}
