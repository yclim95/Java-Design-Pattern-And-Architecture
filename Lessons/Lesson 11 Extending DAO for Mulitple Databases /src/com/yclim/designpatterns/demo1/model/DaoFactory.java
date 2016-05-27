package com.yclim.designpatterns.demo1.model;

public abstract class DaoFactory {
	public static final int MYSQL = 0;
	public static final int ORACLE = 1;
	
	public abstract PersonDao getPersonDao();

	public abstract LogDao getLogDAO();
	
	public static DaoFactory getFactory(int type){
		switch(type) {
		case MYSQL:
			return new MySqlDaoFactory();
		case ORACLE:
			return new OracleDaoFactory();
		default:
			return null;
		}
	}

}