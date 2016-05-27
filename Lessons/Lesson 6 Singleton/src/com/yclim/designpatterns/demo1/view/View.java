/*
 *  ///////   VIEW    //////////
 */
package com.yclim.designpatterns.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.yclim.designpatterns.demo1.model.Database;
import com.yclim.designpatterns.demo1.model.Model;

public class View extends JFrame implements ActionListener {
	private Model model;
	private JButton okButton;
	private JTextField nameField;
	private JPasswordField passField;
	private JPasswordField repeatPassField;

	private LoginListener loginListener;

	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;

		// Create
		nameField = new JTextField(10);
		passField = new JPasswordField(10);
		repeatPassField = new JPasswordField(10);
		okButton = new JButton("Create User");

		// Set Layout
		setLayout(new GridBagLayout());

		// Give the layout style to the view
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(100, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Name: "), gc);

		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;

		add(nameField, gc);

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Password: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;

		add(passField, gc);

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Repeat password: "), gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;

		add(repeatPassField, gc);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 4;
		gc.weightx = 1;
		gc.weighty = 100;
		gc.fill = GridBagConstraints.NONE;

		add(okButton, gc);

		okButton.addActionListener(this);
		
		//Database database = new Database() ==> Instead of doing this we can ..... 
		//Database database = Database.getInstance();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				//Method Chaining 
				Database.getInstance().connect();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				Database.getInstance().disconnect();
			}
			
		});
		
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String password = new String(passField.getPassword());
		String repeatPassword = new String(repeatPassField.getPassword());
		
		if(password.equals(repeatPassword)){
			String name = nameField.getText();
			fireLoginEvent(new LoginFormEvent(name, password) );
		}else {
			JOptionPane.showMessageDialog(this, "Passwords do not match.",
					"Error", JOptionPane.WARNING_MESSAGE);
		}				

	}// ENDof ActionPerformed()

	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}

	public void fireLoginEvent(LoginFormEvent event) {
		// Check if loginListener is called
		if (loginListener != null) {
			loginListener.loginPerformed(event);
		}
	}

}