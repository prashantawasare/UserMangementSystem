package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpInfo;
import com.Dao.DaoClass;

/**
 * Servlet implementation class EmpInformation
 */
@WebServlet("/EmpInformation")
public class EmpInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	     PrintWriter pw=response.getWriter();
	     
	     String name=request.getParameter("name");
	     
	     String email=request.getParameter("email");

	     String phone=request.getParameter("phone");
	     String desg=request.getParameter("desg");
	     String adress=request.getParameter("adress");
	     String doj=request.getParameter("doj");
	     String pkg=request.getParameter("pkg");
	     
	     
	     EmpInfo ei=new EmpInfo(name, email, phone, desg, adress, doj, pkg);
	     int status=DaoClass.Emp_details(ei);
	     
	     if(status>0)
	     {
	    	 
                 pw.print("<script> alert('Your data has been succesfully Inserted')</script>");
                 RequestDispatcher rs=request.getRequestDispatcher("home.html");
    	    	 rs.include(request, response);
	    	     
                 
	    	 
	     }
	     else
	     {
	    	 pw.print("error");
	    	 RequestDispatcher rs=request.getRequestDispatcher("home.html");
	    	 rs.include(request, response);
	     }
	}

}
