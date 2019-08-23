package com.debs.sample;

import java.util.Stack;

public class MinStack {
	
	/* Stack      MinStack
	 * 5             1
	 * 1             1
	 * 4             2
	 * 6             2
	 * 2             2
	 * 
	 * 
	 * Having two stacks , we can do push,pop, min in O(1) time complexity
	 * Space complexity - o(n)
	 */
	
	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack(){
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(Integer i){
		stack.push(i);
		if(minStack.isEmpty())
			minStack.push(i);
		else{
			minStack.push(i<minStack.peek() ? i : minStack.peek());
		}
	}
	
	public Integer pop(){
		if(!minStack.isEmpty() && !stack.isEmpty()){
			minStack.pop();
			return stack.pop();
		}
		return -1;
	}
	
	public Integer getMin(){
		return minStack.peek();
	}
}
