package com.debs.sample;

public class ReverseInteger {
	
	public static int solution(int num){
		boolean negative = false;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		if(num == 0 || num >= max || num <=min)
			return 0;
		else if(num < 0){
			negative=true;
		}
		num = Math.abs(num);
		int sum =0, mod =0;
		while(num > 0){
			mod = num%10;
			sum = sum*10 + mod;
			num = num/10;
		}
		if(negative)
			return sum*(-1);
		return sum;
	}
	
	public static void main(String[] args) {
//		int i = solution(-123);
		System.out.println(solution(Integer.MIN_VALUE));
	}

}
