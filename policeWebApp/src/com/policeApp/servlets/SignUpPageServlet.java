package com.policeApp.servlets;

import java.io.IOException;  
import java.io.PrintWriter;  

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
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
           
          
        HttpSession session = request.getSession(false);  
        if(session!=null)
        {
        	session.setAttribute("budge", "");  
        	session.setAttribute("accessCode", "");
        	session.setAttribute("userName", "");
        	session.setAttribute("userFirstName", "");
        	session.setAttribute("userLastName", "");
        	session.setAttribute("email", "");
        	session.setAttribute("phone", "");
        	session.setAttribute("province", "0");
        	session.setAttribute("city", "0");
        }
  
        
        //RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");  
        response.sendRedirect("signUp.jsp");
        //rd.forward(request,response);      
  
        out.close();    
    } 
    
    /**
     * 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException { 
    	HttpSession session = request.getSession(false);  
    	String language = (String)session.getAttribute("language");
    	request.setCharacterEncoding("UTF-8");
    	String action = request.getParameter("action");
        if (action.compareTo(UtilsDB.getWord(language, "addCity"))==0) {
        	UtilsDB.addCity(request, response);
        	return;
        }
        if (action.compareTo(UtilsDB.getWord(language, "backButton"))==0) {
        	//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            //rd.forward(request,response);
        	response.sendRedirect("index.jsp");
          	return;
         }
    	boolean badArg=false;
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
          
        String budge=request.getParameter("budge");    
        String accessCode=request.getParameter("accessCode");
        String userName=request.getParameter("email");  
        String email=request.getParameter("userName");  
        String firstName=request.getParameter("userFirstName"); 
        String lastName=request.getParameter("userLastName"); 
        String phone=request.getParameter("phoneNumber");  
        String password=request.getParameter("password");
        String passwordConfirm=request.getParameter("confirmPassword");  
        String selectProvince=request.getParameter("province");
        String selectCity=request.getParameter("city");
        
        if(budge.length()<=0)badArg=true;
        else session.setAttribute("budge", budge);
        if(accessCode.length()<=0)badArg=true;
        else session.setAttribute("accessCode", accessCode);
        if(userName.length()<=0)badArg=true;
        else session.setAttribute("userName", userName);
        if(firstName.length()<=0)badArg=true;
        else session.setAttribute("userFirstName", firstName);
        if(lastName.length()<=0)badArg=true;
        else session.setAttribute("userLastName", lastName);
        if(email.length()<=0)badArg=true;
        else session.setAttribute("email", email);
        if(phone.length()<=0)badArg=true;
        else session.setAttribute("phone", phone);
        if(password.length()<=0)badArg=true;
        if(passwordConfirm.length()<=0)badArg=true;
        if(selectProvince==null)badArg=true;
        else{if(selectProvince.length()<=0 || selectProvince.compareTo("0")==0)badArg=true;else session.setAttribute("province", selectProvince);}
        if(selectCity==null)badArg=true;
        else{if(selectCity.length()<=0 || selectCity.compareTo("0")==0)badArg=true; else session.setAttribute("city", selectCity);}
        
        
        if(badArg)
        {
        	out.print("<p style=\"color:red\">wrong or missed filed</p>");    
            //RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
            //rd.include(request,response); 
            response.sendRedirect("signUp.jsp");
        }
        else 
        {
	        if(!DataBaseStandardUtilities.checkAccessCode(accessCode, selectProvince, selectCity))
	        {
	        	out.print("<p style=\"color:red\">wrong Access Code</p>");    
	            //RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
	            //rd.include(request,response);  
	            response.sendRedirect("signUp.jsp");
	        }
	        else
	        {
	        	if(password.compareTo(passwordConfirm)==0)
	        	{
	        		password = UtilsDB.encript(password);
	        		if(DataBaseStandardUtilities.addUser(budge, userName, firstName, lastName, email, phone, password, selectProvince, selectCity))
	        		{
	        			//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
	                    //rd.forward(request,response); 
	        			response.sendRedirect("index.jsp");
	        		}
	        		else
	        		{
	        			out.print("<p style=\"color:red\">DataBase failed</p>");    
	                    //RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
	                    //rd.include(request,response);
	        			response.sendRedirect("signUp.jsp");
	        		}
	        		
	        	}
	        	else
	        	{
	        		out.print("<p style=\"color:red\">there is no match password and confirm password field</p>");    
	                //RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");    
	                //rd.include(request,response); 
	        		response.sendRedirect("signUp.jsp");
	        	}
	        	
	        }
        }
        out.close(); 
    	
    }
}
