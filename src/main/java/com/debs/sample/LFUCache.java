package com.debs.sample;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

	HashMap<Integer, Integer> vals;// cache K and V
	HashMap<Integer, Integer> counts;// K and counters
	HashMap<Integer, LinkedHashSet<Integer>> lists;// Counter and item list
	int capacity;
	int min = -1;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		vals = new HashMap<>();
		counts = new HashMap<>();
		lists = new HashMap<>();
		lists.put(1, new LinkedHashSet<>());

	}

	public int get(int key) {
		if (!vals.containsKey(key))
			return -1;
		int count = counts.get(key);
		counts.put(key, count + 1);
		lists.get(count).remove(key);

		if (count == min && lists.get(count).size() == 0)
			min++;
		if (!lists.containsKey(count + 1))
			lists.put(count + 1, new LinkedHashSet<>());

		lists.get(count + 1).add(key);
		return vals.get(key);
	}

	public void put(int key, int value) {
		if (capacity <= 0)
			return;
		// If key does exist, we are returning from here
		if (vals.containsKey(key)) {
			vals.put(key, value);
			get(key);
			return;
		}
		if (vals.size() >= capacity) {
			int evit = lists.get(min).iterator().next();
			lists.get(min).remove(evit);
			vals.remove(evit);
			counts.remove(evit);
		}
		// If the key is new, insert the value and current min should be 1 of
		// course
		vals.put(key, value);
		counts.put(key, 1);
		min = 1;
		lists.get(1).add(key);
	}

}
