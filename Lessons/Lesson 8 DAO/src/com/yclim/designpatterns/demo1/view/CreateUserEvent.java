package com.yclim.designpatterns.demo1.view;

public class CreateUserEvent { //Hold Data of a form 
	private String name;
	private String password;
	
	public CreateUserEvent(String name, String password) {
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