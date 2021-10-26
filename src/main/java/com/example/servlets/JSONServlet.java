package com.example.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSONServlet extends HttpServlet
{
	JSONDispatcher jDispatch = new JSONDispatcher();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		jDispatch.process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		jDispatch.process(req, res);
//		StringBuffer jb = new StringBuffer();
//	    String line = null;
//	    try {
//	        BufferedReader reader = req.getReader();
//	        while ((line = reader.readLine()) != null) {
//	            jb.append(line);
//	        }
//	    } catch (Exception e) { /*report an error*/ }

	    
	}
}
