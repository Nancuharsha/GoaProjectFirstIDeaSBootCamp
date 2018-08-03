package com.ideas.goapicnic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class PreferencesTestClass {
	public Preferences preferObj;
	AppPreferenceVar data = new AppPreferenceVar();
	
	//@Test(expected=ExceptionHandingClass.class)
	public void preferenceIdIsNull()throws ExceptionHandingClass{
		preferObj = new Preferences(null, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
	}
	@Test
	public void preferenceIdIsCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel,data.validGender, data.validSetOfFamily,  data.validTotalCount);
		assertEquals(data.validPreferenceId,preferObj.getPreferencId());
	}
	//@Test(expected=ExceptionHandingClass.class)
	public void preferenceIdIsWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.invalidPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
	}
	
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesEmployeeIdNull()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, null, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
		
	}
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesEmployeeIdWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.invalidPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	@Test
	public void preferencesEmployeeIdCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesModeOfTravelOnwardWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.invalidModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesModeOfTravelOnwardIsNull()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,null, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	@Test
	public void preferencesModeOfTravelOnwardCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	
	
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesModeOfTravelReturnIsNull()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, null, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	@Test
	public void preferencesModeOfTravelReturnCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesModeOfTravelReturnWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.invalidModeOfTravel, data.validSetOfFamily,data.validGender,  data.validTotalCount);

	}
	
	
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesGenderNull()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, null, data.validSetOfFamily, data.validTotalCount);

	}
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesGenderWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.invalidGender, data.validSetOfFamily, data.validTotalCount);

	}
	@Test
	public void preferencesGenderCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel,data.validGender, data.validSetOfFamily,  data.validTotalCount);

	}
	
	
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesSetOfFamilyIsNull()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, null);

	}
	@Test(expected=ExceptionHandingClass.class)
	public void preferencesTotalFamilyCountWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.invalidTotalCount);

	}
	@Test
	public void preferencesTotalFamilyCountCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);

	}
	
	@Test(expected=ExceptionHandingClass.class)
	public void preferencePicnicBatchIsNull()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, null,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
	}
	@Test
	public void preferencePicnicBatchIsCorrect()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.validPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
		assertEquals(data.validPicnicBatch,preferObj.getPicnicBatch());
	}
	@Test(expected=ExceptionHandingClass.class)
	public void preferencePicnicBatchIsWrong()throws ExceptionHandingClass{
		preferObj = new Preferences(data.validPreferenceId, data.validPreferenceEmpId, data.invalidPicnicBatch,data.validModeOfTravel, data.validModeOfTravel, data.validGender, data.validSetOfFamily, data.validTotalCount);
	}
	
	
	
}
