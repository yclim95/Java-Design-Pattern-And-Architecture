package com.yclim.designpatterns.demo1.model;

public class Database {
	private static Database instance = new Database();
	
	private Database(){ //Prevent from using new()
		
	}
	
	public static Database getInstance(){
		return instance;
	}
	
	//Previously
	/*
	private static Database instanceOld;
	
	public static Database getInstanceOld() {
		if(instanceOld == null) {
			instanceOld = new Database();
		}
		
		return instanceOld;
	}
	*/
	
	public void connect(){
		System.out.println("connect to database");
	}
	
	public void disconnect(){
		System.out.println("disconnect from database");
	}
}