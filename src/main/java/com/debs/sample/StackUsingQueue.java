package com.debs.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StackUsingQueue {
	
	Integer count;
	Queue<Integer> myQueue;
	
	public Integer pushItem(Integer item){
		addElement(item);
		return item;
	}
	
	public void addElement(Integer item){
		myQueue.add(item);
		count++;
	}
	
	public Integer popItem(){
		List<Integer> queueElements = new ArrayList<Integer>();
		
		for(int i=0;i< myQueue.size()-2 ; i++){
			queueElements.add(myQueue.remove());
		}
		Integer lastElement = myQueue.remove();
		for(int i=0;i< queueElements.size()-1 ; i++){
			myQueue.add(queueElements.get(i));
		}
		count-- ;
		return lastElement;
	}

}
