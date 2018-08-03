package com.ideas.goapicnic.services;

import com.ideas.goapicnic.dbconfig.DBConfiguration;
import com.ideas.goapicnic.exception.ExceptionHandingClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ideas.goapicnic.Employee;

class ObjectsForSearch {
	String s;
	Integer val;

	public ObjectsForSearch(String s, Integer val) {
		// TODO Auto-generated constructor stub
		this.s = s;
		this.val = val;
	}
}

class Sortbyroll implements Comparator<ObjectsForSearch> {
	// Used for sorting in ascending order of
	// roll number
	public int compare(ObjectsForSearch a, ObjectsForSearch b) {
		return a.val - b.val;
	}
}

public class EmployeeService {

	private Integer NumberOfEdit = 3;

	public void updateEmpObjIntoDB(Employee empObj) throws SQLException {
		// TODO Auto-generated method stub

		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "update Employee set NAME=?,Company_Employee_ID=?,Contact_No=?,Department=? where Employee_ID =?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setString(1, empObj.getName());
		preparedStatement.setInt(2, empObj.getEmpCompId());
		preparedStatement.setString(3, empObj.getEmpContact());
		preparedStatement.setString(4, empObj.getEmpDepartment());
		preparedStatement.setInt(5, empObj.getEmpId());
		// stmt.executeUpdate(finalSqlStatement);
		preparedStatement.executeUpdate();

	}

	public void deleteEmpObjIntoDB(Employee empObj) {
		// TODO Auto-generated method stub

	}

	public void insertIntoDBEmpTable(Employee empObj) throws SQLException {
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "INSERT INTO Employee(NAME,Company_Employee_ID,Contact_No,Department) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setString(1, empObj.getName());
		preparedStatement.setInt(2, empObj.getEmpCompId());
		preparedStatement.setString(3, empObj.getEmpContact());
		preparedStatement.setString(4, empObj.getEmpDepartment());
		// stmt.executeUpdate(finalSqlStatement);
		preparedStatement.executeUpdate();
	}

	public void clearAllFromEmployeeTable() throws Exception {
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		stmt.executeUpdate("Delete from Preferences");
		stmt.executeUpdate("delete from Employee");
	}

	public List<Employee> getAllEmployee() throws ExceptionHandingClass, SQLException {
		// TODO Auto-generated method stub
		List<Employee> listEmp = new ArrayList<Employee>();

		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		ResultSet resultTable = stmt.executeQuery("select * from Employee");
		while (resultTable.next()) {
			Employee empObj = new Employee(resultTable.getString(2), resultTable.getInt(1), resultTable.getInt(3),
					resultTable.getString(4), resultTable.getString(5));

			// System.out.println(resultTable.getString(2));
			listEmp.add(empObj);
		}
		return listEmp;
	}

	public Employee deleteByName(String name) throws ExceptionHandingClass, SQLException {
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Employee where Name = ?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setString(1, name);
		ResultSet resultTable = preparedStatement.executeQuery();
		resultTable.next();
		Employee deletedEmpObj = new Employee(resultTable.getString(2), resultTable.getInt(1), resultTable.getInt(3),
				resultTable.getString(4), resultTable.getString(5));
		finalSqlStatement = "delete from Employee where Company_Employee_ID = ?";
		preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
		return deletedEmpObj;

	}

	public Employee deleteById(Integer empId) throws SQLException, ExceptionHandingClass {
		// TODO Auto-generated method stub
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Employee where Company_Employee_ID = ?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, empId);

