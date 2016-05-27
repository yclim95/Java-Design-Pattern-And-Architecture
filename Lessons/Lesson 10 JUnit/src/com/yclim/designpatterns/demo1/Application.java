/*
 *  ///////   MAIN    //////////
*/
package com.yclim.designpatterns.demo1;

import javax.swing.SwingUtilities;

import com.yclim.designpatterns.demo1.controller.Controller;
import com.yclim.designpatterns.demo1.model.Model;
import com.yclim.designpatterns.demo1.view.View;

public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				runApp();
			}
			
		});
	}//ENDof MAIN
	
	public static void runApp(){
		//Import Model class 
		Model model = new Model();
		//Import MODEL into View 
		View view = new View(model);
		//Controller -> Send commands/ listen to -> Model & View
		Controller controller = new Controller(model, view);
		
		//Passing a reference of CONTROLLER to the VIEW
		//View does not know that the thing that is passed is a CONTROLLER 
		// All it know is that that thing  has a method loginPerformed()
		view.setLoginListener(controller); 
	}//ENDof RunApp()
}