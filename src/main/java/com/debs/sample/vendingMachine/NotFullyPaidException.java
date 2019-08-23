package com.debs.sample.vendingMachine;

public class NotFullyPaidException extends RuntimeException {
	
	private String message;
	
	public NotFullyPaidException(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
	}

}
