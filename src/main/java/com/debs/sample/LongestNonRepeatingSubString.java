package com.debs.sample;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubString {
	
	public int lengthOfLongestSubString(String s){
		Set<Character> stringSet = new HashSet<Character>();
		int n = s.length();
		int i=0,j=0, maxCount =0;
		while(i<n && j<n){
			if(!stringSet.contains(s.charAt(j))){
				stringSet.add(s.charAt(j));
				j++;
				maxCount = Math.max(maxCount, j-i);
			} else{
				stringSet.remove(s.charAt(i));
				i++;
			}
			
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		LongestNonRepeatingSubString lnrs = new LongestNonRepeatingSubString();
		String s = "abdeaefgh";
		int i = lnrs.lengthOfLongestSubString(s);
		System.out.println(i);
	}

}
