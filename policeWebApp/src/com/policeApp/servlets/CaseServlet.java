package com.policeApp.servlets;
//
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.UtilsDB;

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
    	String notes = request.getParameter("officerNotes");
        HttpSession session = request.getSession(false);
        String language = (String)session.getAttribute("language");
        
        if (action.compareTo(UtilsDB.getWord(language, "PopUpTake"))==0)
        {
        	if(!DataBaseStandardUtilities.takeCase(caseId, userId))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        } 
        if (action.compareTo(UtilsDB.getWord(language, "PopUpCloseCase"))==0)
        {
        	if(!DataBaseStandardUtilities.closeCase(caseId, userId, notes))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        } 
        if (action.compareTo(UtilsDB.getWord(language, "PopUpDecline"))==0)
        {
        	if(!DataBaseStandardUtilities.declineCase(caseId, userId))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        }
        if (action.compareTo(UtilsDB.getWord(language, "PopUpSave"))==0)
        {
        	if(!DataBaseStandardUtilities.updateCaseComment(caseId, userId, notes))
        		out.print("<p style=\"color:red\">DataBase failed</p>");  
        } 
        if (action.compareTo("close modal")==0)
        {
        	//do nothing for now
        } 

    	RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
        rd.forward(request,response);
    	out.close();
    }

}
