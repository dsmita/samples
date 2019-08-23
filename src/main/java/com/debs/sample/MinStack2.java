package com.debs.sample;

import java.util.Stack;

public class MinStack2 {
	
	Stack<MinStackElement> stack = new Stack<MinStackElement>();
	Integer min = Integer.MAX_VALUE;
	
	// https://www.programcreek.com/2014/02/leetcode-min-stack-java/
	
	public void push(Integer x){
		if(stack.isEmpty()){
			MinStackElement element = new MinStackElement(x);
			stack.push(element);
		} else {
			min = x > min ? min : x;
			MinStackElement element = new MinStackElement(x, min);
			stack.push(element);
		}
	}
	
	public Integer pop(){
		
	}
	
}
