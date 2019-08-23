package com.debs.sample.vendingMachine;

public enum Coin {
	PENNY(1), NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100); 
	
	private int denomination;
	
	private Coin(int denomination){
		this.denomination=denomination;
	}
	
	public int getDenomination(){
		return this.denomination;
	}
}
