package com.debs.sample;

public class LongestCommonSubString {

	public int getLongestCommonSubString(String a, String b) {
		int[][] arr = new int[a.length()][b.length()];
		int max = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0)
						arr[i][j] = 1;
					else {
						arr[i][j] = arr[i - 1][j - 1] + 1;
						if (arr[i][j] > max) {
							max = arr[i][j];
						}
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String a = "abcd";
		String b = "pabaeb";
		LongestCommonSubString lc = new LongestCommonSubString();
		int c = lc.getLongestCommonSubString(a, b);
		System.out.println(c);
	}
}
