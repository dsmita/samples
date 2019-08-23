package com.debs.sample;

public class RectanglesFilledWith1 {

	private int m = 4, n = 5, count = 0;
	/*
	 * A = {1,0,0,0,1, 1,0,0,0,0, 0,0,1,1,1, 1,0,0,0,0};
	 * 
	 * output =4;
	 */

	public boolean check(int x, int y, int[][] arr) {
		if (x >= 0 && x < m && y >= 0 && y < n && arr[x][y] == 1)
			return true;
		return false;
	}

	public void dfs(int x, int y, int[][] arr) {
		if (check(x, y, arr)) {
			arr[x][y] = 2;
			
			if(x > 0)
				dfs(x - 1, y, arr);
			if(y > 0)
				dfs(x, y - 1, arr);
			if(y<n-1)
				dfs(x, y + 1, arr);
			if(x<m-1)
				dfs(x + 1, y, arr);
		}
		else
			return;
	}

	public int getRectangles(int arr[][]) {
		int m = arr.length;
		int n = arr[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					count++;
					dfs(i, j, arr);
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		RectanglesFilledWith1 rec = new RectanglesFilledWith1();
		int[][] arr = {{1,0,0,0,1},
				{1,0,0,0,0}, {0,0,1,1,1}, {1,0,0,0,0}};
		System.out.println(rec.getRectangles(arr));
	}
}
