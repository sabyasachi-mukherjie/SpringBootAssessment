package com.accenture.sabyasachi.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.accenture.sabyasachi.repository.UserRepository;

public class UserListServiceTest {

	private UserRepository repository;
	private UserService service;

	@BeforeAll
	public static void testStart() {
		// Do some operation here before test class execution begins
	}

	@BeforeEach
	void beforeEachTest() {
		repository = mock(UserRepository.class);
		service = new UserService(repository);
	}

	@Test
	public void userList() {
		assertNotEquals(service.getAll("firstName,lastName", "10", "2"), null);
	}

	@AfterAll
	public static void testEnd() {
		// Do some operation here before test class exit
	}
}
