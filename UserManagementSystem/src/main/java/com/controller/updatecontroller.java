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
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 int id=Integer.parseInt(request.getParameter("id"));
         String name=request.getParameter("name");
	     
	     String email=request.getParameter("email");
         
	     String phone=request.getParameter("phone");
	     String desg=request.getParameter("desg");
	     String adress=request.getParameter("adress");
	     String doj=request.getParameter("doj");
	     String pkg=request.getParameter("pkg");
	     
	     EmpInfo eb=new EmpInfo(id, name, email, phone, desg, adress, doj, pkg);
	     
	     int status=DaoClass.updateEmpdata(eb);
	     
	     if(status>0)
	     {
	    	 pw.print("<script> alert('Your data has been succesfully updated')</script>");
	    	 
	    	 RequestDispatcher rd=request.getRequestDispatcher("View_Emp_Controller");
	    	 rd.include(request, response);
	     }
		
	     else
	     {

	    	 pw.print("<script> alert('Sorry  something went wrong')</script>");
	    	 RequestDispatcher rd=request.getRequestDispatcher("View_Emp_Controller");
	    	 rd.include(request, response);
	    	 
	     }
	}
    
	
}
