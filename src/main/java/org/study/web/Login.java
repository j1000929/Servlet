package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.User;
import org.study.dao.UserService;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	
	UserService service = new UserService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html; charset=utf-8");
//		response.setCharacterEncoding("utf-8");
//		
//		PrintWriter out = response.getWriter();

		String id = request.getParameter("id"); //login.html에서 넘어 온다.
		String passwd = request.getParameter("password");//login.html에서 넘어 온다.
		
		
		User user = new User(id,passwd);
		service.isValidUser(user);
		
		if(service.isValidUser(user)) {
			Cookie cookie = new Cookie("id",id);
			request.setAttribute("name", user.getName());
			response.addCookie(cookie);
			
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")//로그인 성공시 로딩페이지
			.forward(request, response);
		}else {//로그인 실패시
			request.setAttribute("error", "당신의 아이디/비밀번화가 맞지 않습니다.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
