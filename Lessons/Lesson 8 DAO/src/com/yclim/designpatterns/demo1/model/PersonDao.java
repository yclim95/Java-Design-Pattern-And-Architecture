package com.yclim.designpatterns.demo1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
 * 1 DAO class Person => Table/View
 * Deals with database
 * Involves CRUD => Create, Retrieve, Updated & Delete
 */
public class PersonDao {
	//Create
	public void addPerson(Person person) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		
		//PreaparedStatement
		PreparedStatement p = con.prepareStatement("insert into people (name, password) values (?,?)");  //SQL statement
		
		p.setString(1, person.getName());
		p.setString(1, person.getPassword());
		
		p.executeUpdate(); //Update Database
		p.close(); //Prevent memory leak
	}
	
	//Retrieve (1 Person)
	public Person getPerson(int id){
		return null;
	}
	
	//Retrieve (List)
	public List<Person> getPerson(){
		return null;
	}
	
	//Update
	public void updatePerson(Person person){
		
	}
	
	//Delete
	public void deletePerson(int id){
		
	}
}