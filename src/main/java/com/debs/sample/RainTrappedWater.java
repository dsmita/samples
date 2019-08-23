package com.debs.sample;

public class RainTrappedWater {

	public Integer solution(int[] barHeights) {

		int length = barHeights.length;

		if (barHeights == null)
			return 0;
		else if (length == 0 || length == 1)
			return 0;
		else {
			int [] left = new int[length];
			int [] right = new int[length];

			left[0]=0;
			for (int i = 1; i < length; i++) {
				left[i] = Math.max(left[i-1], barHeights[i]);
			}

			right[length - 1]= barHeights[length-1];
			for (int j = length - 2; j >= 0; j--) {
				right[j] = Math.max(right[j+1], barHeights[j]);
			}

			int sum = 0;
			for (int i = 1; i < length - 1; i++) {
				sum = sum + Math.min(left[i], right[i]) - barHeights[i];
			}
			return sum;
		}

	}

	
	public static void main(String[] args) {
		int[] arr = {3, 0, 0, 2, 0, 4};
		
		RainTrappedWater rtw = new RainTrappedWater();
		int water = rtw.solution(arr);
		System.out.println(water);
	}
}
