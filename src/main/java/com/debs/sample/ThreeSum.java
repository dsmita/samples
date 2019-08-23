package com.debs.sample;

public class ThreeSum {
	
	public int[] solution(int[] nums, int target){
		int indices[] = new int[2];
		int k=0;
		//assuming nums is sorted
		for(int i=0;i<nums.length;i++){
			int intToFind = target - nums[i];
			int frontPointer = i+1;
			int lastPointer = nums.length-1 ;
			while(frontPointer < lastPointer){
				if(nums[frontPointer] + nums[lastPointer] == intToFind){
					indices[k]=i;
					indices[k+1] = frontPointer;
					indices[k+2] = lastPointer;
					k++;
				} else if(nums[frontPointer] + nums[lastPointer] < intToFind){
					frontPointer++;
				} else {
					lastPointer-- ;
				}
				
			}
			
		}
		return indices;
	}

}
