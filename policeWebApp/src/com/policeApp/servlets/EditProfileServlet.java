package com.policeApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.UtilsDB;

import com.policeApp.db.DataBaseStandardUtilities;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();    
    	String userId;
		HttpSession session = request.getSession(false);  
		userId = (String) session.getAttribute("id");
        if(session!=null)  
        {
        	String[] userInfo = DataBaseStandardUtilities.getUserInfo(userId);
        	session.setAttribute("budge", userInfo[1]);
        	session.setAttribute("userName", userInfo[2]);
        	session.setAttribute("userFirstName", userInfo[3]);
        	session.setAttribute("userLastName", userInfo[4]);
        	session.setAttribute("email", userInfo[6]);
        	session.setAttribute("phone", userInfo[7]);
        	//Province
        	//City
        	RequestDispatcher rd=request.getRequestDispatcher("editProfile.jsp");    
            rd.forward(request,response);
        }
    	RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
        rd.forward(request,response);
    	out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);  
        Cookie langCookie = UtilsDB.getLangCookie(request, response) ;
        String language = langCookie.getValue();
    	request.setCharacterEncoding("UTF-8");
    	String action = request.getParameter("action");
        if (action.compareTo(UtilsDB.getWord(language, "addCity"))==0) {
        	UtilsDB.addCity(request, response);
        	return;
        }
        if (action.compareTo(UtilsDB.getWord(language, "backButton"))==0) {
        	response.sendRedirect("welcome.jsp");
          	return;
         }
    	boolean badArg=false;
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();
        
        String user_id=(String) session.getAttribute("id");
        String budge=request.getParameter("budge");    
        String email=request.getParameter("email");  
        String userName=request.getParameter("userName");  
        String firstName=request.getParameter("userFirstName"); 
        String lastName=request.getParameter("userLastName"); 
        String phone=request.getParameter("phoneNumber");  
        String oldPassword=request.getParameter("oldPassword");
        String newPassword=request.getParameter("newPassword");
        String passwordConfirm=request.getParameter("confirmPassword");  
        String selectProvince=request.getParameter("province");
        String selectCity=request.getParameter("city");
        
        
        
        if(budge.length()<=0)badArg=true;
        else session.setAttribute("budge", budge);
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
        if(oldPassword.length()<=0)badArg=true;
        if(selectProvince==null)badArg=true;
        else{if(selectProvince.length()<=0 || selectProvince.compareTo("0")==0)badArg=true;else session.setAttribute("province", selectProvince);}
        if(selectCity==null)badArg=true;
        else{if(selectCity.length()<=0 || selectCity.compareTo("0")==0)badArg=true; else session.setAttribute("city", selectCity);}
        
        
        if(badArg)
        {
        	out.print("<p style=\"color:red\">wrong or missed filed</p>");    
            response.sendRedirect("editProfile.jsp");
        }
        else 
        {
            oldPassword = UtilsDB.encript(oldPassword);
	        if(!DataBaseStandardUtilities.validate(budge, oldPassword)){ 
	        	out.print("<p style=\"color:red\">Old password does NOT match</p>");    
	            response.sendRedirect("editProfile.jsp");
	        }
	        
	        if(newPassword.length() > 0){
	        
	        	if(newPassword.compareTo(passwordConfirm)==0)
	        	{
	        		newPassword = UtilsDB.encript(newPassword);
	        		if(DataBaseStandardUtilities.editUser(user_id, budge, userName, firstName, lastName, email, phone, newPassword, selectProvince, selectCity))
	        		{
	        			session.invalidate();
	        			session.setAttribute("bFirst", 1);
	        			response.sendRedirect("index.jsp");
	        		}
	        		else
	        		{
	        			out.print("<p style=\"color:red\">DataBase failed</p>");    
	        			response.sendRedirect("editProfile.jsp");
	        		}
	        		
	        	}
	        	else
	        	{
	        		out.print("<p style=\"color:red\">there is no match password and confirm password field</p>");    
	        		response.sendRedirect("editProfile.jsp");
	        	}
	        }
	        else{
		        if(DataBaseStandardUtilities.editUser(user_id, budge, userName, firstName, lastName, email, phone, null, selectProvince, selectCity))
	    		{
	            	session.setAttribute("name", DataBaseStandardUtilities.getName(user_id));
	    			response.sendRedirect("welcome.jsp");
	    		}
	    		else
	    		{
	    			out.print("<p style=\"color:red\">DataBase failed</p>");    
	    			response.sendRedirect("editProfile.jsp");
	    		}
	        }
	        	
        }
        out.close();
	}

}
