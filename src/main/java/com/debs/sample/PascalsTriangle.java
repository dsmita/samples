package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	public List<ArrayList<Integer>> getTriangle(int rows){
		List<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> row1 = new ArrayList<Integer> ();
		ArrayList<Integer> row2 = new ArrayList<Integer> ();
		row1.add(1);
		row2.add(1);
		row2.add(1);
		triangle.add(row1);
		triangle.add(row2);
		for(int i=3;i<=rows;i++){
			ArrayList<Integer> row = new ArrayList<Integer> ();
			ArrayList<Integer> topRow = triangle.get(i-1);
			row.add(1);
			for(int j=1;j<i-1;j++){
				int sum = topRow.get(j-1)+topRow.get(j);
				row.add(sum);
			}
			row.add(1);
			triangle.add(row);
		}
		return triangle;
	}

}
