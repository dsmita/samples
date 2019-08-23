package com.debs.sample;

public class LargestSquareSubMatrixWith1 {
	
	public int solution(int mat[][], int m, int n ){
		int[][] maxMat = new int[m][n];
		int max =0;
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				maxMat[i][j] = mat[i][j];
				if(i!=0 && j!=0 && mat[i][j] != 0){
					maxMat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) +1;
					max = Math.max(max, maxMat[i][j]);
				}
				max = Math.max(max, maxMat[i][j]);
			}
		}
		return max;
	}
}
