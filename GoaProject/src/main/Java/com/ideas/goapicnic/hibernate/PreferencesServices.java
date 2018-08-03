package com.ideas.goapicnic.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas.goapicnic.dbconfig.HibernateUtils;
import com.ideas.goapicnic.dbconfig.HibernateUtilsForPerferences;

public class PreferencesServices {
	
private static SessionFactory sessionFactoryPreferences;
	
	private Session session;
	private Transaction transaction;
	
	public PreferencesServices(){
		sessionFactoryPreferences = HibernateUtilsForPerferences.getSessionFactory();
		
	}
	
	public void deleteAllPreferences(){
		//System.out.println("Hello World!1");
		session = sessionFactoryPreferences.openSession();
		//System.out.println("Hello World!2");
		transaction = session.beginTransaction();
		//System.out.println("Hello World!3");
		Criteria criteria = session.createCriteria(HibernatePreferencesClass.class);
		//System.out.println("Hello World!4");
		List<HibernatePreferencesClass> rowsPreferences = new ArrayList<HibernatePreferencesClass>();
		rowsPreferences=criteria.list();
		//System.out.println("Hello World!5");
		for (HibernatePreferencesClass row : rowsPreferences) {
			session.delete(row);
		}
		//System.out.println("Hello World!6");
		transaction.commit();
		//System.out.println("Hello World!7");
	}

	
}
