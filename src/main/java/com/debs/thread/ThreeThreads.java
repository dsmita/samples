package com.debs.thread;

import com.debs.sample.PrintOddEven;

public class ThreeThreads {
	
	public static void main(String[] args) {
		final PrintInOrder2 pie = new PrintInOrder2();
		Thread t1= new Thread(new Runnable(){
			@Override
			public void run(){
				pie.printFirst();
			}
		});
		Thread t2= new Thread(new Runnable(){
			@Override
			public void run(){
				pie.printSecond();
			}
		});
		Thread t3= new Thread(new Runnable(){
			@Override
			public void run(){
				pie.printThird();
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}

}
