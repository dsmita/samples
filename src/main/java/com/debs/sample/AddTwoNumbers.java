package com.debs.sample;

public class AddTwoNumbers {
	
	public int[] addTwoNumbers(int [] a1, int [] a2){
		if(a1 == null && a2 == null)
			return null;
		if(a1 == null || a1.length == 0)
			return a2;
		if(a2 == null || a2.length == 0)
			return a1;
		int m = a1.length;
		int n = a2.length;
		int carryover =0;
		int k = Math.max(m,n)+1;
		int i=m, j=n;
		int [] sum = new int [k];
		while(i >0 && j>0){
			int digitSum =0;
			digitSum = a1[i-1] +a2[j-1]+ carryover;
			if(digitSum > 9){
				carryover = 1;
			} else 
				carryover =0;
			sum[k-1]=digitSum%10;
			 i--;
			 j--;
			 k--;
		}
		while(i>0){
			int digitSum1 =0;
			digitSum1 = a1[i-1] + carryover;
			if(digitSum1 > 9){
				carryover = 1;
			} else 
				carryover =0;
			sum[k-1]=digitSum1%10;
			i--;
			k--;
		}
		while(j>0){
			int digitSum2 =0;
			digitSum2 = a2[j-1] + carryover;
			if(digitSum2 > 9){
				carryover = 1;
			} else 
				carryover =0;
			sum[k-1]=digitSum2%10;
			j--;
			k--;
		}
		if(carryover!=0)
			sum[k-1]= carryover;
			
		return sum;
	}
	
	public static void main(String[] args) {
		int [] a1 ={2,3,9,8};
		int [] a2 = {9};
		AddTwoNumbers atn = new AddTwoNumbers();
		int [] a3 = atn.addTwoNumbers(a1, a2);
		for(int i=0;i<a3.length;i++){
			System.out.println("i::"+i+" a3[i] :: "+a3[i] +",");
		}
	}

}
