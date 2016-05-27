package com.yclim.designpatterns.demo1.model;

import java.sql.SQLException;
import java.util.List;

public class OraclePersonDao implements PersonDao{

	@Override
	public int addPerson(Person person) throws SQLException {
		return 0;
	}

	@Override
	public Person getPerson(int id) throws SQLException {
		return null;
	}

	@Override
	public List<Person> getPeople() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePerson(Person person) throws SQLException {
		return 0;
	}

	@Override
	public int deletePerson(int id) throws SQLException {
		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		return 0;
	}

}