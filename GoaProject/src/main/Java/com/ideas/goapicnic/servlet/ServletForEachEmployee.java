package com.ideas.goapicnic.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class ServletForEachEmployee
 */
public class ServletForEachEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForEachEmployee() {
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
		EmployeeService service = new EmployeeService();
		PreferenceServices preference = new PreferenceServices();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EachEmployeeDetails.jsp");
		int employeeID = Integer.valueOf(request.getParameter("employeeId"));
		try {
			request.setAttribute("employee", service.getById(employeeID));
			request.setAttribute("preference", preference.fetchPreferenceByEmpId(employeeID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionHandingClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
		// dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer employeeID = Integer.valueOf(request.getParameter("employeeId"));
		if ("deleteprefrences".equals(request.getParameter("action"))) {
			/*
			 * System.out.println(); System.out.println("In delete do post");
			 * System.out.println();
			 */
			PreferenceServices preferenceService = new PreferenceServices();
			try {
				preferenceService.deletePreferenceById(employeeID);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionHandingClass e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("updateemployee".equals(request.getParameter("action"))) {
			/*
			 * System.out.println(); System.out.println("Inupdate");
			 * System.out.println();
			 */
			Integer employeeid = Integer.valueOf(request.getParameter("empId"));
			Integer employeeCompID = Integer.valueOf(request.getParameter("companyEmpId"));
			String empName = request.getParameter("empName");
			String empContactNum = request.getParameter("empContactNum");
			String department = (request.getParameter("Department").equals("NULL")) ? null
					: request.getParameter("Department");
			EmployeeService service = new EmployeeService();

			try {
				Employee empObj = new Employee(empName, employeeid, employeeCompID, empContactNum, department);
				service.updateEmpObjIntoDB(empObj);
			} catch (ExceptionHandingClass e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("updateprefrences".equals(request.getParameter("action"))) {
			String picnicBatch = request.getParameter("picnicBatch");
			String modeOfTravelOnward = request.getParameter("modeOfTravelOnward");
			String modeOfTravelReturn = request.getParameter("modeOfTravelReturn");
			String gender = request.getParameter("gender");
			String setOfFamily = request.getParameter("setOfFamily");
			Integer totalFamilyCount = Integer.valueOf(request.getParameter("totalFamilyCount"));
			try {
				Preferences preference = new Preferences(null, employeeID, picnicBatch, modeOfTravelOnward,
						modeOfTravelReturn, gender, setOfFamily, totalFamilyCount);
				PreferenceServices preferenceService = new PreferenceServices();
				preferenceService.updatePreference(preference);
			} catch (ExceptionHandingClass e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			String picnicBatch = request.getParameter("picnicBatch");
			String modeOfTravelOnward = request.getParameter("modeOfTravelOnward");
			String modeOfTravelReturn = request.getParameter("modeOfTravelReturn");
			String gender = request.getParameter("gender");
			String setOfFamily = request.getParameter("setOfFamily");
			Integer totalFamilyCount = Integer.valueOf(request.getParameter("totalFamilyCount"));

			try {
				Preferences preference = new Preferences(null, employeeID, picnicBatch, modeOfTravelOnward,
						modeOfTravelReturn, gender, setOfFamily, totalFamilyCount);
				PreferenceServices preferenceService = new PreferenceServices();
				preferenceService.insertPreference(preference);
			} catch (ExceptionHandingClass e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("employeeID", employeeID);
		doGet(request, response);
	}

}
