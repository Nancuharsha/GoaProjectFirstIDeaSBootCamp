

package com.ideas.goapicnic.hibernate;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ideas.goapicnic.exception.ExceptionHandingClass;


@Entity
@Table(name="Employee")

public class HibernateEmployeeClass {
	
	//private Long phoneNumStart = (long) 91 * mul * (long) 10;
	//private Long PhoneNumEnd = ((long) 92 * mul * (long) 10) - 1;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_ID" ,nullable=false)
	private Integer empId;
	@Column(name = "NAME")
	private String employeeName;
	@Column(name = "Company_Employee_ID")
	private Integer empCompId;
	@Column(name = "Contact_No")
	private String empContact;
	@Column(name = "Department")
	private String empDepartment;
	
	
	public HibernateEmployeeClass(String empName, Integer empId, Integer empCompId, String empContact, String Department)
			throws ExceptionHandingClass {

		validateEmpName(empName);

		//validateEmpId(empId);

		validateEmpCompId(empCompId);

		validateEmpContact(empContact);

		if(Department != null){
			validateEmpDepartment(Department);
		}
		
		this.employeeName = empName;
		this.empId = empId;
		this.empCompId = empCompId;
		this.empContact = empContact;
		
		this.empDepartment = Department;

	}
	private void validateEmpDepartment(String Department) throws ExceptionHandingClass {
		if (Department == null) {
			throw new ExceptionHandingClass("Department is NULL");
		} else if (!checkingEnum(Department)) {
			throw new ExceptionHandingClass("Wrong Department");
		} 
	}

	private void validateEmpContact(String empContact) throws ExceptionHandingClass {
		if (empContact == null) {
			throw new ExceptionHandingClass("Employee Contact Id is NULL");
		} else if (!isEmpContactCorrect(empContact)) {
			throw new ExceptionHandingClass("Wrong Phone Number");
		}
	}

	private void validateEmpCompId(Integer empCompId) throws ExceptionHandingClass {
		if (empCompId == null) {
			throw new ExceptionHandingClass("Employee Company Id is NULL");
		} else if (!isEmpCompIdInRange(empCompId)) {
			throw new ExceptionHandingClass("Employee Company Id is out of range");
		}
	}

	private void validateEmpId(Integer empId) throws ExceptionHandingClass {
		if (empId == null) {
			throw new ExceptionHandingClass("Employee Id is NULL");
		} else if (!isEmpIdInRange(empId)) {
			throw new ExceptionHandingClass("Employee Id Out of range");
		} 
	}

	private void validateEmpName(String empName) throws ExceptionHandingClass {
		if (empName == null) {
			throw new ExceptionHandingClass("Employee Name Is NULL");
		} else if (!isContainsOnlyAlphabets(empName)) {
			throw new ExceptionHandingClass("Employee Name Contains Integers");
		} else if (!isContainsMoreSpaces(empName)) {
			throw new ExceptionHandingClass("More Spaces in Employee Name");
		} 
	}

	public boolean checkingEnum(String s) {
		String[] referenceForEnumInputArray = { "SD", "QA", "CARE", "ROA", "TECHOPS" };
		for (int i = 0; i < referenceForEnumInputArray.length; i++) {
			if (s.equals(referenceForEnumInputArray[i]) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean isAlphabet(char a) {
		if (a >= 'a' && a <= 'z') {
			return true;
		} else if (a >= 'A' && a <= 'Z') {
			return true;
		} else if (a == ' ') {
			return true;
		}
		return false;
	}

	public boolean isContainsOnlyAlphabets(String s) {
		int len = s.length();
		if (len > 100) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (!isAlphabet(s.charAt(i))) {
				// throw new ExceptionHandingClass("Employee Name Contains
				// Integers");
				return false;
			}
		}
		return true;
	}

	public boolean isContainsMoreSpaces(String s) {
		// String s = getName();
		int len = s.length();
		int tri = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == ' ') {
				tri++;
			} else {
				tri = 0;
			}
			if (tri > 1) {
				// throw new ExceptionHandingClass("More Spaces in Employee
				// Name");
				return false;
			}
		}
		return true;
	}

	public boolean isEmpIdInRange(Integer empId) {
		if (empId > Integer.MAX_VALUE || empId <= 0) {
			// throw new ExceptionHandingClass("Employee Id Out of range");
			return false;
		}
		return true;
	}

	public boolean isEmpCompIdInRange(Integer empCompId) {
		Integer maxSizeofEmpCompId = 100000;
		if (empCompId > maxSizeofEmpCompId || empCompId <= 0) {
			return false;
		}
		return true;
	}

	public boolean isEmpContactCorrect(String empContact) {
		// TODO Auto-generated method stub
		String var =empContact;
		if (var.length() != 10 || !isContainingAllIntegers(empContact)) {
			// throw new ExceptionHandingClass("Wrong Phone Number");
			return false;
		}
		return true;

	}

	private boolean isContainingAllIntegers(String empContact) {
		// TODO Auto-generated method stub
		for(int i =0;i<empContact.length();i++){
			if(!isNum(empContact.charAt(i))){
				return false;
			}
		}
		return true;
	}
	private boolean isNum(char charAt) {
		// TODO Auto-generated method stub
		if(charAt>='0' && charAt<='9'){
			return true;
		}
		return false;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return employeeName;
	}

	public Integer getEmpId() {
		// TODO Auto-generated method stub
		return empId;
	}
	
	public Integer getEmpCompId() {
		return empCompId;
	}

	public String getEmpContact() {
		// TODO Auto-generated method stub
		return empContact;
	}
	public String getEmpDepartment(){
		return empDepartment;
	}
	@Override
	 	public String toString() {
				return "{\"employeeID\":" + empId + ", \"employeeName\":\"" + employeeName + "\", \"contactNumber\":"
				+ empContact + ", \"companyEmployeeID\":\"" + empCompId + "\", \"department\":\""
				+ empDepartment + "\"}";
		}

	
}

