package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.Country;
import org.study.dao.Employee;
import org.study.dao.EmployeeDaoImpl;
import org.study.dao.EmployeeService;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  private EmployeeService service = new EmployeeDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Employee e = new Employee();
	
	e.setName(request.getParameter("name"));
	e.setPassword(request.getParameter("password"));
	e.setEmail(request.getParameter("email"));

	e.setCountry(request.getParameter("country"));
	
		if(service.SaveEmployee(e)) {
			System.out.println("add Success..");
			request.getRequestDispatcher("ListServlet").forward(request, response);
		}else {//저장 실패시...
			request.setAttribute("error", "직원추가실패");
			request.getRequestDispatcher("addEmp.jsp").forward(request, response);
		}//if
	}
	
	

}
