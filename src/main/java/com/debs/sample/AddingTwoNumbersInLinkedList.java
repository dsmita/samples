package com.debs.sample;

import java.util.Stack;

public class AddingTwoNumbersInLinkedList {
	
	public double solution(LinkedListNode a, LinkedListNode b){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		if(a== null && b== null)
			return 0;
		if(a == null && b!= null){
			return getLinkedListValue(b);
		}
		if(a != null && b== null){
			return getLinkedListValue(a);
		}
		LinkedListNode curr1=a;
		LinkedListNode curr2=b;
		while(curr1!= null && curr2!= null){
			s1.push(curr1.data);
			s2.push(curr2.data);
			curr1=curr1.next;
			curr2=curr2.next;
		}
		while(curr1!=null){
			s1.push(curr1.data);
			curr1=curr1.next;
		}
		while(curr2!=null){
			s2.push(curr2.data);
			curr2=curr2.next;
		}
		int carryover =0,i=0;
		double sum=0;
		while(!s1.isEmpty() && !s2.isEmpty()){
			int digitSum =  s1.pop().intValue() + s2.pop().intValue() + carryover;
			if(digitSum >= 10){
				carryover = 1;
				sum = sum + (digitSum-10)*Math.pow(10, i);
			} else{
				sum = sum + (digitSum)*Math.pow(10, i);
			}
			i++;
		}
		while(!s1.isEmpty()){
			int digitSum =  s1.pop().intValue();
			sum = sum + (digitSum)*Math.pow(10, i);
			i++;
		}while(!s2.isEmpty()){
			int digitSum =  s2.pop().intValue();
			sum = sum + (digitSum)*Math.pow(10, i);
			i++;
		}
		return sum;
	}
	
	
	
	private double getLinkedListValue(LinkedListNode a){
		double num =0;
		int i=0;
		Stack<Integer> s2 = new Stack<Integer>();
		while(a != null){
			s2.push(a.data);
		}
		while(!s2.isEmpty()){
			num = num + s2.pop()*Math.pow(10, i);
		}
		return num ;
	}

}
