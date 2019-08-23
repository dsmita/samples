package com.debs.sample;

import java.util.EmptyStackException;
import java.util.Stack;

public class PostFixNotation {

	public int solution(String[] a) {
		Stack<Integer> intStack = new Stack<Integer>();
		if (a.length == 1 && a[0].matches("[0-9]+"))
			return Integer.parseInt(a[0]);
		if (a.length == 1 && !a[0].matches("[0-9]+"))
			return -1;
		if (a.length == 2)
			return -1;
		else if (a.length > 2) {
			

			for (String s : a) {
				if (s.matches("[0-9]+"))
					intStack.push(Integer.parseInt(s));
				else {
//					try {
						if (s.matches("[/]"))
							intStack.push(intStack.pop() / intStack.pop());
						if (s.matches("[+]"))
							intStack.push(intStack.pop() + intStack.pop());
						if (s.matches("[-]"))
							intStack.push(intStack.pop() - intStack.pop());
						if (s.matches("[*]"))
							intStack.push(intStack.pop() * intStack.pop());
//					} catch (EmptyStackException e) {
//						return -1;
//
//					}
				}
			}
		}
		
		return intStack.pop();
	}
	
	public static void main(String[] args) {
		PostFixNotation pfn = new PostFixNotation();
		String[] arr = {"2","3","1","*", "+", "9","-"};
		int result = pfn.solution(arr);
		System.out.println(result);
	}

}
