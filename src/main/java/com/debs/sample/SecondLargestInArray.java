package com.debs.sample;

import java.util.PriorityQueue;

public class SecondLargestInArray {
	
	public int solution(int [] arr){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
		}
		int k=1;
		while(k<arr.length-1){
			pq.poll();
			k++;
		}
		return pq.peek();
	}
	
	public static void main(String[] args) {
		SecondLargestInArray sla = new SecondLargestInArray();
		int [] arr = {100,210,3,40,509,601};
		int a = sla.solution(arr);
		System.out.println(a);
	}

}
