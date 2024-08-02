<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<body>
<%
    // Retrieve the session object
    HttpSession session1 = request.getSession(false);
	if(session1 != null){
		session1.invalidate();
        // Redirect to the login page if the session is not valid
        response.sendRedirect("index.html");
    }
%>
</body>
</html>
