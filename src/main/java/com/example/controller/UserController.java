package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.ReimbursementDaoImpl;
import com.example.dao.UserDaoImpl;
import com.example.model.Reimbursement;
import com.example.model.User;
import com.example.service.ReimbursementService;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController
{
	UserService uServ = new UserService(new UserDaoImpl());
	ReimbursementService rServ = new ReimbursementService(new ReimbursementDaoImpl());
	
	public String login(HttpServletRequest req)
	{
		if (!req.getMethod().equals("POST"))
		{
			return "html/unsuccessfullogin.html";
		}
		
		User usr = uServ.getUserVerify(req.getParameter("username"), req.getParameter("password"));
		
		if (usr == null)
		{
			return "html/unsuccessfullogin.html";
		} else
		{
			req.getSession().setAttribute("currentUser", usr);
			//return "html/home.html";
			if (usr.getRoleId() == 1)
			{
				return "html/employeeHome.html";
			} else if (usr.getRoleId() == 2)
			{
				return "html/adminHome.html";
			}
			
			return "html/unsuccessfullogin.html";
		}
	}
	
	public void getSessionUser(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException
	{
		User usr = (User)req.getSession().getAttribute("currentUser"); // grabbing currentUser stored in session during login
		res.getWriter().write(new ObjectMapper().writeValueAsString(usr)); // use the res obj to send the cur user as a json to the FE
	}
	
	public String logout(HttpServletRequest req)
	{	
		HttpSession sess = req.getSession(false);
		
		if (sess != null)
		{
			sess.invalidate();
		}
		
		return "html/index.html";
			
	}
}
