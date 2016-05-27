package com.yclim.designpatterns.demo1.model;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

	//Create
	public int addPerson(Person person) throws SQLException;

	//Retrieve (1 Person)
	public Person getPerson(int id) throws SQLException;

	//Retrieve (List)
	public List<Person> getPeople() throws SQLException;

	//Update
	public int updatePerson(Person person) throws SQLException;

	//Delete
	public int deletePerson(int id) throws SQLException;

	public int deleteAll() throws SQLException;

}