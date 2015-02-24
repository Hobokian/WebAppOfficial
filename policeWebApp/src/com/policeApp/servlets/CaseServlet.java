package com.policeApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.policeApp.db.DataBaseStandardUtilities;


public class CaseServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    /**
     * 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException { 
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
    	String caseId = request.getParameter("hdn_case_id");
    	String userId = request.getParameter("hdn_user_id");
    	String action = request.getParameter("action");
        if (action.compareTo("take case")==0)
        {
        	if(!DataBaseStandardUtilities.takeCase(caseId, userId))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        } 
        if (action.compareTo("close case")==0)
        {
        	if(!DataBaseStandardUtilities.closeCase(caseId, userId))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        } 
        if (action.compareTo("decline case")==0)
        {
        	if(!DataBaseStandardUtilities.declineCase(caseId, userId))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        } 
        if (action.compareTo("close modal")==0)
        {
        	//do nothing for now
        } 

        HttpSession session = request.getSession(false);  
        if(session!=null)  
        {
        	session.setAttribute("table", DataBaseStandardUtilities.getSelectedIncidents(null,userId));
        }
    	RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
        rd.forward(request,response);
    	out.close();
    }

}
