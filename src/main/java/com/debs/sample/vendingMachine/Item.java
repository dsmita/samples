package com.debs.sample.vendingMachine;

public enum Item {
	
	Coke("Coke", 25), Pepsi("Pepsi", 10), Soda("Soda", 50), Chips("Chips", 100);
	
	private String name;
	private int price;
	
	Item(String name, int price){
		this.name=name;
		this.price=price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPrice(){
		return this.price;
	}

}
