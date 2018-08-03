package com.ideas.goapicnic.hibernate;

import org.junit.Before;
import org.junit.Test;

import com.ideas.goapicnic.AppPreferenceVar;
import com.ideas.goapicnic.Preferences;
import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class HibernatePreferencesServicesTest {
	private HibernatePreferencesClass preferences;
	private PreferencesServices preferenceServicesObj;
	AppPreferenceVar data = new AppPreferenceVar();
	@Before
	public void setup() throws ExceptionHandingClass{
		preferenceServicesObj = new PreferencesServices();
	//	preferences = new HibernatePreferencesClass(null, 4, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
	}
	@Test
	public void shouldDeleteAllEmployee() {
		preferenceServicesObj.deleteAllPreferences();
	}
}
