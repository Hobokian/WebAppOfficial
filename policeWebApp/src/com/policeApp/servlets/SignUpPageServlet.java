package com.policeApp.servlets;

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
  
/**
 * 
 * @author Iaroslav Malyshev
 *
 */
public class SignUpPageServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    /**
     * 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
           
          
        HttpSession session = request.getSession(false);  
        if(session!=null)
        {
        	session.setAttribute("budge", "");
        	session.setAttribute("accessCode", "");
        	session.setAttribute("userName", "");
        	session.setAttribute("email", "");
        	session.setAttribute("phone", "");
        }
  
        RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
        rd.forward(request,response);    
          
  
        out.close();    
    } 
    
    /**
     * 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException { 
    	String action = request.getParameter("action");
        if (action.compareTo("Add City")==0) {
        	UtilsDB.addCity(request, response);
        	return;
        }
    	boolean badArg=false;
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
          
        String budge=request.getParameter("budge");    
        String accessCode=request.getParameter("accessCode");
        String userName=request.getParameter("email");  
        String email=request.getParameter("userName");  
        String phone=request.getParameter("phoneNumber");  
        String password=request.getParameter("password");
        String passwordConfirm=request.getParameter("confirmPassword");  
        String selectProvince=request.getParameter("province");
        String selectCity=request.getParameter("city");
        
        HttpSession session = request.getSession(false); 
        
        if(budge.length()<=0)badArg=true;
        else session.setAttribute("budge", budge);
        if(accessCode.length()<=0)badArg=true;
        else session.setAttribute("accessCode", accessCode);
        if(userName.length()<=0)badArg=true;
        else session.setAttribute("userName", userName);
        if(email.length()<=0)badArg=true;
        else session.setAttribute("email", email);
        if(phone.length()<=0)badArg=true;
        else session.setAttribute("phone", phone);
        if(password.length()<=0)badArg=true;
        if(passwordConfirm.length()<=0)badArg=true;
        if(selectProvince==null)badArg=true;
        else{if(selectProvince.length()<=0 || selectProvince.compareTo("0")==0)badArg=true;}
        if(selectCity==null)badArg=true;
        else{if(selectCity.length()<=0 || selectCity.compareTo("0")==0)badArg=true;}
        
        
        if(badArg)
        {
        	out.print("<p style=\"color:red\">wrong or missed filed</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
            rd.include(request,response); 
        }
        else 
        {
	        if(!DataBaseStandardUtilities.checkAccessCode(accessCode, selectProvince, selectCity))
	        {
	        	out.print("<p style=\"color:red\">wrong Access Code</p>");    
	            RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
	            rd.include(request,response);  
	        }
	        else
	        {
	        	if(password.compareTo(passwordConfirm)==0)
	        	{
	        		if(DataBaseStandardUtilities.addUser(budge, userName, email, phone, password, selectProvince, selectCity))
	        		{
	        			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
	                    rd.forward(request,response); 
	        		}
	        		else
	        		{
	        			out.print("<p style=\"color:red\">DataBase failed</p>");    
	                    RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
	                    rd.include(request,response);
	        		}
	        		
	        	}
	        	else
	        	{
	        		out.print("<p style=\"color:red\">there is no match password and confirm password field</p>");    
	                RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
	                rd.include(request,response); 
	        	}
	        	
	        }
        }
        out.close(); 
    	
    }
}
