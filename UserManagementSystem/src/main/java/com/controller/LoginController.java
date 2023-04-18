package com.controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DaoClass;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	     PrintWriter pw=response.getWriter();
	     
	     String email=request.getParameter("email");
	     
	     String pwd=request.getParameter("password");
	     
	     boolean status=false;
	     
	     status=DaoClass.LoginValidate(email, pwd);
	     
	     if(status)
	     {
	    	 
	    	 RequestDispatcher rs=request.getRequestDispatcher("home.html");
	    	 rs.forward(request, response);
	     }
	     else
	     {
	    	 pw.print("<script>  alert('username or password invalid !!') </script>");
	    	 RequestDispatcher rs=request.getRequestDispatcher("login.html");
	    	 rs.include(request, response);
	     }
		
	}

}
