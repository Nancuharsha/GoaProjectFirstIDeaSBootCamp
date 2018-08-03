package com.ideas.goapicnic.services;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ideas.goapicnic.AppPreferenceVar;
import com.ideas.goapicnic.Employee;
import com.ideas.goapicnic.Preferences;
import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class PreferenceServiceTest {
	private PreferenceServices serviceObj = new PreferenceServices();
	private Preferences preferenceObj;
	AppPreferenceVar data = new AppPreferenceVar();

	@Before
	public void setup() throws ExceptionHandingClass {
		preferenceObj = new Preferences(null, 72, data.validPicnicBatch, data.validModeOfTravel, data.validModeOfTravel,
				data.validGender, data.validSetOfFamily, data.validTotalCount);
		// new Preferences(preferencId, preferenceEmpId, picnicBatch,
		// modeOfTravelOnward, modeOfTravelReturn, gender, setOfFamily,
		// totalCount)
		serviceObj.clearPreferencesData();
	}

	@Test
	public void shouldInsertPreferenceIntoDb() throws SQLException, ExceptionHandingClass {

		serviceObj.insertPreference(preferenceObj);
		// System.out.print(serviceObj.fetchPreferenceById(1));
	}

	@Test
	public void shouldUpdatePreferenceIntodb() throws SQLException {
		serviceObj.updatePreference(preferenceObj);
	}

	/*
	 * @Test public void shouldFetchEmployeePreferenceDataFromDbById() throws
	 * SQLException, ExceptionHandingClass{
	 * serviceObj.fetchPreferenceByEmpId(preferenceObj.getPreferenceEmpId()); }
	 */

	@Test
	public void shouldFetchAllEmployeesPreferenceDataFromDb() throws ExceptionHandingClass, SQLException {
		serviceObj.insertPreference(preferenceObj);
		List<Preferences> preferenceList = new ArrayList<Preferences>();
		preferenceList = serviceObj.fetchAllEmpPreference();
		assertEquals(preferenceObj.getPreferenceEmpId(), preferenceList.get(0).getPreferenceEmpId());

		Assert.assertNotNull(preferenceList.get(0).getPreferencId());

	}

	/*
	 * //@Test public void shouldSearchEmployeePreferenceByName() {
	 * List<Preferences> emp = serviceObj.searchPreferenceByName("a");
	 * 
	 * 
	 * }
	 */
	@Test
	public void shouldSearchEmployeePreferenceByEmpId() throws SQLException, ExceptionHandingClass {
		serviceObj.insertPreference(preferenceObj);
		Preferences preferencesObj = serviceObj.fetchPreferenceByEmpId(preferenceObj.getPreferenceEmpId());
		Assert.assertNotNull(preferencesObj);
	}

	// @Test(expected=ExceptionHandingClass.class)
	public void preferenceShouldNotBeDuplicate() throws SQLException, ExceptionHandingClass {
		serviceObj.insertPreference(preferenceObj);
		serviceObj.insertPreference(preferenceObj);
	}

	@Test
	public void shouldDeletePreferenceById() throws SQLException, ExceptionHandingClass {
		serviceObj.insertPreference(preferenceObj);
		serviceObj.deletePreferenceById(preferenceObj.getPreferenceEmpId());
	}
}
