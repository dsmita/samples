package com.debs.sample;

public class NextPermutation {
	
	public int[] solution(int[] nums){
		int n= nums.length;
		int i=n-1;
			while(nums[i-1]>nums[i]){
				i--;
			}
			swap(nums, i, i-1);
			reverse(nums, i, n-1);
		return nums;	
	}

	private void reverse(int[] nums, int i, int j) {
		while(i<j){
			swap(nums, i, j);
			i++;
			j--;
		}
		
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		NextPermutation np = new NextPermutation();
		int[] a = np.solution(arr);
		for(int b:a){
			System.out.println(b + " ");
		}
	}

}
