package com.debs.sample;

public class TwoThreads {

	
	/*1)you have 2 threads: one prints out even numbers, the other prints out odd numbers. 
	Write the threads such that the numbers print out in their proper order. i.e. 012345678910....
	
	2)Tree problem (lifted from geeksforgeeks.com - a 3.5 medium level problem).   
	3)Problem around longest sub-string string (again lifted from geeksforgeeks).  
	4)longest palindrome in a List. */
	
	public static void main(String[] args) {
		Object lock = new Object();
		Thread t1= new Thread(new PrintEven(lock));
		Thread t2= new Thread(new PrintOdd(lock));
		t1.start();
		t2.start();
	}
	
	
}
