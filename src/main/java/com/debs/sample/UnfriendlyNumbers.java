package com.debs.sample;

public class UnfriendlyNumbers {
	
	public int solution(int [] nums, int f){
		int [] divisors = new int [f];
		int count =0, solnCount =0;
		boolean isDivisible = false;
		for(int i=1;i<=f;i++){
			if(f%i==0){
				divisors[count]=i;
				count++;
			}
		}
		
		for(int i=0;i<count;i++){
			isDivisible = false;
			for(int j=0;j<nums.length;j++){
				if(divisors[i] != 0 && nums[j]% divisors[i] ==0){
					isDivisible = true;
					break;
				}
			}
			
			if(!isDivisible)
				solnCount ++;
		}
		return solnCount;
	}
	
	public static void main(String[] args) {
		UnfriendlyNumbers uf = new UnfriendlyNumbers();
		int [] nums = {2,5,7,4,3,8,3,18};
		int n = uf.solution(nums, 16);
		System.out.println(n);
	}

}
