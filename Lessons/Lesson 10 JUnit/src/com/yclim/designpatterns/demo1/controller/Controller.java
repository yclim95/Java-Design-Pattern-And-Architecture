/*
 *  ///////   CONTROLLER    //////////
*/
package com.yclim.designpatterns.demo1.controller;

import java.sql.SQLException;

import com.yclim.designpatterns.demo1.model.DaoFactory;
import com.yclim.designpatterns.demo1.model.Model;
import com.yclim.designpatterns.demo1.model.Person;
import com.yclim.designpatterns.demo1.model.PersonDao;
import com.yclim.designpatterns.demo1.view.CreateUserEvent;
import com.yclim.designpatterns.demo1.view.CreateUserListener;
import com.yclim.designpatterns.demo1.view.View;

public class Controller implements CreateUserListener{
	private Model model;
	private View view;
	
	private PersonDao personDao = DaoFactory.getPersonDao();
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	@Override
	public void userCreated(CreateUserEvent event) {
		System.out.println("Login Event Recieved. " + event.getName() + " ; " + event.getPassword());
		try {
			personDao.addPerson(new Person(event.getName(), event.getPassword()) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}