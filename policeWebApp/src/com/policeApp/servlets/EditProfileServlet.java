package com.policeApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    	String userId = request.getParameter("hdn_user_id");
		HttpSession session = request.getSession(false);  
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
        }else{
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
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
		
	}

}
