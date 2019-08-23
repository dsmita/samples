package com.debs.sample;

public class LargestRectangleInHistogram {
	
	public static int solution(int[] heights){
		int n = heights.length;
		int[] area = new int[n+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<heights[i];j++){
				area[j] = area[j]+ (i+1);
			}
		}
		int max=0;
		for(int i=0;i<n;i++){
			if(area[i] > max){
				max = area[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int [] a = {2,1,5,6,2,3};
		int b = solution(a);
		System.out.println(b);
	}

}
