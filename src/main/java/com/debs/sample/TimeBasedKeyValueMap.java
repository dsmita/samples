package com.debs.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueMap {
	Map<String, List<Integer>> keyTimeList;
	Map<String, List<String>> keyValueList;

	public TimeBasedKeyValueMap() {
		keyTimeList = new HashMap<>();
		keyValueList = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (keyTimeList.containsKey(key)) {
			List<Integer> timeList = keyTimeList.get(key);
			timeList.add(timestamp);
		}
		if (keyValueList.containsKey(key)) {
			List<String> valueList = keyValueList.get(key);
			valueList.add(value);
		}

	}

	public String get(String key, int timestamp) {
		if (keyTimeList.containsKey(key)) {
			List<Integer> timeList = keyTimeList.get(key);
			List<String> valueList = keyValueList.get(key);
			for (int i = timeList.size() - 1; i >= 0;i--) {
				if (i == timestamp) {
					return valueList.get(i);
				} else if(i < timestamp) {
					return valueList.get(i);
				}
			}
		} else {
			return null;
		}
		return null;
	}

}
