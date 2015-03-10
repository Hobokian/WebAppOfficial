package utils;
/***/
//
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

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
	 * 
	 * @param language
	 * @param index
	 * @return
	 */
	public static String getWord(String language, String index)
	{
		String aaa = Languages.language.getWord(language, index);
		return aaa;
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static String encript(String text)
	{
		return WebSecurity.webSecurity.encript(text);
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static String decript(String text)
	{
		return WebSecurity.webSecurity.decript(text);
	}
	
	/**
	 * 
	 * @param twitter_id
	 * @return
	 */
	public static String getTwit(long twitter_id, int number)
	{
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	            		.setOAuthConsumerKey("OD24FWoKJ7U2WzG26gqwhO4g3")
	            		.setOAuthConsumerSecret("pPQqPTwCUycv4MxxWptzyDoSLIsbKCbqCP4cQCx6SJNpx096HV")
	            		.setOAuthAccessToken("2319024174-WnEjIfO9b2VIRLyfLIKPVwlZNYFgYBUDpfd7Kzv")
	            		.setOAuthAccessTokenSecret("hHPkfpTE91hYdxN0MALdZmIU1uTWziMO0f54eaxTwRxQT");

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter unauthenticatedTwitter = tf.getInstance();
		final String tweet;
        try 
        {
	        Paging paging = new Paging(1, 10);
	        List<Status> statuses = unauthenticatedTwitter.getUserTimeline(twitter_id, paging);
	        if(statuses.get((number-1)).getText() != null){
		        tweet = "<time>" + statuses.get(0).getCreatedAt().toString() + "</time><p>" + statuses.get(0).getText() + "</p>";
		        return tweet;
	        }
	        else
	        {
	        	return "User has no tweets";
	        }
        } catch (TwitterException te) {
	        System.out.println("Failed to get TwitterUser's Status (TwitterException) : "
	                                        + te.getMessage());
	        te.printStackTrace();
        }
        return null;
	}
	
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
	
	public static String createSelectListProvince(ArrayList<String[]> array, String province) {
		int pr =0;
        StringBuffer sb = new StringBuffer();
        if(province!=null) pr = Integer.parseInt(province);
        if(pr==0) sb.append("<option value=\"0\" selected=\"selected\">select province</option>");
        else      sb.append("<option value=\"0\">select province</option>");
        if(array.size()>0) 
        {
        	int i;
        	for(i=0;i<array.size();i++)
        	{
        		if(pr==(i+1)) sb.append("<option value=\"" + array.get(i)[0] + "\"selected=\"selected\">" + array.get(i)[1] + "</option>\n");
        		else      sb.append("<option value=\"" + array.get(i)[0] + "\">" + array.get(i)[1] + "</option>\n");
                
        	}
        }
        return sb.toString();
    }
	
	public static String createSelectListCity(ArrayList<String[]> array, String province, String city) {
		int ct =0;
		int pr =0;
        StringBuffer sb = new StringBuffer();
        if(province!=null) pr = Integer.parseInt(province);
        if(pr == 0) return "";
        if(city!=null) ct = Integer.parseInt(city);
        if(ct==0) sb.append("<option value=\"0\" selected=\"selected\">select city</option>");
        else      sb.append("<option value=\"0\">select city</option>");
        int i;
        for(i=0;i<array.get(pr).length;i++)
        {
        	if(ct==(i+1)) sb.append("<option value=\"" + (i+1) + "\"selected=\"selected\">" + array.get(pr-1)[i] + "</option>\n");
        	else      sb.append("<option value=\"" + (i+1) + "\">" + array.get(pr-1)[i] + "</option>\n");
        }
        sb.append("<option value=\"" + (i+1) + "\">add city</option>\n");
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
	 * @param rset
	 * @param user_id
	 * @return
	 */
	public static String createIncidentReportTable(String language, ArrayList<String[]> rset, String user_id) {
        StringBuffer sb = new StringBuffer(); 
        int i;
        String info_button="";
        String popUpWindow="";
        // generates the beginning of the table
        sb.append("<table name=\"caseTable\" class=\"table table-hover\">");
        sb.append(  "<thead style=\"display:block; width:750px;\">"	+
        			"<style>th{ width:150px;}</style>" 	+
        			"<style>td{ width:150px;}</style>" 	+
        			"<tr><th>"+ getWord(language, "inicdentTablePlate")+"</th>"	+
        			"<th>"+ getWord(language, "inicdentTableProv")+"</th>"		+
        			"<th>"+ getWord(language, "inicdentTableCity")+"</th>"			+
        			"<th>"+ getWord(language, "inicdentTableStatus")+"</th>"		+
        			"<th>"+ getWord(language, "inicdentTableAction")+"</th></tr></thead>");
        sb.append(	"<tbody style=\" display:block; overflow-y:auto; height:350px; width:765px; \">");
        
        // generates each row of the table based on query results set
        if(rset.size()>0)
        {
        	for(i=0;i<rset.size();i++) 
        	{  
        		String actionButtons="";        		
        		if(rset.get(i)[9].compareTo("new")==0)
        		{
        			actionButtons="<input type=\"submit\" name=\"action\" class=\"btn btn-primary btnView\" value=\""+ getWord(language, "PopUpTake") +"\"><input type=\"submit\" name=\"action\" class=\"btn btn-primary btnView\" value=\""+ getWord(language, "PopUpDecline") +"\">";
        		}else if(rset.get(i)[9].compareTo("in progress")==0)
        		{
        			actionButtons="<input type=\"submit\" name=\"action\" class=\"btn btn-primary btnView\" value=\""+ getWord(language, "PopUpSave") +"\"><input type=\"submit\" name=\"action\" class=\"btn btn-primary btnView\" value=\""+ getWord(language, "PopUpCloseCase") +"\">";
        		}else if(rset.get(i)[9].compareTo("completed")==0){
        			
        		}
        		
        		// generates the view button for each case row
        		info_button="<a href=\"#myModal"+rset.get(i)[0]+"\" class=\"btn btn-primary btnView\" data-toggle=\"modal\">"+ getWord(language, "inicdentTableView") +"</a>";
        		popUpWindow= UtilsDB.createPopUpWindow(language, rset.get(i), actionButtons, rset.get(i)[0], Long.parseLong(user_id));
        		sb.append(	"<form action=\"caseServlet\" method=\"post\">"+
        					"<input type=\"hidden\" name=\"hdn_case_id\" value=\""+ rset.get(i)[0] + "\"/>" +
        					"<input type=\"hidden\" name=\"hdn_user_id\" value=\""+user_id+"\"/>" +
        					"<tr><td>"+rset.get(i)[2]+"</td>"+
        						"<td>"+rset.get(i)[7]+"</td>"+
        						"<td>"+rset.get(i)[8]+"</td>"+
        						"<td>"+rset.get(i)[9]+"</td>"+
        					"<td>"+info_button+popUpWindow+"</td></tr></form>");
        	} 
        }
        sb.append("</tbody></table>"); 
        return sb.toString();
    }
	
	/**
	 * 
	 * @param caseDetails
	 * @param actionButtons
	 * @param modalNumber
	 * @param user_id
	 * @return
	 */
	public static String createPopUpWindow(String language, String[] caseDetails, String actionButtons, String modalNumber, long user_id){
		StringBuffer sbPopUp = new StringBuffer();
		ArrayList<String[]> caseActions = DataBaseStandardUtilities.getIncidentActions(caseDetails[0]);
		sbPopUp.append("<div id=\"myModal"+modalNumber+"\" class=\"modal fade\">");
		sbPopUp.append(		"<div class=\"modal-dialog\" style=\"width:60%\">");
		sbPopUp.append(			"<div class=\"modal-content\">");
		sbPopUp.append(				"<div class=\"modal-header\">");
		sbPopUp.append(					"<button type=\"submit\" name=\"action\" class=\"close\" value=\"close modal\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>");
		sbPopUp.append(					"<h4 class=\"modal-title\">"+ getWord(language, "PopUpID") +" "+caseDetails[0]+"</h4>");
		sbPopUp.append(				"</div>");
		sbPopUp.append(				"<div class=\"modal-body\">");
		sbPopUp.append(					"<div class=\"row\">");
		sbPopUp.append(						"<section class=\"col-md-10\">");
		sbPopUp.append(							"<iframe width=\"300\" height=\"169\" src=\""+caseDetails[3]+"\" frameborder=\"0\"></iframe>");
		sbPopUp.append(						"</section>");
		sbPopUp.append(						"<section class=\"col-md-10\">");
		sbPopUp.append(							"<label for=\"userDescription\">"+ getWord(language, "PopUpUserDesc") +"</label><br>");
		sbPopUp.append(							"<style>textarea[name=userDescription] {resize: none; font-size: 12px; border: none;}</style>");
		sbPopUp.append(							"<textarea name=\"userDescription\" rows=\"7\" cols=\"40\" readonly wrap=\"soft\">"+caseDetails[4]+"</textarea>");
		sbPopUp.append(						"</section>");
		sbPopUp.append(					"</div>");//close row
		sbPopUp.append(					"<div class\"row\">");
		if (caseActions.size() != 0){ 
		// if case action has details
			boolean userActionFound=false;
			for(int j=0; j< caseActions.size(); ++j){ 
			//go through the multiple incident action to find the user action
				Long caseActionUserID = Long.parseLong(caseActions.get(j)[0]);
				if ( caseActionUserID == user_id){
				// if one is found add it to popup window
					sbPopUp.append(							"<label for=\"officerNotes\">"+ getWord(language, "PopUpOffNotes") +"</label><br>");
					sbPopUp.append(							"<textarea class=\"form-control\" name=\"officerNotes\" style=\"resize: none; font-size: 12px;\" rows=\"5\" cols=\"95\">" +caseActions.get(0)[2]+"</textarea>");
					userActionFound = true;
					break;
				}
			}
			if(!userActionFound){
			// if none are found put default
				sbPopUp.append(							"<label for=\"officerNotes\">"+ getWord(language, "PopUpOffNotes") +"</label><br>");
				sbPopUp.append(							"<textarea style=\"resize: none; font-size: 12px;\" name=\"officerNotes\" rows=\"5\" cols=\"95\" readonly wrap=\"soft\"></textarea>");				
			}
		}else{ 
		// it doesn't have details and is probably new so put default
			sbPopUp.append(							"<label for=\"officerNotes\">"+ getWord(language, "PopUpOffNotes") +"</label><br>");
			sbPopUp.append(							"<textarea style=\"resize: none; font-size: 12px;\" name=\"officerNotes\" rows=\"5\" cols=\"95\" readonly wrap=\"soft\"></textarea>");
		}
		sbPopUp.append(					"</div>");
		sbPopUp.append(					"<div>");
		sbPopUp.append(					actionButtons);
		sbPopUp.append(					"</div>");
		sbPopUp.append(				"</div>"); // modal body end
		sbPopUp.append(				"<div class=\"modal-footer\">");
		sbPopUp.append(					"<button type=\"submit\" name=\"action\" class=\"btn btn-default\" value=\"close modal\" data-dismiss=\"modal\">"+ getWord(language, "PopUpClose") +"</button>");
		sbPopUp.append(				"</div>"); // modal footer end
		sbPopUp.append(			"</div>"); // modal content end
		sbPopUp.append(		"</div>"); // modal-dialog end
		sbPopUp.append("</div>"); // modal end
		
		return sbPopUp.toString();
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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
	    if(page.compareTo("signUp.jsp")==0) //"createReport"
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
        
        //RequestDispatcher rd=request.getRequestDispatcher(pageJSP);    
        //rd.include(request,response);
        response.sendRedirect(pageJSP);
	    out.close();
    }

}