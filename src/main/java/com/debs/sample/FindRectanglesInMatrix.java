package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class FindRectanglesInMatrix {
	
	public List<List<Integer>> solution(int [][] arr, int m, int n){
		List<ArrayList<Integer>> listOfZeros = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==0){
					ArrayList<Integer> vertexToBeAdded = new ArrayList<Integer>();
					vertexToBeAdded.add(i);
					vertexToBeAdded.add(j);
					listOfZeros.add(vertexToBeAdded);
				}
			}
		}
		
		List<ArrayList<Integer>> listOfRectangles = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < listOfZeros.size() - 1; i++) {
			for (int j = 0; j < 1; j++) {
			}
		}
		return null;
		
	}

}
