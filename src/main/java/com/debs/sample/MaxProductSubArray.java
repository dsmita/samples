package com.debs.sample;

public class MaxProductSubArray {
	
	public static int solution(int[] arr){
		int n = arr.length;
		int[] max = new int[n];
		int[] min = new int[n];
		int result = arr[0];
		max[0]= arr[0];
		min[0]= arr[0];
		for(int i=1;i<n;i++){
			if(arr[i]>0){
				max[i]= Math.max(max[i-1]*arr[i], arr[i]);
				min[i]= Math.min(min[i-1]*arr[i], arr[i]);
			}else{
				max[i]=Math.max(min[i-1]*arr[i], arr[i]);
				min[i]=Math.min(max[i-1]*arr[i], arr[i]);
			}
			result =Math.max(result, max[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,-4,-6};
		int result = solution(arr);
		System.out.println(result);
	}

}
