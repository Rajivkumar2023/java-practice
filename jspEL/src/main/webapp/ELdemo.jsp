<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>

<!--  
<h1> Welcome from JSP page.!</h1>
<form action="process.jsp">
Enter name: <input type="text" name="name"/>
<br>
<input type="submit" value="click"/>
</form>

-->


<h1>cookie using EL</h1>
<%
	Cookie ck = new Cookie("name", "Portia");
	response.addCookie(ck);

%>
<a href="process.jsp">Click me</a>
</body>
</html>