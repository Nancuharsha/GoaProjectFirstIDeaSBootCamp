package com.ideas.goapicnic;

import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class Preferences {
	private Integer preferencId ;
	private Integer preferenceEmpId;
	private String 	picnicBatch;
	private String modeOfTravelOnward;
	private String modeOfTravelReturn;
	private String gender;
	private String setOfFamily;
	private Integer totalCount;
	private String[] picnicBatchValues = {"FIRST_BATCH","SECOND_BATCH"};
	private String[] modeOfTravelSet = {"CAR","AEROPLANE","TRAIN","BUS"};
	private String[] genderSet = {"FEMALE","MALE"};
	private String[] setOfFamilySet={"EMPLOYEE_SPOUSE_CHILDREN","EMPLOYEE_DEPENDANT_PARENTS","EMPLOYEE_SPOUSE","EMPLOYEE"};
	public Preferences(Integer preferencId, Integer preferenceEmpId, String picnicBatch, String modeOfTravelOnward,
			String modeOfTravelReturn, String gender, String setOfFamily, Integer totalCount)throws ExceptionHandingClass {
		super();
		//validatePreferenceId(preferencId);
		validatePreferenceEmpId(preferenceEmpId);
		validatePreferencePicnicBatch(picnicBatch);
		validatePreferenceModeOfTravelOnward(modeOfTravelOnward);
		validatePreferenceModeOfTravelReturn(modeOfTravelReturn);
		validatePreferenceGender(gender);
		validatepreferenceSetOfFamily(setOfFamily);
		validataPreferenceTotalFamily(totalCount);
		
		this.preferencId = preferencId;
		this.preferenceEmpId = preferenceEmpId;
		this.picnicBatch = picnicBatch;
		this.modeOfTravelOnward = modeOfTravelOnward;
		this.modeOfTravelReturn = modeOfTravelReturn;
		this.gender = gender;
		this.setOfFamily = setOfFamily;
		this.totalCount = totalCount;
	}
	
	
	
	private void validataPreferenceTotalFamily(Integer totalCount2) throws ExceptionHandingClass{
		// TODO Auto-generated method stub
		if(totalCount2 == null){
			throw new ExceptionHandingClass("Preference TotalCount is NULL");
		}else if(!isPerferencesTotalCountValid(totalCount2)){
			throw new ExceptionHandingClass("Not valid members of totalCount!");
		}
	}



	private boolean isPerferencesTotalCountValid(Integer totalCount2) {
		if(totalCount2>=1 && totalCount2<=10){
			return true;
		}return false;
	}



	private void validatePreferenceModeOfTravelReturn(String modeOfTravelReturn2)throws ExceptionHandingClass {
		// TODO Auto-generated method stub
		if(modeOfTravelReturn2 == null){
			throw new ExceptionHandingClass("Mode of Travel return is NULL");
		}else if(!isValidModeOfTravel(modeOfTravelReturn2)){
			throw new ExceptionHandingClass("Not Valid Mode of Travel Return");
		}
	}



	private void validatepreferenceSetOfFamily(String setOfFamily2)throws ExceptionHandingClass {
		// TODO Auto-generated method stub
		if(setOfFamily2 == null){
			throw new ExceptionHandingClass("Preference of Set of Family is NULL");
		}else if(!validateSetOfFamily(setOfFamily2)){
			throw new ExceptionHandingClass("Wrong in prefernces Set of Family");
		}
	}



	private boolean validateSetOfFamily(String setOfFamily2) {
		// TODO Auto-generated method stub
		for(String s:setOfFamilySet){
			if(s.equals(setOfFamily2)){
				return true;
			}
		}
		return false;
	}



	private void validatePreferenceGender(String gender2) throws ExceptionHandingClass{
		// TODO Auto-generated method stub
		if(gender2 == null){
			throw new ExceptionHandingClass("Gender is NULL");
		}else if(!isValidGender(gender2)){
			throw new ExceptionHandingClass("Not Valid Gender!");
		}
	}
	


	private boolean isValidGender(String gender2) {
		// TODO Auto-generated method stub
		for(String s:genderSet){
			if(s.equals(gender2)){
				return true;
			}
		}
		return false;
	}



	private void validatePreferenceModeOfTravelOnward(String modeOfTravelOnward2) throws ExceptionHandingClass{
		// TODO Auto-generated method stub
		if(modeOfTravelOnward2 == null){
			throw new ExceptionHandingClass("Mode of Travel Onwards is NULL");
		}else if(!isValidModeOfTravel(modeOfTravelOnward2)){
			throw new ExceptionHandingClass("Not Valid Mode of Travel onwards");
		}
		
	}



	private boolean isValidModeOfTravel(String modeOfTravelOnward2) {
		// TODO Auto-generated method stub
		for(String s:modeOfTravelSet){
			if(s.equals(modeOfTravelOnward2)){
				return true;
			}
		}
		return false;
	}



	private void validatePreferenceEmpId(Integer preferenceEmpId2) throws ExceptionHandingClass{
		// TODO Auto-generated method stub
		if(preferenceEmpId2 == null){
			throw new ExceptionHandingClass("preference Emp Id is NULL");
		}else if(!isValidEmployeeId(preferenceEmpId2)){
			throw new ExceptionHandingClass("Not Valid Employee Id");
		}
		
	}

	

	private boolean isValidEmployeeId(Integer preferenceEmpId2) {
		// TODO Auto-generated method stub
		if(preferenceEmpId2>=1 && preferenceEmpId2 <= Integer.MAX_VALUE){
			return true;
		}
		return false;
	}



	private void validatePreferencePicnicBatch(String picnicBatch2)throws ExceptionHandingClass {
		// TODO Auto-generated method stub
		if(picnicBatch2 == null){
			throw new ExceptionHandingClass("Picnic Batch is NULL");
		}else if(!isValidPicnicBatch(picnicBatch2)){
			throw new ExceptionHandingClass("Wrong Picnic Batch input");
		}
	}
	
	public boolean isValidPicnicBatch(String picbatch){
		for(String s : picnicBatchValues){
			if(s.equals(picbatch)){
				return true;
			}
		}
		return false;
	}


	private void validatePreferenceId(Integer preferencId2) throws ExceptionHandingClass{
		// TODO Auto-generated method stub
		if(preferencId2 == null){
			throw new ExceptionHandingClass("Preference Id is NULL");
		}else if(!isInRange(preferencId2)){
			throw new ExceptionHandingClass("Out Of Range");
		}
	}
	public boolean isInRange(Integer preId){
		if(preId>=1 && preId <=Integer.MAX_VALUE){
			return true;
		}
		return false;
	}


	public Integer getPreferencId() {
		return preferencId;
	}
	public void setPreferencId(Integer preferencId) {
		this.preferencId = preferencId;
	}
	public Integer getPreferenceEmpId() {
		return preferenceEmpId;
	}
	public void setPreferenceEmpId(Integer preferenceEmpId) {
		this.preferenceEmpId = preferenceEmpId;
	}
	public String getPicnicBatch() {
		return picnicBatch;
	}
	public void setPicnicBatch(String picnicBatch) {
		this.picnicBatch = picnicBatch;
	}
	public String getModeOfTravelOnward() {
		return modeOfTravelOnward;
	}
	public void setModeOfTravelOnward(String modeOfTravelOnward) {
		this.modeOfTravelOnward = modeOfTravelOnward;
	}
	public String getModeOfTravelReturn() {
		return modeOfTravelReturn;
	}
	public void setModeOfTravelReturn(String modeOfTravelReturn) {
		this.modeOfTravelReturn = modeOfTravelReturn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSetOfFamily() {
		return setOfFamily;
	}
	public void setSetOfFamily(String setOfFamily) {
		this.setOfFamily = setOfFamily;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
