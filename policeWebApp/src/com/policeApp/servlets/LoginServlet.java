 package com.policeApp.servlets;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
 
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
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
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String budge=request.getParameter("username");    
        String password=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  

        
        if(DataBaseStandardUtilities.validate(budge, password)){  
            if(session!=null)  
            {
            	session.setAttribute("id", DataBaseStandardUtilities.getUserId(budge));
            	session.setAttribute("name", DataBaseStandardUtilities.getUserName(budge));
            	session.setAttribute("table", DataBaseStandardUtilities.getSelectedIncidents(null,DataBaseStandardUtilities.getUserId(budge)));
            	session.setAttribute("twitterProv", DataBaseStandardUtilities.getUsersProvince(DataBaseStandardUtilities.getUserId(budge)));
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