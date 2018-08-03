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
import com.ideas.goapicnic.Preferences;
import com.ideas.goapicnic.exception.ExceptionHandingClass;
import com.ideas.goapicnic.services.EmployeeService;
import com.ideas.goapicnic.services.PreferenceServices;

/**
 * Servlet implementation class ServletForEmployee
 */
public class ServletForEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service = new EmployeeService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		/*
		 * System.out.println(); System.out.println("In doget");
		 * System.out.println();
		 */
		if (request.getParameter("phoneString") != null) {
			EmployeeService service = new EmployeeService();
			List<Employee> employeeList = new ArrayList<Employee>();
			try {
				employeeList = service.searchByPhone(request.getParameter("phoneString"));
				request.setAttribute("employeeList", employeeList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionHandingClass e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.getWriter().append(employeeList.toString());
		} else if (request.getParameter("searchString") != null) {
			String testing = request.getParameter("searchString");
			if (testing.length() > 1 && testing.length() <= 5 && isnum(testing)) {
				EmployeeService service = new EmployeeService();
				List<Employee> employeeList = new ArrayList<Employee>();
				try {
					employeeList = (List<Employee>) service
							.searchById(Integer.valueOf(request.getParameter("searchString")));
					request.setAttribute("employeeList", employeeList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExceptionHandingClass e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				response.getWriter().append(employeeList.toString());
			} else {
				/*
				 * System.out.println(); System.out.println("In searchstring");
				 * System.out.println();
				 */
				// String id=request.getParameter("id");
				EmployeeService service = new EmployeeService();
				List<Employee> employeeList = new ArrayList<Employee>();
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
			}
		} else {
			/*
			 * System.out.println(); System.out.println("In allemployee");
			 * System.out.println();
			 */
			PrintWriter out = response.getWriter();
			// String id=request.getParameter("id");
			EmployeeService service = new EmployeeService();
			try {
				request.setAttribute("employeeList", service.getAllEmployee());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionHandingClass e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllEmployees.jsp");
			dispatcher.forward(request, response);
		}
	}

	private boolean isnum(String testing) {
		// TODO Auto-generated method stub
		for (int i = 0; i < testing.length(); i++) {
			if (!(testing.charAt(i) >= '0' && testing.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("delete".equals(request.getParameter("action"))) {

			Integer employeeCompID = Integer.valueOf(request.getParameter("employeeCompId"));

			try {
				service.deleteById(employeeCompID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionHandingClass e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Integer employeeCompID = Integer.valueOf(request.getParameter("companyEmpId"));
			String empName = request.getParameter("empName");
			String empContactNum = request.getParameter("empContactNum");
			String department = (request.getParameter("Department").equals("NULL")) ? null
					: request.getParameter("Department");
			// System.out.println(request.getParameter("Department") +"
			// "+department);

			try {
				Employee empObj = new Employee(empName, null, employeeCompID, empContactNum, department);
				service.insertIntoDBEmpTable(empObj);
			} catch (ExceptionHandingClass e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// request.setAttribute("employeeID",employeeID );

		doGet(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("In doDelete");
		System.out.println();
		Integer employeeCompID = Integer.valueOf(request.getParameter("employeeCompId"));

		try {
			service.deleteById(employeeCompID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionHandingClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);

	}

}
