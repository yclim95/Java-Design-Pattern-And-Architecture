package com.yclim.designpatterns.demo1.model;

public class OracleDaoFactory extends DaoFactory{

	@Override
	public PersonDao getPersonDao() {
		return new OraclePersonDao();
	}

	@Override
	public LogDao getLogDAO() {
		return new OracleLogDao();
	}

}