		ResultSet resultTable = preparedStatement.executeQuery();
		resultTable.next();
		Employee deletedEmpObj = new Employee(resultTable.getString(2), resultTable.getInt(1), resultTable.getInt(3),
				resultTable.getString(4), resultTable.getString(5));
		// System.out.println(deletedEmpObj);
		finalSqlStatement = "delete from Employee where Employee_ID = ?";
		preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, resultTable.getInt(1));
		preparedStatement.executeUpdate();
		return deletedEmpObj;
	}

	public Employee getById(Integer empId) throws SQLException, ExceptionHandingClass {
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Employee where Employee_ID = ?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, empId);
		ResultSet resultTable = preparedStatement.executeQuery();
		resultTable.next();
		Employee empObj = new Employee(resultTable.getString(2), resultTable.getInt(1), resultTable.getInt(3),
				resultTable.getString(4), resultTable.getString(5));
		return empObj;
	}

	private Integer min(Integer a, Integer b) {
		return a < b ? a : b;
	}

	private Integer editedDistance(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				if (i == 0) {
					arr[i][j] = j;
				} else if (j == 0) {
					arr[i][j] = i;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1];
				} else {
					arr[i][j] = 1 + min(arr[i - 1][j], min(arr[i][j - 1], arr[i - 1][j - 1]));
				}
			}
		}
		return arr[s1.length()][s2.length()];
	}

	public List<Employee> searchByName(String name) throws SQLException, ExceptionHandingClass {
		// TODO Auto-generated method stub
		List<Employee> allEmployees = getAllEmployee();
		List<String> missSpelledWords = new ArrayList<String>();
		List<ObjectsForSearch> listOfTopMatches = new ArrayList<ObjectsForSearch>();
		for (Employee empObj : allEmployees) {
			int val = editedDistance(empObj.getName(), name);
			listOfTopMatches.add(new ObjectsForSearch(empObj.getName(), val));
		}
		Collections.sort(listOfTopMatches, new Sortbyroll());

		List<Employee> listOfEmpWithName = new ArrayList<Employee>();
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Employee where NAME like  ? ";
		/*
		 * PreparedStatement preparedStatement =
		 * DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		 * preparedStatement.setString(1,"%"+name+"%"); ResultSet resultTable =
		 * preparedStatement.executeQuery(); while(resultTable.next()){ Employee
		 * empObj = new Employee(resultTable.getString(2),
		 * resultTable.getInt(1), resultTable.getInt(3),
		 * resultTable.getString(4), resultTable.getString(5));
		 * listOfEmpWithName.add(empObj); }
		 */

		int i = 0;
		Iterator<ObjectsForSearch> iterator = listOfTopMatches.iterator();
		Set<Integer> st = new HashSet<Integer>();
		while (iterator.hasNext()) {
			PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
			preparedStatement.setString(1, "%" + iterator.next().s + "%");
			ResultSet resultTable = preparedStatement.executeQuery();

			while (resultTable.next()) {
				if (!st.contains(resultTable.getInt(1))) {
					Employee empObj = new Employee(resultTable.getString(2), resultTable.getInt(1),
							resultTable.getInt(3), resultTable.getString(4), resultTable.getString(5));
					listOfEmpWithName.add(empObj);
					st.add(resultTable.getInt(1));
				}
			}
		}

		return listOfEmpWithName;
	}

	public List<Employee> searchByPhone(String phoneNum) throws SQLException, ExceptionHandingClass {
		// TODO Auto-generated method stub
		List<Employee> listOfEmpWithName = new ArrayList<Employee>();
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Employee where Contact_No like ?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setString(1, "%" + phoneNum + "%");
		ResultSet resultTable = preparedStatement.executeQuery();
		while (resultTable.next()) {
			Employee empObj = new Employee(resultTable.getString(2), resultTable.getInt(1), resultTable.getInt(3),
					resultTable.getString(4), resultTable.getString(5));
			listOfEmpWithName.add(empObj);
		}
		return listOfEmpWithName;
	}

	public Employee searchById(Integer Id) throws SQLException, ExceptionHandingClass {
		// TODO Auto-generated method stub
		List<Employee> listOfEmpWithName = new ArrayList<Employee>();
		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Employee where Company_Employee_ID=?;  ";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, Id);
		ResultSet resultTable = preparedStatement.executeQuery();
		resultTable.next();
		Employee empObj = new Employee(resultTable.getString(2), resultTable.getInt(1), resultTable.getInt(3),
				resultTable.getString(4), resultTable.getString(5));
		return empObj;

	}
}
