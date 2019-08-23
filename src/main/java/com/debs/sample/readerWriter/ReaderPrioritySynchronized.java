package com.debs.sample.readerWriter;

public class ReaderPrioritySynchronized {

	private int readers, writers;

	public void read() throws InterruptedException {
		synchronized (this) {
			while (writers > 0) {
				wait();
			}
			readers++;
		}

		System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
		Thread.sleep(3500);
		System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");

		synchronized (this) {
			readers--;
			notifyAll();
		}
	}

	public void write() throws InterruptedException {
		synchronized (this) {
			while (readers > 0 || writers > 0) {
				wait();
			}
			writers++;
		}

		System.out.println("Thread " + Thread.currentThread().getName() + " is WRITING");
		Thread.sleep(4500);
		System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED WRITING");

		synchronized (this) {
			writers--;
			notifyAll();
		}
	}

}
