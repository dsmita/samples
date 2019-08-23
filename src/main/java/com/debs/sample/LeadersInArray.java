package com.debs.sample;

public class LeadersInArray {
	
	public void solution(int [] a){
		int max = 0;
		for(int i=a.length-1; i>=0; i--){
			if(a[i] > max){
				max = a[i];
				System.out.println(a[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		LeadersInArray la = new LeadersInArray();
		int [] a ={6, 7, 4, 3, 5, 2};
		int [] b ={ 7, 6, 5, 2};
		la.solution(a);
	}

}
