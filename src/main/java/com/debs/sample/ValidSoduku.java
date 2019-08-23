package com.debs.sample;

import java.util.HashSet;
import java.util.Set;

public class ValidSoduku {

	@SuppressWarnings("unchecked")
	public boolean notInRow(int[][] a, int row) {
		Set s = new HashSet();
		for (int i = 0; i < 9; i++) {
			if (s.contains(a[row][i])) {
				return false;
			} else if (a[row][i] != 0) {
				s.add(a[row][i]);
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean notInColumn(int[][] a, int column) {
		Set s = new HashSet();
		for (int i = 0; i < 9; i++) {
			if (s.contains(a[i][column])) {
				return false;
			} else if (a[i][column] != 0) {
				s.add(a[i][column]);
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean notInBox(int[][] a, int row, int column) {
		Set s = new HashSet();
		for (int i = row; i < row + 3; i++) {
			for (int j = column; j < column + 3; j++) {
				if (s.contains(a[i][j])) {
					return false;
				} else if (a[i][j] != 0) {
					s.add(a[i][j]);
				}
			}
		}
		return true;
	}
	
	public boolean isValid(int[][] a){
		for(int i=0;i<9;i++){
			if(!notInRow(a, i) || !notInColumn(a,i))
				return false;
		}
		for(int i=0;i<9;i=i+3){
			for(int j=0;j<9;j=j+3){
				if(!notInBox(a,i,j))
					return false;
			}
		}
		return true;
	}

}
