package com.ideas.goapicnic;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class EmployeeTestClass {
	Employee empObj ;
	private AppEmployeeVar data = new AppEmployeeVar();

	@Test(expected = ExceptionHandingClass.class)
	public void empNameIsNull() throws ExceptionHandingClass {

		empObj = new Employee(null, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
	}

	@Test
	public void empNameIsNotNull() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		assertEquals(data.validEmpName,empObj.getName());

	}
	
	@Test(expected = ExceptionHandingClass.class)
	public void integersInEmpName() throws ExceptionHandingClass {

		empObj = new Employee(data.invalidEmpNameWithInt, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		// empObj.isContainsOnlyAlphabets();
	}

	@Test(expected = ExceptionHandingClass.class)
	public void lotOfSpaceInEmpName() throws ExceptionHandingClass {
		empObj = new Employee(data.invalidEmpNameWithSpaces, data.validEmpId, data.validEmpComId, data.validEmpContactNum,
				data.validEmpDepartment);
		// empObj.isContainsMoreSpaces();
	}


	//@Test(expected = ExceptionHandingClass.class)
	public void empIdIsNull() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, null, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
	}

	@Test
	public void empIdIsNotNull() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		assertEquals(data.validEmpId, empObj.getEmpId());
	}

	@Test(expected = ExceptionHandingClass.class)
	public void empCompIdIsNull() throws ExceptionHandingClass {
		empObj = new Employee(data.validEmpName, data.validEmpId, null, data.validEmpContactNum, data.validEmpDepartment);
	}
	
	
	@Test
	public void empCompIdIsNotNull() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		assertEquals(data.validEmpComId, empObj.getEmpCompId());
	}

	@Test(expected = ExceptionHandingClass.class)
	public void empContactIsNull() throws ExceptionHandingClass {
		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, null, data.validEmpDepartment);
	}
	
	@Test(expected = ExceptionHandingClass.class)
	public void empContactWithNonNumeric() throws ExceptionHandingClass {
		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, "123456789o", data.validEmpDepartment);
	}

	
	@Test
	public void empContactIsNotNull() throws ExceptionHandingClass {
		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		assertEquals(data.validEmpContactNum,empObj.getEmpContact());
	}

	
	//@Test(expected = ExceptionHandingClass.class)
	public void nonPostiveEmpId() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.invalidEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		// empObj.isEmpIdInRange();
	}

	@Test(expected = ExceptionHandingClass.class)
	public void nonPostiveCompEmpId() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.invalidEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		// empObj.isEmpCompIdInRange();
	}

	@Test(expected = ExceptionHandingClass.class)
	public void outOfRangeEmpContact() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.invalidEmpContactNum, data.validEmpDepartment);
	}

	@Test
	public void inRangeEmpContact() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
	}
	@Test
	public void departmentNameNull() throws ExceptionHandingClass{
		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, null);
	}
	
	@Test(expected = ExceptionHandingClass.class)
	public void departmentNameInvalid() throws ExceptionHandingClass {

		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.invalidEmpDepartment);
	}

	@Test
	public void departmentNameValid() throws ExceptionHandingClass {
		empObj = new Employee(data.validEmpName, data.validEmpId, data.validEmpComId, data.validEmpContactNum, data.validEmpDepartment);
		assertEquals(data.validEmpDepartment,empObj.getEmpDepartment());
	}
}
