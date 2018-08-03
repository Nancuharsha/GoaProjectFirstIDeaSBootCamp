package com.ideas.goapicnic.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ideas.goapicnic.dbconfig.HibernateUtils;


public class EmployeeService {

	private static SessionFactory sessionFactoryEmployee;
	
	private Session session;
	private Transaction transaction;
	private PreferencesServices PreferencesServicesObj;
	public EmployeeService() {
		// TODO Auto-generated constructor stub
		sessionFactoryEmployee = HibernateUtils.getSessionFactory();
		 PreferencesServicesObj = new PreferencesServices();
	}

	public void deleteAllFromDB() {
		// TODO Auto-generated method stub
		PreferencesServicesObj.deleteAllPreferences();
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(HibernateEmployeeClass.class);
		List<HibernateEmployeeClass> rowsEmployee = criteria.list();
		for (HibernateEmployeeClass row : rowsEmployee) {
			session.delete(row);
		}
		transaction.commit();
	}

	public void insertEmployeeInDB(HibernateEmployeeClass employee) {
		// TODO Auto-generated method stub
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		//System.out.println(employee);
		session.save(employee);
		//System.out.println(employee);
		transaction.commit();
		//System.out.println(employee);
	}

	/*public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		List<Employee> listEmployees = new ArrayList<Employee>();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("employeeName"));
		List<Employee> rows = criteria.list();
		for (Employee row : rows) {
			listEmployees.add(row);
		}
		transaction.commit();
		return listEmployees;
	}

	public void deleteEmployeeInDB(Employee employee) {
		// TODO Auto-generated method stub
		session = sessionFactoryPreferences.openSession();
		transaction = session.beginTransaction();
		Preferences toDeletePreferences = session.get(Preferences.class, employee.getEmployeeId());
		if(null!=toDeletePreferences) {
			session.delete(toDeletePreferences);
		}
		transaction.commit();
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		Employee toDeleteEmployee = session.get(Employee.class, employee.getEmployeeId());
		session.delete(toDeleteEmployee);
		transaction.commit();
	}

	public Employee searchEmployeeByID(Integer employeeId) {
		// TODO Auto-generated method stub
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		Employee toSearchEmployee = session.get(Employee.class, employeeId);
		transaction.commit();
		return toSearchEmployee;
	}

	public List<Employee> searchEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		List<Employee> listEmployees = new ArrayList<Employee>();
		Criteria criteria = session.createCriteria(Employee.class)
				.add(Restrictions.like("employeeName", "%" + employeeName + "%"));
		criteria.addOrder(Order.asc("employeeName"));
		List<Employee> rows = criteria.list();
		for (Employee row : rows) {
			listEmployees.add(row);
		}
		transaction.commit();
		return listEmployees;
	}

	public void updateEmployee(Employee toUpdateEmployee) throws InvalidAttributeException {
		// TODO Auto-generated method stub
		session = sessionFactoryEmployee.openSession();
		transaction = session.beginTransaction();
		Employee updateEmployee = session.get(Employee.class, toUpdateEmployee.getEmployeeId());
		updateEmployee.setEmployeeName(toUpdateEmployee.getEmployeeName());
		updateEmployee.setCompanyEmployeeId(toUpdateEmployee.getCompanyEmployeeId());
		updateEmployee.setContactNumber(toUpdateEmployee.getContactNumber());
		updateEmployee.setDepartment(toUpdateEmployee.getDepartment());
		session.update(updateEmployee);
		transaction.commit();
	}*/
}
