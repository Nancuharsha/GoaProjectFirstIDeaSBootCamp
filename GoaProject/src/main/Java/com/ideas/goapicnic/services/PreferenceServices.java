package com.ideas.goapicnic.services;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.ideas.goapicnic.Employee;
import com.ideas.goapicnic.Preferences;
import com.ideas.goapicnic.dbconfig.DBConfiguration;
import com.ideas.goapicnic.exception.ExceptionHandingClass;

public class PreferenceServices {

	public void clearPreferencesData() {
		// TODO Auto-generated method stub
		try {
			Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
			stmt.executeUpdate("delete from preferences;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertPreference(Preferences preferenceObj) throws SQLException, ExceptionHandingClass {
		// TODO Auto-generated method stub

		String query = "insert into preferences(Employee_ID,Picnic_Batch,ModeOfTravel_Onward,ModeOfTravel_Return,Gender,SetOfFamily,TotalFamilyCount) "
				+ "values(?,?,?,?,?,?,?);";
		PreparedStatement preparedStmt = DBConfiguration.dbConnectionObj.prepareStatement(query);
		preparedStmt.setInt(1, (Integer) preferenceObj.getPreferenceEmpId());
		preparedStmt.setString(2, (String) preferenceObj.getPicnicBatch());
		preparedStmt.setString(3, (String) preferenceObj.getModeOfTravelOnward());
		preparedStmt.setString(4, (String) preferenceObj.getModeOfTravelReturn());
		preparedStmt.setString(5, (String) preferenceObj.getGender());
		preparedStmt.setString(6, (String) preferenceObj.getSetOfFamily());
		preparedStmt.setInt(7, (Integer) preferenceObj.getTotalCount());
		// execute the preparedstatement
		preparedStmt.execute();
	}

	public Preferences deletePreferenceById(Integer preferenceEmpId) throws SQLException, ExceptionHandingClass {

		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		String finalSqlStatement = "select * from Preferences where Employee_ID = ?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, preferenceEmpId);

		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		Preferences prefObj = new Preferences(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
		// System.out.println(prefObj);
		finalSqlStatement = "delete from Preferences where Employee_ID = ?";
		preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, preferenceEmpId);
		preparedStatement.executeUpdate();
		return prefObj;
	}

	public void updatePreference(Preferences preferenceObj) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update preferences set  Employee_ID=? ,Picnic_Batch=?,ModeOfTravel_Onward=?,ModeOfTravel_Return=?,Gender=?,SetOfFamily=?,TotalFamilyCount=? where Employee_ID =?";
		PreparedStatement preparedStmt = DBConfiguration.dbConnectionObj.prepareStatement(query);
		preparedStmt.setInt(1, (Integer) preferenceObj.getPreferenceEmpId());
		preparedStmt.setString(2, (String) preferenceObj.getPicnicBatch());
		preparedStmt.setString(3, (String) preferenceObj.getModeOfTravelOnward());
		preparedStmt.setString(4, (String) preferenceObj.getModeOfTravelReturn());
		preparedStmt.setString(5, (String) preferenceObj.getGender());
		preparedStmt.setString(6, (String) preferenceObj.getSetOfFamily());
		preparedStmt.setInt(7, (Integer) preferenceObj.getTotalCount());
		preparedStmt.setInt(8, (Integer) preferenceObj.getPreferenceEmpId());
		// execute the preparedstatement
		preparedStmt.execute();
	}

	public Preferences fetchPreferenceByEmpId(int i) throws SQLException, ExceptionHandingClass {
		// TODO Auto-generated method stub
		// List<Preferences> preferencesList = new ArrayList<Preferences>();
		String finalSqlStatement = "select * from Preferences where Employee_ID = ?";
		PreparedStatement preparedStatement = DBConfiguration.dbConnectionObj.prepareStatement(finalSqlStatement);
		preparedStatement.setInt(1, i);
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		Preferences prefObj = new Preferences(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));

		return prefObj;
	}

	public List<Preferences> fetchAllEmpPreference() throws ExceptionHandingClass, SQLException {
		// TODO Auto-generated method stub
		List<Preferences> preferenceList = new ArrayList<Preferences>();

		Statement stmt = DBConfiguration.dbConnectionObj.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Preferences");
		while (rs.next()) {
			Preferences prefObj = new Preferences(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			preferenceList.add(prefObj);
		}

		return preferenceList;
	}

	public List<Preferences> searchPreferenceByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void fetchInfoById(int i) {
		// TODO Auto-generated method stub

	}

	public void preferenceShouldNotBeDublicate(Preferences preferenceObj) {
		// TODO Auto-generated method stub

	}

}
