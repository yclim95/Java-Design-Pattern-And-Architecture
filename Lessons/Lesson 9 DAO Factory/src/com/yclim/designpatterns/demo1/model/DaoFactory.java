package com.yclim.designpatterns.demo1.model;

public class DaoFactory {
	public static PersonDao getPersonDao() {
		return new PersonDao();
	}
	
	public static LogDao getLogDAO() {
		return new LogDao();
	}
}