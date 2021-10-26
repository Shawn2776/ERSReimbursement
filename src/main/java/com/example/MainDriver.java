package com.example;

import java.sql.SQLException;


import com.example.dao.ERSDBConnection;
import com.example.dao.ReimbursementDaoImpl;

import com.example.model.Reimbursement;


public class MainDriver {

	public static void main(String[] args) throws SQLException
	{
		
		ERSDBConnection ersCon = new ERSDBConnection();
		
		
		
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl(ersCon);
		
		Reimbursement reimb = new Reimbursement();
		
		reimb.setReimbAuthor(2);
		reimb.setReimbAmount(50.20);
		reimb.setReimbType(4);
		reimb.setReimbDescription("Popsicles");
//	
//		rDao.insert(reimb);
//		try
		//{
			//System.out.println(uServ.getUserByUsername("zombieapok"));	
//		}
	//	catch (NullPointerException e)
		{
		//	e.printStackTrace(); // eat 
		}
//		
//		
		
		try
		{
	
			rDao.insert(reimb);
		}
		catch (NullPointerException e)
		{
			e.printStackTrace(); // eat 
		}
	}

}