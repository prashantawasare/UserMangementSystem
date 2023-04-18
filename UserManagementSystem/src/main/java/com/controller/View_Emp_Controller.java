package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpInfo;
import com.Dao.DaoClass;

/**
 * Servlet implementation class View_Emp_Controller
 */
@WebServlet("/View_Emp_Controller")
public class View_Emp_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Emp_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
	     PrintWriter pw=response.getWriter();

		   pw.print("<link rel=\"stylesheet\" href=\"css/styles.css\">");
	     pw.print("<table>");

	     pw.print("<script src=https://kit.fontawesome.com/a076d05399.js crossorigin=anonymous></script>");
	     List<EmpInfo> list=DaoClass.getEmployeedata();
	     
         
	   pw.print("<table border='1px solid black'; width='100%'; style='border: 2px solid grey;\r\n"
	   		
	   		+ "            text-align: center;\r\n"
	   		
	   		+ "       margin-top: 50px;\r\n"
	   		+ "       padding: 50px 50px 50px 50px;\r\n"
	   		+ "       background-color: lightpink;\r\n"
	   		+ "       \r\n"
	   		+ "       border-radius: 10px 10px 10px 10px;'> ");
	     pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Designation </th> <th> Address </th> <th> Doj </th> <th> Pkg </th><th>Edit</th><th>Delete</th> </tr>");
           
	     
	    	 pw.print("<h1 style='text-align: center;color:burlywood;'>USER INFORMATION</h1>");
	         
	    	 for(EmpInfo eb:list) {
	    	 pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDesignation()+"</td><td>"+eb.getAdress()
	    	 +"</td><td>"+eb.getDoj()+"</td><td>"+eb.getPkg()+"</td><td>"+"<a href=EditServlet2?id="+eb.getId()+"> <i class='fas fa-edit'> </i> </a> </td> <td> <a href=DeleteServlet?id="+eb.getId()+"> <i class=\"fas fa-trash-alt\" style=\" color:red;\"> </i> </a></td></tr>");
	                                           
	    	 
	     }
	     
		pw.print("</table>");
		
		
	}

}
