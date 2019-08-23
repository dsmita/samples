package com.debs.sample;

public class EquilibriumPoint {
	
	public int solution(int [] a){
		int leftSum = 0;
		int rightSum = 0;
		if(a.length == 1)
			return -1;
		
		for(int i=1;i<a.length;i++){
			rightSum = rightSum + a[i];
		}
		
		if(leftSum == rightSum)
			return 0;
		else {
			for(int i =1; i < a.length -1 ; i++){
				leftSum = leftSum + a[i-1];
				rightSum = rightSum - a[i];
				if(leftSum == rightSum)
					return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		EquilibriumPoint eq = new EquilibriumPoint();
		int [] a = {1, 3, 5, 2, 2};
		int [] b = {1, 2, 1};
		int i = eq.solution(a);
		System.out.println(i);
	}

}
