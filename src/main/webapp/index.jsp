<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	Date date = new Date();
%>
</head>

<jsp:include page="link.html" flush="false"/><!-- 한글 인코딩 해결 -->
<body>
<h1>Welcome to Login App by Cookie</h1>  
	<h2>안녕하세요</h2>
	<a href="login.jsp">Login</a>|  
	<a href="LogoutServlet">Logout</a>|  
	<a href="ProfileServlet">Profile</a>  
	<footer>
	<%=date.toString() %>
	</footer>
</body>
</html>