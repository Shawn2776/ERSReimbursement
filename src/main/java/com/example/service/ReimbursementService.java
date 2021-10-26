package com.example.service;



import java.util.List;

import com.example.dao.ReimbursementDaoImpl;
import com.example.model.Reimbursement;



public class ReimbursementService
{

private ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
	
	public ReimbursementService()
	{
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementService(ReimbursementDaoImpl uDao)
	{
		super();
		this.rDao = rDao;
	}
	
	public void submitReimbursement(Reimbursement reimb){
		
		rDao.insert(reimb);
		
	}
	
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> rList = rDao.getAll();
		System.out.println(rList);
		return rList;
	}
	
}