package com.Dao;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.Bo.EmpBo;
import com.Bo.EmpInfo;

public class DaoClass {
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","prashant");
		 
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		
		return con;
		
	}
	
	public static int save(EmpBo eb)
	{
		int status=0;
		
		Connection con=DaoClass.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into signup (name,email,phone,password,confirm_password) values(?,?,?,?,?)");
			
			ps.setString(1, eb.getName());
			ps.setString(2, eb.getEmail());
			ps.setString(3, eb.getPhone());
			ps.setString(4, eb.getPassword());
			ps.setString(5, eb.getConfirm_password());
			
			
		status=	ps.executeUpdate();
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
		
	}

	public static boolean LoginValidate(String email,String pass)
	{
		boolean status=false;
		System.out.println(email+" "+pass);

		
		try {
			
			Connection con=DaoClass.getConnection();String sql="select *from signup where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			
		ResultSet rs =ps.executeQuery();
		     status=rs.next();
		     
		    
		    
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int Emp_details(EmpInfo eb)
	{
		int status=0;
		
		Connection con=DaoClass.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into addEmp (name,email,phone,designation,adress,doj,pkg) values(?,?,?,?,?,?,?)");
			
			ps.setString(1, eb.getName());
			ps.setString(2, eb.getEmail());
			ps.setString(3, eb.getPhone());
			ps.setString(4, eb.getDesignation());
			ps.setString(5, eb.getAdress());
			ps.setString(6, eb.getDoj());
			ps.setString(7, eb.getPkg());
			
			
			
		status=	ps.executeUpdate();
		
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
		
	}
	
	public static List getEmployeedata()
	{
		List< EmpInfo> li=new ArrayList<>();
		
		try {
			
			Connection con=DaoClass.getConnection();
			
			String sql="select * from addEmp";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next())
			 {
				 EmpInfo eb=new EmpInfo();
				 eb.setId(rs.getInt(1));
				 eb.setName(rs.getString(2));
				 eb.setEmail(rs.getString(3));
				 eb.setPhone(rs.getString(4));
				 eb.setDesignation(rs.getString(5));
				 eb.setAdress(rs.getString(6));
				 eb.setDoj(rs.getString(7));
				 eb.setPkg(rs.getString(8));
				 
				 li.add(eb);
				 
			 }
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		
		return li;
	}
	
	public static EmpInfo getInfobo(int eid)
	{
		
		EmpInfo eb=new EmpInfo();
		
		try {
Connection con=DaoClass.getConnection();
			
			String sql="select * from addEmp where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, eid);
			 ResultSet rs=ps.executeQuery();
			 
			 if(rs.next())
			 {
				 eb=new EmpInfo();
			     eb.setId(eid);
				 eb.setName(rs.getString(2));
				 eb.setEmail(rs.getString(3));
				 eb.setPhone(rs.getString(4));
				 eb.setDesignation(rs.getString(5));
				 eb.setAdress(rs.getString(6));
				 eb.setDoj(rs.getString(7));
				 eb.setPkg(rs.getString(8));
				 
				
			 }
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return eb;
		
	}
	
	public static int updateEmpdata(EmpInfo eb)
	{
		
		int status=0;
		try {
			
			            Connection con=DaoClass.getConnection();
						
						String sql="update addemp set name=?,email=?,phone=?,designation=?,adress=?,doj=?,pkg=? where id=?";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, eb.getName());
						ps.setString(2, eb.getEmail());
						ps.setString(3, eb.getPhone());
						ps.setString(4, eb.getDesignation());
						ps.setString(5, eb.getAdress());
						ps.setString(6, eb.getDoj());
						ps.setString(7, eb.getPkg());
						ps.setInt(8, eb.getId());
						
						
						
					    status=	ps.executeUpdate();
					     
					    
						
						
					} catch (Exception e) {
						
						System.out.println(e);
						
					}
					
		return status;
	}
	
	public static int deletedEmpdata(int id)
	{
		int status=0;
		try {
			
            Connection con=DaoClass.getConnection();
			
            String sql="delete from addemp where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);		
			
			status=ps.executeUpdate();
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return status;
	}
}
