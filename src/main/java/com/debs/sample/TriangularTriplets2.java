package com.debs.sample;

import java.util.Arrays;

public class TriangularTriplets2 {
	
	public void findTriangularTriplets(int[] arr){
		Arrays.sort(arr);
		int n = arr.length;
		for (int m = 0; m < n; m++) {
			System.out.println("sorted array " + m + " element : " + arr[m]);
		}
		
		for(int i =0;i<n-2;i++){
			for(int j=i+1;j<n-1;j++){
				for(int k=j+1;k<n;k++){
					if(arr[i]+arr[j]>arr[k]){
						System.out.println("triplets are :: "+arr[i]+ " "+arr[j]+" "+arr[k]);
					}
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		TriangularTriplets2 tt = new TriangularTriplets2();
		int[] arr = { 4, 10, 5, 3, 6, 8, 1, 2 };
		tt.findTriangularTriplets(arr);
	}

}
