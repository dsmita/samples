package com.debs.sample;

public class EditDistance {
	
	public int solution(String s1, String s2){
		if(s1 == null && s2 == null)
			return 0;
		if(s1 == null || s1.length()==0)
			return s2.length();
		if(s2 == null || s2.length()==0)
			return s1.length();
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				// If first string is empty, only option is to 
                // insert all characters of second string 
				if(i==0){
					dp[i][j]=j;
				} else if(j==0){
					dp[i][j]=i;
				} else if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1];
				} else {
					dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
				}
			}
		}
		return dp[m][n];
	}

}
