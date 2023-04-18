package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpInfo;
import com.Dao.DaoClass;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
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
	     pw.print("<div>");
	     pw.print("<form  action='updatecontroller' method='Get'> ");
		    
	     String id=request.getParameter("id");
	     
	     int eid=Integer.parseInt(id);
	    
	     EmpInfo eb=DaoClass.getInfobo(eid);
	 
			pw.print("<table style='  border: 2px solid white;\r\n"
					+ "        display: inline-block;\r\n"
					+ "            text-align: center;\r\n"
					+ "       margin-left: 470px;\r\n"
					+ "       margin-top: 150px;\r\n"
					+ "       padding: 50px 50px 50px 50px;\r\n"
					+ "       background-color: lightpink;'>");
			
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
		   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
		   	pw.print("<tr><td>Designation : </td> <td><input type='text' name='desg' value='"+eb.getDesignation()+"'/></td></tr>");
		   	pw.print("<tr><td>Address: </td> <td><input type='text' name='adress' value='"+eb.getAdress()+"'/></td></tr>");
		   	pw.print("<tr><td>Date of Joining: </td> <td><input type='date' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
		   	pw.print("<tr><td>Package </td> <td><input type='text' name='pkg' value='"+eb.getPkg()+"'/></td></tr>");
		    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
		    
		   	pw.print("</table>");
			
			pw.print("</form>");
			
			 pw.print("</div>");
	}

}
