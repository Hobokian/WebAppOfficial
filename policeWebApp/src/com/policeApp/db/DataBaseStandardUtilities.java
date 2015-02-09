package com.policeApp.db;

import com.policeApp.db.DataBaseQuery; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utils.UtilsDB;

/**
 * <i>DataBaseStandardUtilities</i> class to work with database. it contains standard
 *  functions
 *  
 *  
 *  
 * @author Iaroslav Malyshev, ... (add your name if you add functions)
 *
 */
public class DataBaseStandardUtilities {
	
	/**
	 * function to validate budge and password
	 * @param budge     - officer budge
	 * @param password  - officer password
	 * @return  true if username and password are correct
	 * 			false if username or password are not correct
	 */
	 public static boolean validate(String budge, String password) 
	 {
		 boolean status = false;
		 ArrayList<String[]> array=DataBaseQuery.executeQuery("select * from webapp.userinfos where budgeNumber='"+ budge +"' and password='" + password + "'");
		 if(array.size()>0)
			 status=true;
		 return status;
	 }
	 
	 /**
	  * get all province
	  * @return string with html select tag of provinces
	  */
	 public static String getProvince()
	 {
		 String provinces = "<select></select>"; 
		 ArrayList<String[]> array=DataBaseQuery.executeQuery("select * from webapp.province");
		 provinces=UtilsDB.createSelectListProvince(array);
		 return provinces;
	 }
	 
