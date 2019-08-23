package com.debs.sample;

public class LongestPalindromicSubString {

	public static int solution(String s){
		int n = s.length();
		
		boolean table [][]= new boolean[n][n];
		
		//all substrings of length 1
		int maxLength=1;
		for(int i=0;i<n;++i){
			table[i][i]=true;
		}
		
		//all substrings of length 2
		int start=0;
		for(int i=0;i<n-1;++i){
			if(s.charAt(i) == s.charAt(i+1)){
				table[i][i+1]=true;
				start=i;
				maxLength =2;
			}
		}
		
		//substring of length 3 or more
		for(int k=3;k<n;++k){
			for(int i=0;i<n-k+1;++i){
				int j=i+k-1;
				if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)){
					table[i][j]=true;
					if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
				}
			}
		}
		
		return maxLength;
		
	}
	
	public static void main(String[] args) {
		String s="acgtgtca";
		int i = solution(s);
		System.out.println(i);
	}
}
