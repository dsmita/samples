package com.debs.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueMap2 {
	
	private Map<String, TreeMap<Integer, String>> timeMap;
	
	public TimeBasedKeyValueMap2() {
		timeMap = new HashMap<String, TreeMap<Integer, String>>();
	}
	
	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> treeMap = timeMap.get(key);
		if (treeMap == null) {
			treeMap = new TreeMap<>();
			timeMap.put(key, treeMap);
		}
		treeMap.put(timestamp, value);

	}
	
	public String get(String key, int timestamp) {
		TreeMap<Integer, String> treeMap = timeMap.get(key);
		if (null == treeMap) {
			return null;
		}
		Integer floorKey = treeMap.floorKey(timestamp);
        if(null == floorKey) {
            return null;
        }
        return treeMap.get(floorKey);
	}

}
