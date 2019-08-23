package com.debs.sample;

import java.util.concurrent.Semaphore;

public class EvenOddUsingSemaphore {

	private Semaphore semEven = new Semaphore(2);
	private Semaphore semOdd = new Semaphore(1);

	public void printEven(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadName :: " + Thread.currentThread().getName() + " " + num);
		semOdd.release();
	}

	public void printOdd(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadName :: " + Thread.currentThread().getName() + " " + num);
		semEven.release();
	}

	static class Even {

		private int max;
		boolean even;
		int count = 0;
		EvenOddUsingSemaphore eos;

		public Even(EvenOddUsingSemaphore eos, int max) {
			this.eos = eos;
			this.max = max;
		}

		public void print() {
			synchronized (this) {
				for (int i = 0; i <= max; i = i + 1) {
					if(i%2==0)
						eos.printEven(i);
				}

			}
		}
	}

	static class Odd {
		private int max;
		boolean even;
		int count = 1;
		EvenOddUsingSemaphore eos;

		public Odd(EvenOddUsingSemaphore eos, int max) {
			this.eos = eos;
			this.max = max;
		}

		public void print() {
			synchronized (this) {
				for (int i = 1; i <= max; i = i + 1) {
					if(i%2 !=0)
						eos.printOdd(i);
				}

			}
		}
	}

	public static void main(String[] args) {
		EvenOddUsingSemaphore eos = new EvenOddUsingSemaphore();
		int max = 20;
		final Odd odd = new EvenOddUsingSemaphore.Odd(eos, max);
		final Even even = new EvenOddUsingSemaphore.Even(eos, max);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				even.print();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				odd.print();
			}
		});
		t1.start();
		t2.start();
	}

}
