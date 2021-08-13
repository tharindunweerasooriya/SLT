package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logAPI
 */
@WebServlet("/logAPI")
public class logAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	user itemObj4 = new user(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException 
    		{ 
    		 HttpSession session = request.getSession(); 
    		 String authStatus = itemObj4.login(request.getParameter("EMP_NAME")); 
    		 String output = ""; 
    		if (authStatus.equals("success")) 
    		 { 
    		 output = "{\"status\":\"success\", \"data\": \"\"}"; 
    		 session.setAttribute("EMP_NAME", 
    		 request.getParameter("EMP_NAME"));
    		 } 
    		else
    		 { 
    		 output = "{\"status\":\"error\", \"data\": \"" + authStatus + "\"}"; 
    		 } 
    		 response.getWriter().write(output); 
    		}
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    		 throws ServletException, IOException 
    		{ 
    		 HttpSession session = request.getSession(); 
    		session.invalidate(); 
    		response.getWriter().write("success"); 
    		}

}
