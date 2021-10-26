package com.example.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.ReimbursementController;
import com.example.controller.UserController;
import com.example.dao.ReimbursementDaoImpl;
import com.example.model.Reimbursement;
import com.example.model.User;
import com.example.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONDispatcher
{
	UserController uControl = new UserController();
	ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
	ReimbursementController rControl = new ReimbursementController();
	ReimbursementService rServ = new ReimbursementService();
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("class: " + req.getClass());
		switch (req.getRequestURI())
		{
		case "/ERSReimbursement/getsessionuser.json":
			uControl.getSessionUser(req, res);
			break;
			
		case "/ERSReimbursement/sub.json":
			System.out.println("In json dispatcher");
			rControl.insert(req);
			break;
			
		case "/ERSReimbursement/allReimbursements.json":
			rControl.getAllReimbursements(req, res);
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(new ArrayList<Reimbursement>()));
			
			System.out.println("in json get all");
			break;
			
		default:
			res.getWriter().write(new ObjectMapper().writeValueAsString(new User()));
		}
	}
	
	
	
}
