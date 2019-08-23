package com.debs.sample;

public class MaxSubArraySum {
	
	public int maxSubArraySum(int [] a){
		int max =0;
		int [] sumArr= new int [a.length];
		sumArr[0]=a[0];
		for(int i=1;i< a.length;i++){
			sumArr[i]= Math.max(a[i], sumArr[i-1]+a[i]);
			max = Math.max(max, sumArr[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxSubArraySum ms = new MaxSubArraySum();
		int [] a= {-2,-3,4,-1,-2,1,5,-3};
		int [] b= {0,0,0};
		int [] c= {-2,1,-3,4,-1,2,1,-5,4};
		int max = ms.maxSubArraySum(c);
		System.out.println(max);
	}

}
