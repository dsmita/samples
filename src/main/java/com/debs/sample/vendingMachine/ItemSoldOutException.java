package com.debs.sample.vendingMachine;

public class ItemSoldOutException extends RuntimeException {
	
	private String message;
	
	public ItemSoldOutException(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
	}





}
