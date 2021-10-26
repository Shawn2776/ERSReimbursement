package com.example.eval.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.UserDaoImpl;
import com.example.model.User;
import com.example.service.UserService;

public class UserServiceTest
{
	@Mock // Mocks the uDao class and controller outputs of its methods without triggering the logic 
	private UserDaoImpl uDao;
	private UserService uServ;
	private User testUser;
	
	@BeforeEach
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this); // creates the instance of the classes that are marked with the @Mock annotation
		uServ = new UserService(uDao);
		testUser = new User(1, "jdoe", "P4ssw0rd", "John", "Doe", "jdoe@jdeere.com", 1);
		when(uDao.getByUsername("jdoe")).thenReturn(testUser); // controlling output of the getByUsername method, and logic never executes
	}
	
	@Test
	public void testGetUserSuccess()
	{
		assertEquals(uServ.getUserByUsername("jdoe"), testUser);
	}
	
	@Test
	public void testGetUserFailure()
	{
		assertThrows(NullPointerException.class, ()->uServ.getUserByUsername("jankijfojfwjefwfepojwef"));
	}
}