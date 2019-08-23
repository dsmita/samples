package com.debs.sample;

import java.util.PriorityQueue;

public class MinHeapUsingPriorityQueue {
	
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public void add(Integer i){
		pq.add(i);
	}
	
	public int remove(){
		if(!pq.isEmpty())
			pq.poll();
		return 0;
	}

}
