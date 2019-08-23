package com.debs.sample;

public class UniquePaths {

	public int findUniquePaths(int m, int n) {
		int[][] mem = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mem[i][j] = -1;
			}
		}

		return helper(mem, m - 1, n - 1);
	}

	private int helper(int[][] mem, int m, int n) {
		if (m == 0 || n == 0) {
			mem[m][n] = 1;
			return 1;
		}
		if (mem[m][n] != -1) {
			return mem[m][n];
		}

		mem[m][n] = helper(mem, m - 1, n) + helper(mem, m, n - 1);
		return mem[m][n];
	}

}
