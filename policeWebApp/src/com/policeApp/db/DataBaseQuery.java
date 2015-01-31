package com.policeApp.db;

import com.policeApp.db.DataBaseConnection;

import java.sql.Connection;   
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <i>DataBaseQuery</i> class to execute query to DataBase
 * 
 * -------------!!!!! Do not modify !!!!!-----------------
 * 
 * @author Iaroslav Malyshev
 *
 */
public class DataBaseQuery {
	 
	/**
	 * function is used to execute in database query like "select *" 
	 * @param query - query which you want to execute
	 * @return ArrayList of String array  
	 */
	 public static ArrayList<String[]> executeQuery(String query)
	 {
		 ArrayList<String[]> arrayListString = new ArrayList<String[]>();
		 Connection conn = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;
		 java.sql.ResultSetMetaData rsMetaData;
		 int columnCount =0;
		 try {
			conn=DataBaseConnection.getConnection();
			pst = conn  
			         .prepareStatement(query);  
			rs = pst.executeQuery();
			rsMetaData= rs.getMetaData();
			columnCount = rsMetaData.getColumnCount();
			while (rs.next()) {
				int i=0;
				String newString[] = new String[columnCount];
				for(i=0;i<columnCount;i++)
				{
					newString[i]=rs.getString(i+1);
				}
				arrayListString.add(newString);
			}
		} catch (SQLException e) {
			System.out.println(e); 
		} finally {
			if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }
			if(pst!=null)
			{
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return arrayListString;
	 }
	 
	 /**
		 * function is used to execute in database query for "insert", "update" and "drop" 
		 * @param query - query which you want to execute
		 * @return true if query was successful
		 *         false if query failed 
		 */
	 public static boolean updateQuery(String query)
	 {
		 Connection conn = null;
		 PreparedStatement pst = null;  
		 boolean result = false;
		 try {
			conn=DataBaseConnection.getConnection();
			pst = conn  
			         .prepareStatement(query);  
			if(pst.executeUpdate()==1)result=true;
		} catch (SQLException e) {
			System.out.println(e); 
		} finally {
			if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }
			if(pst!=null)
			{
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	 }
}
