package com.example.servlets;

import javax.servlet.http.HttpServletRequest;

import com.example.controller.ReimbursementController;
import com.example.controller.UserController;
import com.example.dao.ReimbursementDaoImpl;
import com.example.model.Reimbursement;
import com.example.service.ReimbursementService;

public class ViewDispatcher // Called by the View Servlet. Filters URI of the req, to determine which controller to call
							// and return a string that changes the view of the user
{
	UserController uControl = new UserController();
	Reimbursement reimb = new Reimbursement();
	ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
	ReimbursementController rControl = new ReimbursementController();
	ReimbursementService rServ = new ReimbursementService();
	
	public String process(HttpServletRequest req)
	{
		switch (req.getRequestURI())
		{
			case "/ERSReimbursement/login.change":
				System.out.println("In login.change dispatcher");
				return uControl.login(req);
				
			case "/ERSReimbursement/logout.change":
				System.out.println("In logout chnage, for some rason");
				return uControl.logout(req);
		
			default:
				System.out.println("In default");
				return "html/unsuccessfullogin.html";
		}
	}
}
