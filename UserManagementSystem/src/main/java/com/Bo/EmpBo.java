package com.Bo;

public class EmpBo {
	
	private String name;
	private String email;
	private String phone;
	private String password;
	private String confirm_password;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
    
	public EmpBo(String name, String email, String phone, String password, String confirm_password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.confirm_password = confirm_password;
	}
	
	
	
	
	
	
}
