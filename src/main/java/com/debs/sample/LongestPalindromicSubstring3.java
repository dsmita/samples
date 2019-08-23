package com.debs.sample;

public class LongestPalindromicSubstring3 {
	
	public int longestPalindrome(String s){
		if(s.isEmpty())
			return 0;
		if(s.length() == 1)
			return 1;
		String longest = s.substring(0,1);
		for(int i=0;i<s.length();i++){
			//get longest palindrome with centre as i
			String tmp = getLongestString(s, i,i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			
			//get longest palindrome with centre i and i+1
			tmp = getLongestString(longest, i, i+1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest.length();	
	}

	private String getLongestString(String s, int start, int end) {
		while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		
		return s.substring(start+1,end);
	}

}
