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
	public static String createIncidentReportTable(ArrayList<String[]> rset, String user_id) {
        StringBuffer sb = new StringBuffer();
        int i;
        String info_button="";
        sb.append("<table frame=\"box\" border=2 >");
        sb.append(	"<tr><td>user</td>"		+
        			"<td>plateNumber</td>"	+
        			"<td>URL</td>"			+
        			"<td>description</td>"	+
        			"<td>strret</td>"		+
        			"<td>postal code</td>"	+
        			"<td>province</td>"		+
        			"<td>city</td>"			+
        			"<td>status</td>"		+
        			"<td>action</td></tr>");
        if(rset.size()>0)
        {
        	for(i=0;i<rset.size();i++) 
        	{  
        		if(rset.get(i)[9].compareTo("new")==0)
        		{
        			info_button="<input type=\"submit\" name=\"action\" value=\"take case\">";
        		}
        		if(rset.get(i)[9].compareTo("in progress")==0)
        		{
        			info_button="<input type=\"submit\" name=\"action\" value=\"close case\"><input type=\"submit\" name=\"action\" value=\"decline case\">";
        		}
        		
        		sb.append(	"<form action=\"caseServlet\" method=\"post\">"+
        					"<input type=\"hidden\" name=\"hdn_case_id\" value=\""+ rset.get(i)[0] + "\"/>" +
        					"<input type=\"hidden\" name=\"hdn_user_id\" value=\""+user_id+"\"/>" +
        					"<tr><td>"+rset.get(i)[1]+"</td>"+
        						"<td>"+rset.get(i)[2]+"</td>"+
        						"<td>"+rset.get(i)[3]+"</td>"+
        						"<td>"+rset.get(i)[4]+"</td>"+
        						"<td>"+rset.get(i)[5]+"</td>"+
        						"<td>"+rset.get(i)[6]+"</td>"+
        						"<td>"+rset.get(i)[7]+"</td>"+
        						"<td>"+rset.get(i)[8]+"</td>"+
        						"<td>"+rset.get(i)[9]+"</td>"+
        					"<td>"+info_button+"</td></tr></form>");
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