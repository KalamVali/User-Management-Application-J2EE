package com.servlet.saveuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the request data
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		
		UserDao dao = new UserDao();
		boolean status = dao.loginUser(userId, userEmail);
		
		//set the data to jsp
		request.setAttribute("status", status);
		
		//Forward the request to jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginstatus.jsp");
		dispatcher.forward(request, response);
	}

}
