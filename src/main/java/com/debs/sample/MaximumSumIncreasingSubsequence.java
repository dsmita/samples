package com.debs.sample;

public class MaximumSumIncreasingSubsequence {

	public int solution(int[] arr) {
		int n = arr.length;
		int[] sum = new int[n];
		int maxSum = arr[0];
		sum[0]=arr[0];
		for (int i = 1; i < n; i++) {
			sum[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && sum[i]<sum[j]+arr[i]) {
					sum[i]=sum[j]+arr[i];
				}
				System.out.println("i : "+ i+ " sum[i] : "+ sum[i]);
			}
			maxSum = Math.max(maxSum, sum[i]);
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
		int[] nums = {9,1,3,25,5,6,20};
		int length = msis.solution(nums);
		System.out.println(length);
	}

}
