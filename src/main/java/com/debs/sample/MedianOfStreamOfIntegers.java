package com.debs.sample;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStreamOfIntegers {
	
	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;
	
	public MedianOfStreamOfIntegers(){
		minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}
	
	public void addNum(int num){
		minHeap.add(num);
		maxHeap.add(minHeap.poll());
		
		if(maxHeap.size() > minHeap.size()){
			minHeap.add(maxHeap.poll());
		}
	}
	
	public double findMedian(){
		if(minHeap.size() > maxHeap.size()){
			return minHeap.peek();
		} else {
			return (minHeap.peek()+maxHeap.peek())/2.0;
		}
	}
	

}
