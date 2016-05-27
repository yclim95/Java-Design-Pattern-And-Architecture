package com.yclim.designpatterns.demo1.model;

public class MySqlDaoFactory extends DaoFactory {
	@Override
	public  PersonDao getPersonDao() {
		return new MySqlPersonDao();
	}
	
	@Override
	public  LogDao getLogDAO() {
		return new MySqlLogDao();
	}
}