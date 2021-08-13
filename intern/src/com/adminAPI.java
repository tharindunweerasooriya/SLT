package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminAPI
 */
@WebServlet("/adminAPI")
public class adminAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	user itemObj2 = new user(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = itemObj2.insertAdmin(request.getParameter("first_name"), 
				request.getParameter("last_name"), 
				request.getParameter("em"), 
				request.getParameter("usern"),
				request.getParameter("pass"));
		
		response.setContentType("text/html;charset=UTF-8");
	    response.setHeader("Cache-Control", "no-cache");
		
				response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		
		 String output = itemObj2.updateAdmin(paras.get("hidItemIDSaveA").toString(), 
		 paras.get("first_name").toString(), 
		 paras.get("last_name").toString(), 
		 paras.get("em").toString(), 
		 paras.get("usern").toString(),
		 paras.get("pass").toString()); 
		 
		 response.setContentType("text/html;charset=UTF-8");
		    response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{ 
			 Map paras = getParasMap(request); 
			 String output = itemObj2.deleteAdmin(paras.get("id").toString()); 
			 response.getWriter().write(output); 
			}
	}
	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
		Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		String queryString = scanner.hasNext() ? 
				scanner.useDelimiter("\\A").next() : ""; 
				scanner.close(); 
				String[] params = queryString.split("&"); 
				
				for (String param : params) 
				{ 
					String[] p = param.split("=");
					map.put(p[0], p[1]); 
				}
	 
	 } 
	catch (Exception e) 
	 {
		 
	 } 
	return map; 
	
	}

}
