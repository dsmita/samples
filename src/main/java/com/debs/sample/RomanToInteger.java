package com.debs.sample;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	Map<String, Integer> romanMap = new HashMap<String, Integer>();

	char[] chars = new char[7];
	int[] val = new int[7];

	int value(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

	public int getDecimalValue(String romanNum) {
		int n = romanNum.length();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int s1 = value(romanNum.charAt(i));
			if (i + 1 < n) {
				int s2 = value(romanNum.charAt(i + 1));
				if (s1 > s2) {
					sum = sum + s1;
				} else {
					sum = sum + s2 - s1;
				}
			} else {
				sum = sum + s1;
			}
		}
		return sum;
	}

}
