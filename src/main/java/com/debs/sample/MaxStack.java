package com.debs.sample;

import java.util.Stack;

public class MaxStack {

	Stack<Integer> stack = new Stack<Integer>();

	Stack<Integer> maxStack = new Stack<Integer>();

	public void push(int x) {
		if (maxStack.isEmpty()) {
			maxStack.push(x);
		} else {
			if (maxStack.peek() <= x) {
				maxStack.pop();
				maxStack.push(x);
			}
		}
		stack.push(x);
	}

	public int pop() {
		if (!stack.isEmpty()) {
			if (!maxStack.isEmpty() && maxStack.contains(stack.peek())) {
				maxStack.pop();
			}
			return stack.pop();
		}
		return 0;
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		if (!maxStack.isEmpty())
			return maxStack.pop();
		return 0;
	}

}
