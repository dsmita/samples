package com.debs.sample;

public class LongestCommonSubSequence {

	public int solution(String a, String b) {
		int[][] arr = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0)
					arr[i][j] = 0;
				else if (a.charAt(i-1) == b.charAt(j-1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		return arr[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		LongestCommonSubSequence ls = new LongestCommonSubSequence();
		int p = ls.solution("abcd", "cpapbrc");
		System.out.println(p);
	}

}
