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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.yclim.designpatterns.demo1.model.Model;

public class View extends JFrame implements ActionListener {
	private Model model;
	private JButton okButton;
	private JTextField nameField;
	private JPasswordField passField;

	private LoginListener loginListener;

	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;

		// Create
		nameField = new JTextField(10);
		passField = new JPasswordField(10);
		okButton = new JButton("OK");

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

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 100;
		gc.fill = GridBagConstraints.NONE;

		add(okButton, gc);

		okButton.addActionListener(this);

		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String password = new String(passField.getPassword());
		String name = nameField.getText();
		
		fireLoginEvent(new LoginFormEvent(name, password) );

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