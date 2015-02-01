package utils;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.policeApp.db.DataBaseStandardUtilities;

/**
 * <i>UtilsDB</i> class to create utilities functions which don't require database connection
 * 
 * @author Iaroslav Malyshev, ....
 *
 */
public class UtilsDB {
	
	private UtilsDB(){};
	
	/**
	 * function convert result from DB to select list
	 * @param array - ArrayList of String arrays
	 * @param name - id of select tag 
	 * @return
	 */
	public static String createSelectListProvince(ArrayList<String[]> array) {
        StringBuffer sb = new StringBuffer();
        sb.append("<option value=\"0\">select province</option>");
        if(array.size()>0) 
        {
        	int i;
        	for(i=0;i<array.size();i++)
        	{
        		sb.append("<option value=\"" + array.get(i)[0] + "\">" + array.get(i)[1] + "</option>\n");
                
        	}
        }
        return sb.toString();
    }
	
	/**
	 * function convert result from DB to select list
	 * @param array - ArrayList of String arrays
	 * @param name - id of select tag
	 * @return
	 */
	public static String createSelectListCity(ArrayList<String[]> array) {
        StringBuffer sb = new StringBuffer();
        int i=0;
        if(array.size()>0) 
        {
        	sb.append("[");
        	for(i=0;i<array.size();i++)
        	{
        		sb.append("'"+array.get(i)[1]+"'");
        		if(i<(array.size()-1)) sb.append(",");
                
        	}
        	sb.append("]"); 
        }
        
        return sb.toString();
    }
	
	/**
	 * 
	 * 
	 * @param rset
	 * @return
	 * @throws SQLException
	 */
	public static String createIncidentReportTable(ArrayList<String[]> rset) {
        StringBuffer sb = new StringBuffer();
        int i;
        sb.append("<table frame=\"box\" border=2 >");
        sb.append("<tr><td>user</td><td>plateNumber</td><td>description</td><td>URL</td></tr>");
        if(rset.size()>0)
        {
        	for(i=0;i<rset.size();i++) 
        	{  
        		sb.append("<tr><td>"+rset.get(i)[1]+"</td><td>"+rset.get(i)[2]+"</td><td>"+rset.get(i)[4]+"</td><td>"+rset.get(i)[3]+"</td></tr>");
        	} 
        }
        sb.append("</table>"); 
        return sb.toString();
    }
	
	
	public static void addCity(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException { 
		response.setContentType("text/html");    
	    PrintWriter out = response.getWriter();  
	    //get address where servlet was called
	    String referrer = request.getHeader("referer");
	    String strArr[]=referrer.split("/");
	    String page=strArr[strArr.length-1];
	    String pageJSP="";
	    String selectProvince="";
	    if(page.compareTo("signUpPage")==0) //"createReport"
	    {
	    	String budge=request.getParameter("budge");    
	        String accessCode=request.getParameter("accessCode");
	        String userName=request.getParameter("userName");  
	        String email=request.getParameter("email");  
	        String phone=request.getParameter("phoneNumber");  
	        selectProvince=request.getParameter("province");
	        HttpSession session = request.getSession(false);  
	        if(session!=null)
	        {
	        	session.setAttribute("budge", budge);
	        	session.setAttribute("accessCode", accessCode);
	        	session.setAttribute("userName", userName);
	        	session.setAttribute("email", email);
	        	session.setAttribute("phone", phone);
	        }
	        pageJSP="signUp.jsp";
	        
	    }
	    else
	    {
	    	HttpSession session = request.getSession();
	    	String email = (String) session.getAttribute("email");
	        String phone = (String) session.getAttribute("phone");
	    	String plateNumber=request.getParameter("plateNumber");    
	        String URLlink=request.getParameter("URLlink");  
	        String street=request.getParameter("street"); 
	        String postalCode=request.getParameter("postalCode");
	        String description=request.getParameter("description");
	        selectProvince=request.getParameter("province");
	    	if(session!=null)  
		    {
		    	session.setAttribute("email", email); 
		    	session.setAttribute("phone", phone); 
		    	session.setAttribute("plateNumber", plateNumber);
		    	session.setAttribute("URLlink", URLlink);
		    	session.setAttribute("street", street);
		    	session.setAttribute("postalCode", postalCode);
		    	session.setAttribute("description", description);
		    }
	    	pageJSP="report.jsp";
	    }
	    String addCity=request.getParameter("addCity");
        if(!DataBaseStandardUtilities.addCity(addCity, selectProvince))
        	out.print("<p style=\"color:red\">fail adding city</p>");
        
        RequestDispatcher rd=request.getRequestDispatcher(pageJSP);    
        rd.include(request,response); 
	    out.close();
    }

}