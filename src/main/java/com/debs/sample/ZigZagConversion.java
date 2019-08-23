package com.debs.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

	public static String solution(String s, int n) {
		if (n == 1)
			return s;
		char[] arr = s.toCharArray();

		// array of String for all rows
		String[] rowArr = new String[n];
		Arrays.fill(rowArr, "");

		int row = 0;
		boolean down = true;

		for (int i = 0; i < s.length(); i++) {
			rowArr[row] = rowArr[row] + arr[i];

			if (row == n - 1) {
				down = false;
			} else if (row == 0) {
				down = true;
			}

			if (down) {
				row++;
			} else {
				row--;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			sb = sb.append(rowArr[i]);
		}
		return sb.toString();
	}

	public static String solution2(String s, int rows) {
		Map<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();
		for (int i = 1; i <= rows; i++) {
			map.put(i, new StringBuilder());
		}

		boolean flag = true;
		int i = 0;
		while (i < s.length()) {
			int j = 1;
			if (flag) {
				while (j <= rows && i < s.length()) {
					StringBuilder sb = map.get(j);
					sb.append(s.charAt(i));
					map.put(j, sb);
					i++;
					j++;
				}
				flag = false;
			}

			if (!flag && i < s.length()) {
				StringBuilder sb = map.get(2);
				sb.append(s.charAt(i));
				map.put(2, sb);
				i++;
				flag = true;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int k = 1; k <= rows; k++) {
			result = result.append(map.get(k));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("paypalishiring", 3));
	}

}
