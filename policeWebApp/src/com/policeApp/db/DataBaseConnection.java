package com.policeApp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * <i>DataBaseConnection</i> class to get connection to DataBase
 * 
 * --------------!!!!! Do not modify !!!!!-----------------
 * *Exception is userName and password for your database
 * 
 * -------!!!!! Do not share your modification !!!!!-------
 * 
 * @author Iaroslav Malyshev
 */
public class DataBaseConnection {
	
	/**
	 * Function tries to connect to database
	 * @return Connection object if success
	 * 		   NULL if fail
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	 {
		 String url = "jdbc:mysql://localhost:3306/";    
	        String dbName = "webapp";  
	        String driver = "com.mysql.jdbc.Driver";  
	        String userName = "root";
	        String password = "root";  


	        try {
				Class.forName(driver).newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				System.out.println(e); 
			} 
			return DriverManager.getConnection(url + dbName, userName, password);
	 }
}
