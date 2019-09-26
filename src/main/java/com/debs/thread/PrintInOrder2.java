package com.debs.thread;

public class PrintInOrder2 {
	
	int count=1;
	int max = 30;
	
	public void printFirst(){
		synchronized(this){
			while( count <= max){
				if(count%3 == 1){
					System.out.println("print first");
					count ++ ;
					notifyAll();
				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void printSecond(){
		synchronized(this){
			while( count <= max){
				if(count%3 == 2){
					System.out.println("print second");
					count ++ ;
					notifyAll();
				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void printThird(){
		synchronized(this){
			while( count <= max){
				if(count%3 == 0){
					System.out.println("print third");
					count ++ ;
					notifyAll();
				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
