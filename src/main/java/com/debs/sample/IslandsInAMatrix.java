package com.debs.sample;

public class IslandsInAMatrix {
	
	int m =5, n=5;

	public int getIslands(int[][] arr){
		boolean [][] visited = new boolean[m][n];
		int count=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j] == 1 && !visited[i][j]){
					count++;
					getIslandsUtil(arr,visited, i-1,j);
					getIslandsUtil(arr,visited, i+1,j);
					getIslandsUtil(arr,visited, i,j-1);
					getIslandsUtil(arr,visited, i,j+1);
				}
			}
		}
		
		return count;
	}

	private void getIslandsUtil(int[][] arr, boolean[][] visited, int i, int j) {
		if(!visited[m][n] && i>=0 && i < m && j>=0 && j<n){
			visited[i][j] = true;
			
		}
		
	}
}
