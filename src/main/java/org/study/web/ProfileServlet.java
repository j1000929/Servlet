package org.study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.Profile;
import org.study.dao.UserService;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService service = new UserService();
		Cookie[] cookies = request.getCookies();
		
	
		// 로그인 안된사람.
		if(cookies == null) {
			request.setAttribute("error","먼저 로그인을 하셔야 합니다.");
			request.getRequestDispatcher("login.jsp").include(request, response);
			
			return;
		}
		
		//쿠키가 있으면(로그인되어있으면)
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
				Profile profile = service.getProfile(cookies[i].getValue());
				request.setAttribute("profile", profile);
				request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
				
				return;
			}
			
			System.out.println("Error: Never see....");
		}
		
		
	}



}
