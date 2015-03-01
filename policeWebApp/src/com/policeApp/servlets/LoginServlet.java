 package com.policeApp.servlets;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
 


import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  


import utils.UtilsDB;
import utils.WebSecurity;

import com.policeApp.db.DataBaseStandardUtilities;
  
/**
 * <i>LoginServlet</i> class to realize sign in button to cabin 
 * @author Iaroslav Malyshev
 *
 */
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    /**
     * 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {      
    	String id;
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String budge=request.getParameter("username");    
        String password=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        password = UtilsDB.encript(password);
        
        if(DataBaseStandardUtilities.validate(budge, password)){  
            if(session!=null)  
            {
            	id =DataBaseStandardUtilities.getUserId(budge);
            	session.setAttribute("id", id);
            	session.setAttribute("name", DataBaseStandardUtilities.getName(id));
            	session.setAttribute("table", DataBaseStandardUtilities.getSelectedIncidents(null,id));
            	session.setAttribute("twitterProv", DataBaseStandardUtilities.getUsersProvinceTwiterId(id));
            }
            //RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            //rd.forward(request,response);
            response.sendRedirect("welcome.jsp");
        }    
        else{    
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            //rd.include(request,response);  
            response.sendRedirect("index.jsp");
        }    
  
        out.close();    
    }    
}