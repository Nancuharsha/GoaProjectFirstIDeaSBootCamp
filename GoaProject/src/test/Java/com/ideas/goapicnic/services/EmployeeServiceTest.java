package com.ideas.goapicnic.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ideas.goapicnic.AppEmployeeVar;
import com.ideas.goapicnic.Employee;
import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class EmployeeServiceTest {
	EmployeeService empServiceObj = new EmployeeService();
	private AppEmployeeVar data = new AppEmployeeVar();

	private Employee empObj;
	private List<Employee> listOfEmpObjs;

	@Before
	public void setup() throws Exception {
		empObj = new Employee(data.validEmpName, null, data.validEmpComId, data.validEmpContactNum,
				data.validEmpDepartment);
		empServiceObj.clearAllFromEmployeeTable();

	}

	 @Test
	public void shouldEmpInsertIntoDB() throws SQLException, ExceptionHandingClass {
		empServiceObj.insertIntoDBEmpTable(empObj);
		Employee searchedObjById = empServiceObj.getById(empObj.getEmpCompId());
		// assertTrue(empObj.equals(searchedObjById));
		Assert.assertNotNull(searchedObjById.getEmpId());
		assertEquals(empObj.getName(), searchedObjById.getName());
		Assert.assertNotNull(searchedObjById.getEmpId());
		assertEquals(empObj.getEmpCompId(), empServiceObj.getById(empObj.getEmpCompId()).getEmpCompId());
		assertEquals(empObj.getEmpContact(), empServiceObj.getById(empObj.getEmpCompId()).getEmpContact());
		assertEquals(empObj.getEmpDepartment(), empServiceObj.getById(empObj.getEmpCompId()).getEmpDepartment());

	}

	 @Test
	public void shouldEmpUpdateIntoDB() throws SQLException {
		empServiceObj.insertIntoDBEmpTable(empObj);
		empServiceObj.updateEmpObjIntoDB(empObj);
	}

	@Test
	public void shouldSearchByNameIntoDB() throws SQLException, ExceptionHandingClass {

		empServiceObj.insertIntoDBEmpTable(empObj);
		List<Employee> searchedObjByName = empServiceObj.searchByName("ars");
		assertEquals(empObj.getName(), searchedObjByName.get(0).getName());
		assertEquals(empObj.getEmpCompId(), searchedObjByName.get(0).getEmpCompId());
		assertEquals(empObj.getEmpContact(), searchedObjByName.get(0).getEmpContact());
		assertEquals(empObj.getEmpDepartment(), searchedObjByName.get(0).getEmpDepartment());
		Assert.assertNotNull(searchedObjByName.get(0).getEmpId());
	}

	@Test
	public void shouldFetchAllEmployeeObj() throws Exception {

		listOfEmpObjs = new ArrayList<Employee>();
		listOfEmpObjs.add(empObj);

		for (Employee iteratorEmpObj : listOfEmpObjs) {
			empServiceObj.insertIntoDBEmpTable(iteratorEmpObj);
		}
		assertEquals(listOfEmpObjs.get(0).getName(), empServiceObj.getAllEmployee().get(0).getName());
		assertEquals(listOfEmpObjs.get(0).getEmpCompId(), empServiceObj.getAllEmployee().get(0).getEmpCompId());
		assertEquals(listOfEmpObjs.get(0).getEmpContact(), empServiceObj.getAllEmployee().get(0).getEmpContact());
		assertEquals(listOfEmpObjs.get(0).getEmpDepartment(), empServiceObj.getAllEmployee().get(0).getEmpDepartment());
		Assert.assertNotNull(empServiceObj.getAllEmployee().get(0).getEmpId());
		// Assert.assertNotNull(object);
	}

	// @Test
	public void shouldFetchFromDBById() throws SQLException, ExceptionHandingClass {
		empServiceObj.insertIntoDBEmpTable(empObj);
		Employee searchedObjById = empServiceObj.getById(empObj.getEmpCompId());
		// assertTrue(empObj.equals(searchedObjById));
		assertEquals(empObj.getName(), searchedObjById.getName());
		Assert.assertNotNull(searchedObjById.getEmpId());
		assertEquals(empObj.getEmpCompId(), empServiceObj.getById(empObj.getEmpCompId()).getEmpCompId());
		assertEquals(empObj.getEmpContact(), empServiceObj.getById(empObj.getEmpCompId()).getEmpContact());
		assertEquals(empObj.getEmpDepartment(), empServiceObj.getById(empObj.getEmpCompId()).getEmpDepartment());

	}

	public void shouldDeleteByName() throws SQLException, ExceptionHandingClass {

		empServiceObj.deleteByName(empObj.getName());
	}

	// @Test
	public void shouldDeleteByEmpId() throws SQLException, ExceptionHandingClass {
		empServiceObj.insertIntoDBEmpTable(empObj);
		Employee deletedObj = empServiceObj.deleteById(empObj.getEmpCompId());
		assertEquals(empObj.getName(), deletedObj.getName());
		Assert.assertNotNull(deletedObj.getEmpId());
		assertEquals(empObj.getEmpCompId(), deletedObj.getEmpCompId());
		assertEquals(empObj.getEmpContact(), deletedObj.getEmpContact());
		assertEquals(empObj.getEmpDepartment(), deletedObj.getEmpDepartment());

	}

	@Test
	public void fetchByPhoneNumber() throws SQLException, ExceptionHandingClass {
		empServiceObj.insertIntoDBEmpTable(empObj);
		List<Employee> searchedObjList = empServiceObj.searchByPhone(empObj.getEmpContact());
		assertEquals(empObj.getName(), searchedObjList.get(0).getName());
		Assert.assertNotNull(searchedObjList.get(0).getEmpId());
		assertEquals(empObj.getEmpCompId(), searchedObjList.get(0).getEmpCompId());
		assertEquals(empObj.getEmpContact(), searchedObjList.get(0).getEmpContact());
		assertEquals(empObj.getEmpDepartment(), searchedObjList.get(0).getEmpDepartment());
	}
}
