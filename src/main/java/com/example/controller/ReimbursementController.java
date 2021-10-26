package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ReimbursementDaoImpl;
import com.example.model.Reimbursement;
import com.example.service.ReimbursementService;
import com.fasterxml.jackson.core.JsonProcessingException;


public class ReimbursementController {
	
	ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
	
	
	public void insert(HttpServletRequest req) throws JsonProcessingException, IOException
	{
		System.out.println("in reimbController");
		
		
		
		
		ReimbursementService rServ = new ReimbursementService();
		Reimbursement reimb = new Reimbursement();
		
		int rId = Integer.parseInt(req.getParameter("id"));
		reimb.setReimbAuthor(rId);
		
		double rAmount = Double.parseDouble(req.getParameter("amount"));
		reimb.setReimbAmount(rAmount);
		
		reimb.setReimbDescription(req.getParameter("description"));
		
		int rType = Integer.parseInt(req.getParameter("type"));
		reimb.setReimbType(rType);
		
		rServ.submitReimbursement(reimb);		
	}
	
	public List<Reimbursement> getAllReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		ReimbursementService rServ = new ReimbursementService();
		
		List<Reimbursement> rList = rServ.getAllReimbursements();
		return rList;
	}
}


