package com.company.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// Import your UserDao interface and its implementation
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("unused")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Initialize the UserDao
	private static UserDao userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve username and password from the request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Validate the user
		if(userDao.isValidUser(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		} 
		else {
			response.sendRedirect("login.jsp?error=1");
			System.out.println("Login Failed !");
		}
	}
}
