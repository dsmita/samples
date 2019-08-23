package com.debs.sample;

import java.util.Stack;

public class SortStack {
	
	public Stack<Integer> solution(Stack<Integer> intStack){
		Stack<Integer> temp = new Stack<Integer>();
		int top=0;
		while(!intStack.isEmpty()){
			top = intStack.pop();
			while(!temp.isEmpty() && temp.peek() > top){
				intStack.push(temp.pop());
			}
			temp.push(top);
		}
		return temp;
	}

}
