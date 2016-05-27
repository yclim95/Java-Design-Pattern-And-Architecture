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
		
		/*
		 * The controller must listen to the view to find
		 * out what happens in it. The controller should
		 * not be concerned with what actually happens in the
		 * view in terms of buttons and other widgets, but only
		 * a high-level view of instructions coming from the view
		 * (save such-and-such, adjust such-and-such, shutdown the app,
		 * etc).
		 */
		view.setCreateUserListener(controller);
		view.setSaveListener(controller);
		view.setAppListener(controller);
		
		/*
		 * In this implementation of MVC, the view listens
		 * to the model and updates itself if the model
		 * changes. Some people say that the view should not
		 * touch the model, but that the controller should
		 * listen to the model and tell the view to change
		 * instead (by calling methods in the view package).
		 */
		model.setPeopleChangedListener(view);
	}//ENDof RunApp()
}