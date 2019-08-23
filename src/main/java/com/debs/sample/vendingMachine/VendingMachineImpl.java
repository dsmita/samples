package com.debs.sample.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachineInterface {

	private Inventory<Coin> cashInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();
	private long totalSales;
	private Item currentItem;
	private long currentBalance;

	public VendingMachineImpl() {
		initialize();
	}

	public void initialize() {
		cashInventory.addItem(Coin.DIME, 50);
		cashInventory.addItem(Coin.DOLLAR, 50);
		cashInventory.addItem(Coin.NICKEL, 50);
		cashInventory.addItem(Coin.PENNY, 50);
		cashInventory.addItem(Coin.QUARTER, 50);

		itemInventory.addItem(Item.Coke, 50);
		itemInventory.addItem(Item.Chips, 50);
		itemInventory.addItem(Item.Pepsi, 50);
		itemInventory.addItem(Item.Soda, 50);
	}

	@Override
	public long getPrice(Item item) {
		if (itemInventory.hasItem(item))
			return item.getPrice();
		throw new ItemSoldOutException("Item sold out. Please select something else");
	}

	@Override
	public void insertCoin(Coin coin) {
		currentBalance = currentBalance + coin.getDenomination();
		cashInventory.addItem(coin, 1);
	}

	@Override
	public List<Coin> refund() {
		List<Coin> refund = getChange(currentBalance);
		updateCashInventory(refund);
		return refund;
	}

	private void updateCashInventory(List<Coin> refund) {
		for (Coin coin : refund) {
			currentBalance = currentBalance + coin.getDenomination();
			cashInventory.addItem(coin, 1);
		}
	}

	private List<Coin> getChange(long amount) {
		List<Coin> changes = new ArrayList<Coin>();
		if (amount > 0) {
			long balance = amount;
			while (balance > 0) {
				if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
					changes.add(Coin.QUARTER);
					balance = balance - Coin.QUARTER.getDenomination();
					continue;
				} else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {
					changes.add(Coin.DIME);
					balance = balance - Coin.DIME.getDenomination();
					continue;
				} else if (balance >= Coin.NICKEL.getDenomination() && cashInventory.hasItem(Coin.NICKEL)) {
					changes.add(Coin.NICKEL);
					balance = balance - Coin.NICKEL.getDenomination();
					continue;
				} else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
					changes.add(Coin.PENNY);
					balance = balance - Coin.PENNY.getDenomination();
					continue;
				} else {
					throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
				}
			}
		}
		return changes;
	}

	@Override
	public List<List<Coin>> collectItemAndChange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// cashInventory.;
		// itemInventory.clear();
		totalSales = 0;
		currentItem = null;
		currentBalance = 0;
	}

	private boolean hasSufficientChange() {
		return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
	}

	private boolean hasSufficientChangeForAmount(long amount) {
		boolean hasChange = true;
		try {
			getChange(amount);
		} catch (NotSufficientChangeException nsce) {
			return hasChange = false;
		}
		return hasChange;
	}

	public long getTotalSales() {
		return totalSales;
	}

}
