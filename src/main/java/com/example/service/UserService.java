package com.example.service;

import com.example.dao.UserDaoImpl;
import com.example.model.User;

public class UserService
{
	private UserDaoImpl uDao = new UserDaoImpl();
	
	public UserService()
	{
		// TODO Auto-generated constructor stub
	}
	
	public UserService(UserDaoImpl uDao)
	{
		super();
		this.uDao = uDao;
	}
	
	public User getUserByUsername(String username)
	{
		User user = uDao.getByUsername(username);
		if (user.getUsername() == null)
		{
			throw new NullPointerException("There isn't a user with the username: + " + username);
		}
		
		return user;
	}
	
	public User getUserVerify(String username, String password)
	{
		User verifyUser = uDao.getByUsername(username);
		if (verifyUser != null)
		{
			if (verifyUser.getPassword().equals(password))
			{
				return verifyUser;
			}
			
		}
		return null;
	}
}















