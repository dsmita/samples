package com.debs.sample;

public class QueueUsingStacks {
	
	Integer count;
	CustomStack stack1;
	CustomStack stack2;
	
	public void enqueue(Integer item){
		stack1.addElement(item);
		count++;
	}
	
	public Integer dequeue(){
		for(int i=0;i < stack1.count-1; i++){
			stack2.addElement(stack1.popItem());
		}
		Integer lastItem = stack1.peek();
		for(int i=0; i< stack2.count; i++){
			stack1.addElement(stack2.popItem());
		}
		return lastItem;
	}

}
