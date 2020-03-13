package com.accenture.sabyasachi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sabyasachi.model.UserEntity;
import com.accenture.sabyasachi.service.UserService;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService service;

	/* Get all the student records saved so far in H2 database */
	@GetMapping(value = "/user/getall", produces = "application/vnd.jcg.api.v1+json")
	public List<UserEntity> getAll(@RequestParam(value = "columns", required = false) String columns,
			@RequestParam(value = "number", required = false) String records,
			@RequestParam(value = "page", required = false) String pageNo) {
		log.info("You have requested to see the following fields: {} ", columns);
		log.info("Getting user details from the database for page no {} with total record numbers of {} in each page",
				pageNo, records);
		return service.getAll(columns, records, pageNo);
	}

}