	 /**
	  * get all city for chosen province
	  * @return string with html select tag of cities
	  */
	 public static String getCity()
	 {
		 StringBuffer sb = new StringBuffer(); 
		 int i;
		 sb.append("[");
		 for(i=0;i<13;i++)
		 {
		 	ArrayList<String[]> array=DataBaseQuery.executeQuery("select * from webapp.citylookup where province_id='"+(i+1)+"'");
		 	sb.append(UtilsDB.createSelectListCity(array));
		 	if(i<12) sb.append(",");
		 }
		 sb.append("]");
		 return sb.toString();
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 public static String makeDynamicProvinceCity()
	 {
		 String aaa ="onchange=\"addCityList("+DataBaseStandardUtilities.getCity()+")\"";
		 return aaa;   
	 }
	 
	 /**
	  * check access code
	  * @param code 
	  * @param province
	  * @param city
	  * @return
	  */
	 public static boolean checkAccessCode(String code, String province, String city) {
		 boolean status = false;
		 ArrayList<String[]> array=DataBaseQuery.executeQuery("select * from webapp.accesscode where code='"+code+"' AND cityLookup_id="+city+" AND province_id="+province);
		 if(array.size()>0)
			 status=true;
		 return status;
	 }
	 
	 /**
	  * This function is created to get selected incidents from database. Use parameter "filter" to setup filter part
	  * of select statement.
	  * Example:
	  * 	SELECT * FROM webapp.incidentreports 
	  * 	INNER JOIN webapp.location 
	  * 	ON incidentreports.location_id=location.id
	  * 	WHERE user='user' 
	  * 
	  * 	parameter "filter" = "user='user'"
	  * @param filter string 
	  * @return string with html table tag with all results
	  */
	 public static String getSelectedIncidents(String filter, String user_id)
	 {
		 StringBuffer sb = new StringBuffer();
		 String table;
		 sb.append("	select * from																					");
		 sb.append("	(select incidentreports.id as 'id',incidentreports.user  as 'userName', 						");
		 sb.append("	incidentreports.plateNumber as 'plateNumber', incidentreports.url as 'url', 					");
		 sb.append("	incidentreports.description as 'description', location.street_intersection as 'street',			"); 
		 sb.append("	location.postal_code as 'postalCode', province.province as 'province', 							");
		 sb.append("	citylookup.cityName as 'city', incident_status.status as 'status'								");
		 sb.append("	from incidentreports, location, province, citylookup, incident_status							");
		 sb.append("	where incidentreports.location_id=location.id AND 												");
		 sb.append("	location.province_id=province.id AND 															");
		 sb.append("	location.citylookup_id=citylookup.id AND														");
		 sb.append("	incidentreports.incident_status_id=incident_status.id)											");
		 sb.append("	as fullTable																					");
		 //sb.append("select * from webapp.incidentreports inner join webapp.location on incidentreports.location_id=location.id");
		 if(filter!=null)
		 {
			 sb.append(" where "+filter);
		 }
		 ArrayList<String[]> array=DataBaseQuery.executeQuery(sb.toString());
		 table=UtilsDB.createIncidentReportTable(array, user_id);
		 return table;
	 }
	 
	 /**
	  * function is used to get user name
	  * @param budge - number of budge
	  * @return user name
	  */
	 public static String getUserName(String budge){
		 String userName=null;
		 ArrayList<String[]> array=DataBaseQuery.executeQuery("select * from webapp.userinfos where budgeNumber='"+ budge +"'");
		 if(array.size()==1)
			 userName=array.get(0)[2];
		 return userName;
	 }
	 
	 public static String getUserId(String budge){
		 String userId=null;
		 ArrayList<String[]> array=DataBaseQuery.executeQuery("select * from webapp.userinfos where budgeNumber='"+ budge +"'");
		 if(array.size()==1)
			 userId=array.get(0)[0];
		 return userId;
	 }
	  
	 /**
	  * 
	  * @param street
	  * @param postalCode
	  * @param city
	  * @param province
	  * @return
	  */
	 public static int createLocation(String street, String postalCode, String city, String province){
		 String querySelect = 	"select * from webapp.location WHERE " 		+
                 				"street_intersection=\"" 	+ street 		+ "\" AND " +
                 				"postal_code=\"" 			+ postalCode 	+ "\" AND " +
                 				"cityLookup_id=\"" 			+ city 			+ "\" AND " +
                 				"province_id=\"" 			+ province 		+ "\"";
		 String queryInsert = 	"INSERT INTO location (street_intersection,"+
                    			" postal_code, cityLookup_id, province_id) VALUES ( " +
                    			"\"" + street 		+ "\" , " +
                    			"\"" + postalCode 	+ "\" , " +
                    			"\"" + city 		+ "\" , " +
                    			"\"" + province 	+ "\")";
		 //check exist this location or not
		 ArrayList<String[]> array=DataBaseQuery.executeQuery(querySelect);
		 //if exist return id
		 if(array.size()>0) return Integer.parseInt(array.get(0)[0]);
		 //if not exist create 
		 if(!DataBaseQuery.updateQuery(queryInsert)) return 0;
		//find id of new location
		array=DataBaseQuery.executeQuery(querySelect);
		if(array.size()>0)
			return Integer.parseInt(array.get(0)[0]);
		else
			return 0; 
	 }
	 
	 /**
	  * 
	  * @param budge
	  * @param userName
	  * @param email
	  * @param phone
	  * @param password
	  * @param province
	  * @param city
	  * @return
	  */
	 public static boolean addUser(String budge,String userName,String email,String phone,String password,String province,String city){
		 String query = "INSERT INTO userinfos (budgeNumber, password,username,"+
         				" email, phoneNumber, cityLookup_id, province_id) VALUES (" +
         				"\"" +	budge		+ "\"," +
         				"\"" +	password	+ "\"," +
         				"\"" +	userName 	+ "\"," +
         				"\"" +	email		+ "\"," +
         				"\"" +	phone		+ "\"," +
         				"\"" +	province	+ "\"," +
        		  		"\"" +	city		+ "\")";
		 return DataBaseQuery.updateQuery(query);
	 }
	 
	 /**
	  * 
	  * @param user
	  * @param plateNumber
	  * @param url
	  * @param description
	  * @param street
	  * @param postalCode
	  * @param city
	  * @param province
	  * @return
	  */
	 public static int createReport(String user, String plateNumber,String url, String description, String street, String postalCode, String city, String province){
		 int location=createLocation(street, postalCode, city, province);
		 if(location==0) return 0;
		 String queryInsert = 	"INSERT INTO incidentreports (user, plateNumber,"+
         						" url, description, incident_status_id, location_id) VALUES (" +
         						"\"" +	user		+ "\"," +
         						"\"" +	plateNumber	+ "\"," +
         						"\"" +	url			+ "\"," +
         						"\"" +	description	+ "\"," +
         						"\"" +	1			+ "\"," +
         						"\"" +	location	+ "\")";
		 String querySelect =	"select * from incidentreports where " +
								"user=\"" 				+	user		+ "\" AND " +
								"plateNumber=\"" 		+	plateNumber	+ "\" AND " +
								"url=\"" 				+	url			+ "\" AND " +
								"description=\"" 		+	description	+ "\" AND " +
								"incident_status_id=\"" +	1			+ "\" AND " +
								"location_id=\"" 		+	location	+ "\"";
		 if(!DataBaseQuery.updateQuery(queryInsert)) return 0;
		 ArrayList<String[]> array=DataBaseQuery.executeQuery(querySelect);
		 if(array.size()>0)
			return Integer.parseInt(array.get(0)[0]);
		 else
			return 0; 
	 }
	 
	 /**
	  * 
	  * @param city
	  * @param province
	  * @return
	  */
	 public static boolean addCity(String city, String province)
	 {
		 String query = "INSERT INTO citylookup (cityName, province_id) VALUES (" +
  				"\"" +	city		+ "\"," +
 		  		"\"" +	province	+ "\")";
		 return DataBaseQuery.updateQuery(query);
	 }
	 
	 /**
	  * 
	  * @param case_id
	  * @param newStatus
	  * @return
	  */
	 public static boolean changeStatusCase(String case_id, String newStatus)
	 {
		 String query = "UPDATE incidentreports SET incident_status_id="+newStatus+" WHERE id="+case_id;
		 return DataBaseQuery.updateQuery(query);
	 }
	 
	 public static ArrayList<String[]> getCaseAndUserConnection(String case_id,String user_id)
	 {
		 String query = "select * from incident_action WHERE " +
					"userInfos_id=\"" 		+ user_id +  "\" AND " +
					"incidentReports_id=" + case_id;
		 return DataBaseQuery.executeQuery(query);
	 }
	 
	 /**
	  * 
	  * @param case_id
	  * @param user_id
	  * @return
	  */
	 public static boolean connectCaseAndUser(String case_id,String user_id)
	 {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 String query = "INSERT INTO incident_action (decription, userInfos_id, incidentReports_id) VALUES (" +
		 		"\"Case was taken - " + dateFormat.format(date) +  "\"," +
				"\"" + user_id +  "\"," +
				"\"" + case_id +  "\")";
		 return DataBaseQuery.updateQuery(query);
	 }
	 
	 /**
	  * 
	  * @param case_id
	  * @param user_id
	  * @return
	  */
	 public static boolean addCommentCaseAndUser(String case_id,String user_id, String comment)
	 {
		 String description="";
		 ArrayList<String[]> array = getCaseAndUserConnection(case_id, user_id);
		 if(array.size()!=1)
			 return false;
		 description=array.get(0)[1] + "\n" + comment;
		 String query = "UPDATE incident_action SET decription=\""+description+"\" WHERE " +
				"userInfos_id=\"" 		+ user_id +  "\" AND " +
				"incidentReports_id=" + case_id;
		 return DataBaseQuery.updateQuery(query);
	 }
	 
	 /**
	  * 
	  * @param case_id
	  * @param user_id
	  * @return
	  */
	 public static boolean takeCase(String case_id, String user_id){
		 if(!connectCaseAndUser(case_id,user_id))
			 return false;
		 if(!changeStatusCase(case_id, String.format("%d", 2)))
			 return false;
		 return true;

	 }
	 
	 /**
	  * 
	  * @param case_id
	  * @param user_id
	  * @return
	  */
	 public static boolean closeCase(String case_id, String user_id){
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 if(!addCommentCaseAndUser(case_id, user_id, "\nCase was closed - "+dateFormat.format(date)))
			 return false;
		 if(!changeStatusCase(case_id, String.format("%d", 5)))
			 return false;
		 return true;
	 }
	 
	 /**
	  * 
	  * @param case_id
	  * @param user_id
	  * @return
	  */
	 public static boolean declineCase(String case_id, String user_id){
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 if(!addCommentCaseAndUser(case_id, user_id, "\nCase was declined - "+dateFormat.format(date)))
			 return false;
		 if(!changeStatusCase(case_id, String.format("%d", 4)))
			 return false;
		 return true;
	 }
}
