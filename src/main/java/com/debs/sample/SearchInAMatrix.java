package com.debs.sample;

public class SearchInAMatrix {
	
	//binary search for both row and matrix - O(log n+ log m)
	public boolean search(int[][] matrix, int target){
		int rowLength = matrix.length;
		int columnLength = matrix[0].length;
		int start=0, end=rowLength, mid =0;
		while(start<end){
			mid = start+ (end-start)/2;
			if(target < matrix[mid][0]){
				end = mid;
			} else if(target > matrix[mid][0]){
				start = mid;
			} else {
				return true;
			}
		}
		
		int rowStart = 0, rowEnd= columnLength, rowMid=0;
		while(rowStart<rowEnd){
			rowMid = rowStart + (rowEnd-rowStart)/2;
			if(target < matrix[mid][rowMid]){
				rowEnd = rowMid;
			} else if(target > matrix[mid][rowMid]){
				rowStart = rowMid;
			} else {
				return true;
			}
		}
		return false;
	}

}
