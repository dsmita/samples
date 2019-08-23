package com.debs.sample;

public class PrintOddEven {
	boolean even;
	int count = 0;
	int MAX = 20;

	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				if (even) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ThreadName :: " + Thread.currentThread().getName() + " " + count);
					count++;
					even = true;
					notify();
				}
			}
		}
	}

	public void printEven() {
		synchronized (this) {
			while (count <= MAX) {
				if (!even) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("ThreadName :: " + Thread.currentThread().getName() + " " + count);
					count++;
					even = false;
					notify();
				}
			}
		}
	}

}
