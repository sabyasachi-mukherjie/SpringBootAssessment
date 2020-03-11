package com.accenture.sabyasachi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sabyasachi.model.User;
import com.accenture.sabyasachi.service.UserService;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService service;

	/* Save the incoming student request to H2 database */
	@PostMapping(value = "/user/save")
	public Object save(final @RequestBody @Valid User user) {
		log.info("Saving student details in the database.");
		return service.save(user);
	}

	/* Get all the student records saved so far in H2 database */
	@GetMapping(value = "/student/getall", produces = "application/vnd.jcg.api.v1+json")
	public List<User> getAll() {
		log.info("Getting student details from the database.");
		return service.getAll();
	}
}
