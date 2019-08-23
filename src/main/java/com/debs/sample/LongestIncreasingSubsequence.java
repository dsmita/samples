package com.debs.sample;

public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	 
	    for(int i=0; i<nums.length; i++){
	    	
	        max[i]=1;
	        System.out.println("max i " +i+ max[i]);
	        for(int j=0; j<i;j++){
	            if(nums[i]>nums[j]){
	                max[i]=Math.max(max[i], max[j]+1);
	                System.out.println("max i* " +i+ max[i]);
	            }
	        }
	    }
	 
	    int result = 0;
	    for(int i=0; i<max.length; i++){
	        if(max[i]>result)
	            result = max[i];
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lics = new LongestIncreasingSubsequence();
		int[] nums = {9,1,3,7,5,6,20};
		int length = lics.lengthOfLIS(nums);
		System.out.println(length);
	}

}
