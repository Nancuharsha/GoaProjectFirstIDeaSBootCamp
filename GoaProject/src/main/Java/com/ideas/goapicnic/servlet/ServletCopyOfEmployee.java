package com.ideas.goapicnic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideas.goapicnic.Employee;
import com.ideas.goapicnic.exception.ExceptionHandingClass;
import com.ideas.goapicnic.services.EmployeeService;

/**
 * Servlet implementation class ServletForEmployee
 */
public class ServletCopyOfEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCopyOfEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		List<Employee> employeeList = new ArrayList<Employee>();
		/*String employeeSearchString = request.getParameter("searchString");*/
		//String id=request.getParameter("id");
		
		try {
			employeeList = service.searchByName(request.getParameter("searchString"));
			request.setAttribute("employeeList", employeeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionHandingClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append(employeeList.toString());
		//RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AllEmployees.jsp");
		//dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
