package com.debs.sample;

public class TwoThreads2 {
	
	public static void main(String[] args) {
		final PrintOddEven poe = new PrintOddEven();
		Thread t1= new Thread(new Runnable(){
			@Override
			public void run(){
				poe.printEven();
			}
		});
		Thread t2= new Thread(new Runnable(){
			@Override
			public void run(){
				poe.printOdd();
			}
		});
		t1.start();
		t2.start();
	}

}
