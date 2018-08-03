package com.ideas.goapicnic.dbconfig;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ideas.goapicnic.hibernate.HibernateEmployeeClass;


public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private Session session;
	//com.ideas.goapicnic.services.EmployeeService employeeService;
	private HibernateUtils() {
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(HibernateEmployeeClass.class);
		sessionFactory=configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			new HibernateUtils();
		}
		return sessionFactory;
	}

}
