package com.debs.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public int[] solution(int[] nums, int target){
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		int indices[] = new int[2];
		for(int i=0;i<nums.length;i++){
			myMap.put(nums[i], i);
		}
		for(int i=0;i<nums.length;i++){
			int intToFind = target - nums[i];
			if(myMap.get(intToFind) !=null && myMap.get(intToFind) != i){
				indices[0] = i;
				indices[1] = myMap.get(intToFind);
			}
		}
		return indices;
	}
	
	public int[] spaceOptimizedSolution(int[] nums, int target){
		int[] result = new int[2];
		if(nums == null || nums.length==0)
			return result;
		if(nums.length==1 && nums[0] == target){
			result[0] = 0;
			return result;
		}
		Arrays.sort(nums);
		int n = nums.length;
		int i=0, j=n-1;
		
		
		while(i < j){
			int sum =0;
			sum = nums[i]+nums[j];
			if(sum == target){
				result[0]=nums[i];
				result[1]=nums[j];
				break;
			} else if(sum < target)	{
				i++;
			} else{
				j--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		/*TwoSum ts = new TwoSum();
		int[] nums = {-5,11,3,3};
		int target = 6;
		int[] indices = ts.spaceOptimizedSolution(nums, target);
		System.out.println(indices[0]+ "####" + indices[1]);*/
		
			String s="ram123";
		    System.out.println(s);
		    /* You don't need the + because you are using the replaceAll method */
		    s = s.replaceAll("\\d", "");  // or you can also use [0-9]
		    System.out.println(s);
	}

}
