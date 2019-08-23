package com.debs.sample;

public class PrintOdd implements Runnable {

	private Object lock;

	public PrintOdd(Object lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			for (int i = 1; i < 10; i = i + 1) {
			try {
				if(i%2 == 0){
					lock.wait();
				} else{
					System.out.println("Thread name : " + Thread.currentThread().getName() + " : " + i);
					lock.notify();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}

}
