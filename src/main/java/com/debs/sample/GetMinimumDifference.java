package com.debs.sample;

import java.util.Arrays;

public class GetMinimumDifference {
	
	public static Integer solution(String a, String b){
		int diff =0;
		if(a == null & b == null)
			return -1;
		if(a == null)
			return b.length();
		if(b == null)
			return a.length();
		if(a.length() != b.length())
			return -1;
		else{
			int[] count = new int[26];
			for(char c:a.toCharArray()){
				count[c -'a']++;
			}
			for(char c:b.toCharArray()){
				count[c -'a']--;
			}
			
			for(int i:count){
				if(i<0)
					diff = diff+i;
			}
		}
		return Math.abs(diff);
	}
	
	public static void main(String[] args) {
		int a  = solution("aba","bbc");
		System.out.println(a);
	}

}
