/*
 *  ///////   CONTROLLER    //////////
 */
package com.yclim.designpatterns.demo1.controller;

import java.sql.SQLException;

import com.yclim.designpatterns.demo1.model.DaoFactory;
import com.yclim.designpatterns.demo1.model.Database;
import com.yclim.designpatterns.demo1.model.Model;
import com.yclim.designpatterns.demo1.model.Person;
import com.yclim.designpatterns.demo1.model.PersonDao;
import com.yclim.designpatterns.demo1.view.AppListener;
import com.yclim.designpatterns.demo1.view.CreateUserEvent;
import com.yclim.designpatterns.demo1.view.CreateUserListener;
import com.yclim.designpatterns.demo1.view.SaveListener;
import com.yclim.designpatterns.demo1.view.View;

public class Controller implements CreateUserListener, SaveListener,
AppListener {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void onUserCreated(CreateUserEvent event) {

		DaoFactory factory = DaoFactory.getFactory(DaoFactory.MYSQL);

		PersonDao personDao = factory.getPersonDao();
		System.out.println("Login Event Recieved. " + event.getName() + " ; "
				+ event.getPassword());
		try {
			personDao
					.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSave() {
		try {
			model.save();
		} catch (Exception e) {
			view.showError("Error saving to database.");
		}
	}

	@Override
	public void onOpen() {
		try {
			Database.getInstance().connect();
		} catch (Exception e) {
			view.showError("Cannot connect to database.");
		}
		
		try {
			model.load();
		} catch (Exception e) {
			view.showError("Error loading data from database.");
		}
	}

	@Override
	public void onClose() {
		Database.getInstance().disconnect();
	}
}