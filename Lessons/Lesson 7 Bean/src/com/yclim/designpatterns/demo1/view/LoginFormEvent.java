package com.yclim.designpatterns.demo1.view;

public class LoginFormEvent { //Hold Data of a form 
	private String name;
	private String password;
	
	public LoginFormEvent(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}