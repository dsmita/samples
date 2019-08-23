package com.debs.sample.vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
	private Map<T, Integer> inventory = new HashMap<T, Integer>();

	public int getQuantity(T item) {
		Integer value = inventory.get(item);
		return value == null ? 0 : value;
	}

	public void addItem(T item, int value) {
		Integer existingValue = inventory.get(item);
		if (existingValue == null) {
			inventory.put(item, value);
		} else {
			inventory.put(item, value + existingValue);
		}
	}

	public void deduct(T item) throws ItemSoldOutException {
		Integer existingValue = inventory.get(item);
		if (existingValue == null) {
			throw new ItemSoldOutException("Inventory Finished");
		} else {
			inventory.put(item, existingValue - 1);
		}
	}

	public boolean hasItem(T item) {
		return getQuantity(item) > 0;
	}

}
