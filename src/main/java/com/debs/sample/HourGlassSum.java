package com.debs.sample;

public class HourGlassSum {
	
	public int solution(int [][] arr){
		int maxSum = -2147483648;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				int sum = getHourGlassSum(i,j, arr);
				maxSum = Math.max(sum, maxSum);
						
			}
		}
		return maxSum;
	}

	private int getHourGlassSum(int i, int j, int [][] arr) {
		int sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
		return sum;
	}
	
	

}
