<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/link.html" flush="false"></jsp:include><!-- link.html은 루트에 있다. -->
	<h1>Welcome, ${profile.name}</h1>  
	<h3>Profile</h3>
	<h4>${profile.desc}</h4>
</body>
</html>