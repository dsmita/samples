package com.debs.sample;

public class SpiralMatrix {

	public void printTopRow(int rowLength, int columnLength, int start, int[][] a) {
		for (int i = start; i <= columnLength; i++)
			System.out.println(a[rowLength][i]);
	}

	public void printRightColumn(int rowLength, int columnLength, int start, int[][] a) {
		for (int i = start; i <= rowLength; i++)
			System.out.println(a[i][columnLength]);
	}

	public void printBottomRow(int rowLength, int columnLength, int start, int[][] a) {
			for (int i = columnLength - 1; i >= start; i--)
				System.out.println(a[rowLength][i]);
	}

	public void printLeftColumn(int rowLength, int columnLength, int start, int[][] a) {
			for (int i = rowLength - 1; i > start; i--)
				System.out.println(a[i][columnLength]);
	}

	public void printSpiralMatrix(int[][] a) {
		int rowLength = a.length-1;
		int columnLength = a[0].length-1;
		for (int i = 0; i < rowLength / 2 +1 ; i++) {
			printTopRow(i, columnLength - i, i , a);
			printRightColumn(rowLength - i, columnLength - i, i+1, a);
			printBottomRow(rowLength - i, columnLength - i, i, a);
			printLeftColumn(rowLength-i, i, i, a);
		}
	}
	
	public static void main(String[] args) {
		int [][] a = {{1,2,3,4},{6,7,8,9},{11,12,13,14},{16,17,18,19},{21,22,23,24}};
		SpiralMatrix sm = new SpiralMatrix();
		sm.printSpiralMatrix(a);
	}

}
