package com.controller;

import java.io.IOException;



import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bo.EmpBo;
import com.Dao.DaoClass;


/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		
		response.setContentType("text/html");
		
     PrintWriter pw=response.getWriter();
     
     String name=request.getParameter("name");
     
     String email=request.getParameter("email");

     String phone=request.getParameter("phone");
     String password=request.getParameter("pwd");
     
   String Confirm_Password=request.getParameter("C_Password");
     
     
     EmpBo eb=new EmpBo(name,email,phone,password,Confirm_Password);
     
     
     int status=DaoClass.save(eb);
     
     
     if(status>0)
     {

    	 RequestDispatcher rs=request.getRequestDispatcher("login.html");
    	 rs.forward(request, response);
     }
     
     else
     {
    	 pw.print("<script>  alert('username or password invalid !!') </script>");
	 RequestDispatcher rs=request.getRequestDispatcher("Signup.html");
	 rs.include(request, response);
	 
	 
     }
     
     
     
     
     
	}

}
