package com.debs.sample;

public class Knapsack {

	public static int solution(int[] value, int[] weight, int capacity) {
		int n = value.length;

		int[][] arr = new int[n + 1][capacity + 1];

		for (int i = 0; i < capacity; i++) {
			arr[0][i] = 0;
		}
		for (int j = 0; j <= n; j++)
			arr[j][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (weight[i - 1] <= j) {
					arr[i][j] = Math.max(value[i - 1] + arr[i - 1][j - weight[i - 1]], arr[i - 1][j]);
				} else {
					arr[i][j] = arr[i - 1][j];
				}
				System.out.println(" i::" + i + " j::" + j + " arr :: " + arr[i][j]);
			}
		}
		return arr[n][capacity];
	}

	public static void main(String[] args) {
		int[] value = { 10, 40, 30, 50 };
		int[] weight = { 5, 4, 6, 3 };
		int capacity = 10;
		int i = solution(value, weight, capacity);
		System.out.println(i);
	}

}
