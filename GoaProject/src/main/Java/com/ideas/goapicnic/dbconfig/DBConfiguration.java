package com.ideas.goapicnic.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfiguration {

	public static Connection dbConnectionObj;
	static{ 
		try{
			Class.forName("com.mysql.jdbc.Driver");
		dbConnectionObj = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/goa","root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private DBConfiguration(){
		
	}

}
