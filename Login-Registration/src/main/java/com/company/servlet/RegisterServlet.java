package com.company.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
import com.company.dao.User;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register") // Add a mapping for the servlet if not already done
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();
       
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the parameters from the request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		// Create a new user object and set its properties
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		// Use the userDao to add the user
		if(userDao.addUser(user)) {
			response.sendRedirect("login.jsp?registration=successful");
		} else {
			response.sendRedirect("register.jsp?error=1");
		}
	}
}
