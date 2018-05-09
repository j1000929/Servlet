<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${error}<!-- Loing.java에서 request.serAttribute()한 key(error)의 value("당신의 아이디/비밀번호가 맞지 않습니다.")가 출력된다.  -->

	<form action="LoginServlet" method="post">  
		Id:<input type="text" name="id"><br>  
		Password:<input type="password" name="password"><br>  
		<input type="submit" value="login">  
	</form>  
</body>
</html>