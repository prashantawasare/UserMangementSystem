package com.Bo;

public class EmpInfo {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	public EmpInfo(int id, String name, String email, String phone, String designation, String adress, String doj,
			String pkg) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		Adress = adress;
		this.doj = doj;
		this.pkg = pkg;
	}
	private String designation;
	private String Adress;
	private String doj;
	private String pkg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EmpInfo(String name, String email, String phone, String designation, String adress, String doj, String pkg) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		Adress = adress;
		this.doj = doj;
		this.pkg = pkg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getPkg() {
		return pkg;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public EmpInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
