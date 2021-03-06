package com.policeApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
public class CreateComplainServlet extends HttpServlet{
	  
    private static final long serialVersionUID = 1L;  
  
    /**
     * 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
		response.setContentType("text/html");    
	    PrintWriter out = response.getWriter();    
	      
	    String email=request.getParameter("email");    
	    String phone=request.getParameter("phone");
	    if(email==null)email="Anonymous";
	    if(phone==null)phone="Anonymous";
	    
	    HttpSession session= null;
	    session = request.getSession(false);
	    if(session!=null) session = request.getSession(true);
	    if(session!=null)  
	    {
	    	session.setAttribute("email", email); 
	    	session.setAttribute("phone", phone); 
	    	session.setAttribute("plateNumber", "");
	    	session.setAttribute("URLlink", "");
	    	session.setAttribute("street", "");
	    	session.setAttribute("postalCode", "");
	    	session.setAttribute("description", "");
	    	session.setAttribute("province", "0");
        	session.setAttribute("city", "0");
	    }
	    if (email.compareTo("")==0 && phone.compareTo("")==0)
	    {
	    	out.print("<p style=\"color:red\">Please use Anonymous access or enter email or phone</p>");
	    	//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	    	//rd.include(request,response); 
	    	response.sendRedirect("report.jsp");
	    }
	    else
	    {
	    	//RequestDispatcher rd=request.getRequestDispatcher("report.jsp");    
	        //rd.forward(request,response); 
	        response.sendRedirect("report.jsp");
	    }   
	    
	    out.close(); 
    }
    
    /**
     * 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException { 
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
        	//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            //rd.forward(request,response);
            response.sendRedirect("index.jsp");
          	return;
         }
    	 boolean badArg=false;
    	 String user;
    	 int caseNumber;
    	 response.setContentType("text/html");    
         PrintWriter out = response.getWriter();
        
    	 String email = (String) session.getAttribute("email");
         String phone = (String) session.getAttribute("phone");
         String plateNumber=request.getParameter("plateNumber");    
         String URLlink=request.getParameter("URLlink");  
         String street=request.getParameter("street"); 
         String postalCode=request.getParameter("postalCode");
         String description=request.getParameter("description");
    	 String selectProvince=request.getParameter("province");
    	 String selectCity=request.getParameter("city");
         
    	 if(plateNumber.length()<=0)badArg=true;
         else session.setAttribute("plateNumber", plateNumber);
    	 if(URLlink.length()<=0)badArg=true;
         else session.setAttribute("URLlink", URLlink);
    	 if(street.length()<=0)badArg=true;
         else session.setAttribute("street", street);
    	 if(postalCode.length()<=0)badArg=true;
         else session.setAttribute("postalCode", postalCode);
    	 if(description.length()<=0)badArg=true;
         else session.setAttribute("description", description);
         if(selectProvince==null)badArg=true;
         else{if(selectProvince.length()<=0 || selectProvince.compareTo("0")==0)badArg=true;else session.setAttribute("province", selectProvince);}
         if(selectCity==null)badArg=true;
         else{if(selectCity.length()<=0 || selectCity.compareTo("0")==0)badArg=true; else session.setAttribute("city", selectCity);}
         
         if(email.length()>0)user=email;
         else user=phone;
         
         if(badArg)
         {
        	 out.print("<p style=\"color:red\">wrong or missed filed</p>");    
             //RequestDispatcher rd=request.getRequestDispatcher("report.jsp");    
             //rd.include(request,response); 
             response.sendRedirect("report.jsp");
         }
         else
         {
        	 selectCity=DataBaseStandardUtilities.getRealIndexOfCity(selectProvince, selectCity);
        	 caseNumber=DataBaseStandardUtilities.createReport(user, plateNumber, URLlink, description, street, postalCode, selectCity, selectProvince);
        	 if(caseNumber!=0)
        	 {
        		 session.setAttribute("newCaseID", caseNumber);
        		 //RequestDispatcher rd=request.getRequestDispatcher("Thanks.jsp");    
                 //rd.forward(request,response); 
        		 response.sendRedirect("Thanks.jsp");
        	 }
        	 else
        	 {
        		 out.print("<p style=\"color:red\">Fail database. please try again later</p>");
        		 //RequestDispatcher rd=request.getRequestDispatcher("report.jsp");    
                 //rd.include(request,response); 
        		 response.sendRedirect("report.jsp");
        	 }
         }
         out.close();
    }
}
