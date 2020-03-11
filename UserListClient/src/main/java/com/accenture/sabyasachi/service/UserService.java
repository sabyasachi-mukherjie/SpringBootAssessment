package com.accenture.sabyasachi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.accenture.sabyasachi.model.User;
import com.accenture.sabyasachi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserService() {
		// Default Constructor
	}

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	/* Gets all the student entities saved so far from H2 database */
	public List<User> getAll(String columns, String records, String pageNo) {
		final List<User> users = new ArrayList<>();
		repository.findAll().forEach(user -> users.add(user));
		return modifyResult(columns, records, pageNo, users);
	}

	private List<User> modifyResult(String columns, String records, String pageNo, List<User> users) {
		List<User> modifiedUsers = new ArrayList<User>();
		if (StringUtils.isEmpty(records) || StringUtils.isEmpty(pageNo)) {
			modifiedUsers = users;
		} else {
			modifiedUsers = users.subList(Integer.parseInt(records) * (Integer.parseInt(pageNo) - 1),
					Integer.parseInt(pageNo) * Integer.parseInt(records));
		}
		List<String> fields = new ArrayList<String>();
		fields.add("firstname");
		fields.add("lastname");
		fields.add("email");
		fields.add("address");
		fields.add("telephone");
		List<String> columnsNeeded = new ArrayList<String>();
		if (columns != null) {
			columnsNeeded = Arrays.asList(columns.split(","));
		}
		fields.removeAll(columnsNeeded);
		for (String removeColumn : fields) {
			switch (removeColumn) {
			case "firstname":
				for (User user : modifiedUsers) {
					user.setFirstNm(null);
				}
				break;

			case "lastname":
				for (User user : modifiedUsers) {
					user.setLastNm(null);
				}
				break;
			case "email":
				for (User user : modifiedUsers) {
					user.setEmail(null);
				}
				break;
			case "telephone":
				for (User user : modifiedUsers) {
					user.setTelephone(null);
				}
				break;
			case "address":
				for (User user : modifiedUsers) {
					user.setAddress(null);
				}
				break;
			}
		}
		return modifiedUsers;
	}

}
