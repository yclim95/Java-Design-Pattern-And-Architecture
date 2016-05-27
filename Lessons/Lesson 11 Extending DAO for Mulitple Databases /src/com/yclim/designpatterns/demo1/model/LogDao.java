package com.yclim.designpatterns.demo1.model;

import java.util.List;

public interface LogDao {

	public void addEntry(String message);

	public List<Log> getEntries(int number);

}