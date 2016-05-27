/*
 *  ///////   CONTROLLER    //////////
*/
package com.yclim.designpatterns.demo1.controller;

import com.yclim.designpatterns.demo1.model.Model;
import com.yclim.designpatterns.demo1.view.LoginFormEvent;
import com.yclim.designpatterns.demo1.view.LoginListener;
import com.yclim.designpatterns.demo1.view.View;

public class Controller implements LoginListener{
	private Model model;
	private View view;
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	@Override
	public void loginPerformed(LoginFormEvent event) {
		System.out.println("Login Event Recieved. " + event.getName() + " ; " + event.getPassword());
	}
	
}