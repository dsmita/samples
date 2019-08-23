package com.debs.sample.vendingMachine;

public class NotSufficientChangeException extends RuntimeException{
	
	private String message;
	
	public NotSufficientChangeException(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
	}



}
