package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;

public class UserDaoImpl implements GenericDao<User>
{
	private ERSDBConnection ersCon = new ERSDBConnection();

	
	
	public UserDaoImpl()
	{
		// TODO Auto-Generated constructor stub
	}
	
	public UserDaoImpl(ERSDBConnection ersCon)
	{
		this.ersCon = ersCon;
	}

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<>();
		
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "select * from ers_user";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
				
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public User getById(int id)
	{
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "select * from ers_users eu where eu.ers_users_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			User newuser = new User();
			
			while (rs.next())
			{
				newuser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			
			return newuser;
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getByUsername(String username)
	{
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "select * from ers_users eu where eu.ers_username = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			User newuser = new User();
			
			while (rs.next())
			{
				newuser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			
			return newuser;
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(User entity) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(User entity)
	{
		try (Connection con = ersCon.getDBConnection())
		{
			String sql = "{? = call insert_ers_user(?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, entity.getUsername());
			cs.setString(3, entity.getPassword());
			cs.setString(4, entity.getFirstName());
			cs.setString(5, entity.getLastName());
			cs.setString(6, entity.getEmail());
			cs.setInt(7, entity.getRoleId());
			cs.execute();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	

}
