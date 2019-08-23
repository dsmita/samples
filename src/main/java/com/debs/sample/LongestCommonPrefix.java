package com.debs.sample;

public class LongestCommonPrefix {

	public String solution(String arr[], int low, int high) {
		if (low == high)
			return arr[low];

		if (high > low) {
			int mid = (low + high) / 2;
			String str1 = solution(arr, low, mid);
			String str2 = solution(arr, mid + 1, high);
			return getCommonPrefix(str1, str2);
		}
		return "";
	}

	private String getCommonPrefix(String str1, String str2) {
		StringBuilder commonPrefix = new StringBuilder();
		int i = 0, j = 0;
		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) != str2.charAt(j))
				break;
			commonPrefix.append(str1.charAt(i));
			i++;
			j++;
		}
		return commonPrefix.toString();
	}
	
	public String solution2(String arr[], int low, int high){
		String prefix = getCommonPrefix(arr[0], arr[1]);
		for(int i=2;i<arr.length;i++){
			prefix = getCommonPrefix(prefix, arr[i]);
		}
		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] arr = { "geez", "geek", "geekfor", "geeks" };
		String str = lcp.solution2(arr, 0, 3);
		System.out.println(str);
	}

}
