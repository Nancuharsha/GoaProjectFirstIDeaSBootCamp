package com.ideas.goapicnic.dbconfig;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ideas.goapicnic.hibernate.HibernateEmployeeClass;
import com.ideas.goapicnic.hibernate.HibernatePreferencesClass;
import com.ideas.goapicnic.services.PreferenceServices;


public class HibernateUtilsForPerferences {
	private static SessionFactory sessionFactory;
	private Session session;
	//PreferenceServices employeeService;
	private HibernateUtilsForPerferences() {
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(HibernatePreferencesClass.class);
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			new HibernateUtilsForPerferences();
		}
		return sessionFactory;
	}

}
