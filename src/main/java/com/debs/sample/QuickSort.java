package com.debs.sample;

public class QuickSort {
	
	public void sort(int [] a){
		if(a == null)
			return;
		if(a.length == 1)
			return;
		int high = a.length -1;
		sortUtil(0, high, a);
		
	}

	private void sortUtil(int low, int high, int [] a) {
		int i = low;
		int j = high;
		int pivot = (low+high)/2;
		while(i<j){
			while(a[i] <= a[pivot]){
				i++;
			}
			while(a[j] > a[pivot]){
				j--;
			}
			if(i<=j){
				swap(a[i],a[j]);
				i++;
				j--;
			}
		}
		
		while(low<j){
			sortUtil(low,j,a);
		}
		while(i<high){
			sortUtil(i,high,a);
		}
		
	}

	private void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}

}
