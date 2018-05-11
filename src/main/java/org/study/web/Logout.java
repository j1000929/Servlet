package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.User;

@WebServlet("/LogoutServlet")
public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user != null) {
			
			session.invalidate();
			//request.setAttribute("name", user.getId());
			response.sendRedirect("/index.jsp");
			
			return;
		}else {
		request.setAttribute("error", "먼저 로그인을 하셔야합니다.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
