package com.yclim.designpatterns.demo1.model;

import java.util.List;

public class LogDao {
	
	public void addEntry(String message) {
		// Not implemented.
		
		// Get current time and add log message to database.
	}
	
	public List<Log> getEntries(int number) {
		
		// Not implemented. Get latest "number" log messages.
		return null;
	}
	
	// Maybe no need for update or delete in this case.
}
