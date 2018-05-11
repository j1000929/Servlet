<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="link.html" flush="false"/>

<body>
	<h1>Add New Employee</h1>

	<form action="saveServlet" method="post">  
		<table>
			<tr>
				<td>Name:</td><td><input type="text" name="name" >  </td>
			</tr>
			<tr>
				<td>Password:</td><td><input type="password" name="password" >  </td>
			</tr>
			<tr>
				<td>Email:</td><td><input type="email" name="email" >  </td>
			</tr>
			<tr>
				<td>country:</td>
				<td>
				<select name="country" style="width:150px" >
					<option>한국</option>
					<option>USA</option>
					<option>UK</option>
					<option>기타</option>
				</select> 
				 </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="직원추가"></td>
			</tr>
			
		</table>
		
	</form>  
</body>
</html>