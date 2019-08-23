package com.debs.sample;

public class ArrayContainer implements Comparable<ArrayContainer>{

	int[] arr;
	int index;
	
	public ArrayContainer(int[] arr, int index){
		this.arr = arr;
		this.index = index;
	}
	
	@Override
	public int compareTo(ArrayContainer ar1) {
		
		return this.arr[this.index]- ar1.arr[ar1.index];
				
	}
	
	
}
