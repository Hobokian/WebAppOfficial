package com.policeApp.servlets;  

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

import utils.UtilsDB;

import com.policeApp.db.DataBaseStandardUtilities;


public class MenuServlet extends HttpServlet{  
 
   private static final long serialVersionUID = 1L;  
 
   /**
    * 
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response)    
           throws ServletException, IOException { 
	   
        HttpSession session = request.getSession(false);
		response.setContentType("text/html");      
		int searchCmd = Integer.parseInt((String)request.getParameter("hdn_menu_command"));
		String filter = "";
		
		switch(searchCmd){
		case 0: // Home
			filter = null;
			break;
		case 1: // My Cases
			filter = "join incident_action on incident_action.incidentReports_id = incidentreports.id ";
			filter += "where incident_action.userInfos_id =" + (String)session.getAttribute("id")+ " ";
			filter += "and incidentreports.incident_status_id = 2";
			session.setAttribute("filter", filter);
			break;
		case 2: // My City's cases
			String CityID = DataBaseStandardUtilities.getUsersCityID((String)session.getAttribute("id"));
			filter = "where location.citylookup_id = " + CityID;
			session.setAttribute("filter", filter);
			break;
		case 3: // My Provinces Cases
			String ProvinceID = DataBaseStandardUtilities.getUsersProvinceID((String)session.getAttribute("id"));
			filter = "where location.province_id = " + ProvinceID;
			session.setAttribute("filter", filter);
			break;
		case 4: // History
			filter = "join incident_action on incident_action.incidentReports_id = incidentreports.id ";
			filter += "where incident_action.userInfos_id =" + (String)session.getAttribute("id");
			session.setAttribute("filter", filter);
			break;
		default:
			filter = null;
		
		}
		
		session.setAttribute("filter", filter); 	   
        response.sendRedirect("welcome.jsp");
 
   }    
}