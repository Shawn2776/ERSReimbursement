package com.example.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Reimbursement;


public class ReimbursementDaoImpl implements GenericDao<Reimbursement>
{
	private ERSDBConnection ersCon = new ERSDBConnection();
	
	public ReimbursementDaoImpl()
	{
		// TODO Auto-Generated constructor stub
	}
	
	public ReimbursementDaoImpl(ERSDBConnection ersCon)
	{
		this.ersCon = ersCon;
	}
	
	public List<Reimbursement> getReimbursementByUserid(int userid)
	{
		List<Reimbursement> reimbList = new ArrayList<>();
		
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "select * from ers_reimbursement er left join ers_reimbursement_type ert on er.reimb_type = ert.reimb_type_id left join ers_reimbursement_status ers on ers.reimb_status_id = er.reimb_status where er.reimb_author = ?;";
			PreparedStatement ps = con.prepareCall(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				reimbList.add(new Reimbursement(rs.getInt(1), rs.getInt(8), rs.getInt(9), rs.getString(5), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(6)));
				// reimb = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			}
			
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return reimbList;
	}

	
	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "select er.reimb_id reimbursement_id, eu.ers_users_id employee_id, eu.user_first_name first_name, eu.user_last_name last_name,"
					+ " eu.user_email email, ert.reimb_type R_TYPE, er.reimb_amount amount, er.reimb_description, ers.reimb_status R_STATUS, er.reimb_submitted"
					+ " submitted, er.reimb_resolved reviewed, er.reimb_resolver from ers_reimbursement er left outer join ers_users eu on eu.ers_users_id = er.reimb_author"
					+ " left outer join ers_reimbursement_type ert on er.reimb_type = ert.reimb_type_id left outer join ers_reimbursement_status ers on ers.reimb_status_id = er.reimb_status;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				reimbursementList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getTimestamp(10), rs.getTimestamp(11), rs.getInt(12)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return reimbursementList;
	}
	
	@Override
	public Reimbursement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Reimbursement entity) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void insert(Reimbursement t) {
//		try(Connection con = ersCon.getDBConnection()){
//			
//			
//			
//			String sql = "{? = call insert_ers_reimbursement(?,?,?,?,?)}";
//			CallableStatement cs = con.prepareCall(sql);
//			cs.registerOutParameter(1, Types.VARCHAR);
//			cs.setDouble(2, t.getReimbAmount());
//			cs.setString(3, t.getReimbDescription());
//			cs.setInt(4, t.getReimbAuthor());
//			cs.setInt(5, t.getReimbType());
//			
//			System.out.println(cs.getString(3));
//			
//			cs.execute();
//				
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@Override
	public void insert(Reimbursement t)
	{
		System.out.println("in rDao");
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_type) values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, t.getReimbAmount());
			ps.setString(2, t.getReimbDescription());
			ps.setInt(3, t.getReimbAuthor());
			ps.setInt(4, t.getReimbType());
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Reimbursement entity) {
		// TODO Auto-generated method stub
		
	}	

}
