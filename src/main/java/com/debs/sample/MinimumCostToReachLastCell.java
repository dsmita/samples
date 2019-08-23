package com.debs.sample;

public class MinimumCostToReachLastCell {
	
	public int solution(int arr[][], int m , int n){
		int[][] minCost = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				minCost[i][j]= arr[i][j];
				if(i==0 && j>0){
					minCost[0][j] = minCost[0][j]+minCost[0][j-1];
				}
				if(j==0 && i>0){
					minCost[i][0] = minCost[i][0]+minCost[i-1][0];
				}
				if(i>0 && j>0){
					minCost[i][j] = minCost[i][j] + Math.min(minCost[i-1][j], minCost[i][j-1]);
				}
			}
		}
		return minCost[m-1][n-1];
	}

}
