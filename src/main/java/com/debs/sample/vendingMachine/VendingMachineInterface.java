package com.debs.sample.vendingMachine;

import java.util.List;

public interface VendingMachineInterface {
	
	public long getPrice(Item item) throws ItemSoldOutException;
	
	public void insertCoin(Coin coin);
	
	public List<Coin> refund();
	
	public List<List<Coin>> collectItemAndChange();
	
	public void reset();

}
