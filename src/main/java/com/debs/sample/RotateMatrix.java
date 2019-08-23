package com.debs.sample;

public class RotateMatrix {

	public int[][] transposeMatrix(int[][] a, int columnLength, int rowLength) {
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		return a;
	}

	public int[][] swapColumns(int[][] a, int columnLength, int rowLength) {
		for (int j = 0; j < columnLength / 2; j++) {
			for (int i = 0; i < rowLength; i++) {
				int temp = a[i][j];
				a[i][j] = a[i][columnLength - 1 - j];
				a[i][columnLength - 1 - j] = temp;
			}
		}
		return a;
	}

	public int[][] swapRows(int[][] a, int columnLength, int rowLength) {
		for (int i = 0; i < rowLength / 2; i++) {
			for (int j = 0; j < columnLength; j++) {
				int temp = a[i][j];
				a[i][j] = a[rowLength - 1 - i][j];
				a[rowLength - 1 - i][j] = temp;
			}
		}
		return a;
	}

	public int[][] rotateMatrix(int[][] a, int columnLength, int rowLength) {
		// matrix rotated by 90 degrees
		a = transposeMatrix(a, columnLength, rowLength);
		a = swapColumns(a, columnLength, rowLength);
		return a;
	}

}
