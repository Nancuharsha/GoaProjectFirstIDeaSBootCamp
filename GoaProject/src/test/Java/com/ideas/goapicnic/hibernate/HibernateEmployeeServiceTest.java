package com.ideas.goapicnic.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ideas.goapicnic.AppEmployeeVar;
import com.ideas.goapicnic.Employee;
import com.ideas.goapicnic.exception.ExceptionHandingClass;

/*import com.ideas.goapicnic.DBconnection.*;
*/
public class HibernateEmployeeServiceTest {
	private AppEmployeeVar data = new AppEmployeeVar();
	private EmployeeService employeeService = new EmployeeService();
	private HibernateEmployeeClass hibEmpObj;
	
	@Before
	public void setUp()throws Exception
	{
		
	}
	@Test
	public void shouldCreateEmployee() throws ExceptionHandingClass {
		hibEmpObj = new HibernateEmployeeClass(data.validEmpName, null, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);;
		
		employeeService.insertEmployeeInDB(hibEmpObj);
		
	}
	//@Test
	public void shouldDeleteAllEmployee() {
		employeeService.deleteAllFromDB();
	}
	/*private HibernateEmployeeClass createEmployee() {
		HibernateEmployeeClass employee=new HibernateEmployeeClass();
		employee.setEmployeeId(1);
		employee.setName("Varun");
		employee.setDepartment("QA");
		return employee;
	}*/
/*	@Test
	public void shouldFetchEmployee() {
		HibernateEmployeeClass employee=new HibernateEmployeeClass();
		employeeService.fetchAllInfo();
	}
	@Test
	public void shouldFetchEmployeeById()
	{
		HibernateEmployeeClass employee=new HibernateEmployeeClass();
		employeeService.fetchById();
	}
	public void shouldUpdateEmployeeId()
	{
		HibernateEmployeeClass employee=new HibernateEmployeeClass();
		employeeService.updateId();
	}
	public void shouldDeleteEmployeeById()
	{
		HibernateEmployeeClass employee=new HibernateEmployeeClass();
		employeeService.deleteById();
	}*/
}
