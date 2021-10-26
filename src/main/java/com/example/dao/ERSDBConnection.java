package com.example.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ERSDBConnection
{
	// This utility class has the sole purpose of creating connections to the db.
	// This helps with eliminating repeated code. Also makes code more testable.
	
	ClassLoader classLoader = getClass().getClassLoader();
	InputStream is;
	Properties p = new Properties();
	
	public ERSDBConnection() {
		is = classLoader.getResourceAsStream("connection.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getDBConnection() throws SQLException
	{
		final String URL = p.getProperty("url");
		final String USERNAME = p.getProperty("username");
		final String PASSWORD = p.getProperty("password");
		try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("whyyyyyyyyyy");
        }
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
}
