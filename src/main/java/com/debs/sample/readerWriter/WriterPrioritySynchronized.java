package com.debs.sample.readerWriter;

public class WriterPrioritySynchronized {

	private int readers, writers, writersWaiting;

	public void read() throws InterruptedException {
		synchronized (this) {
			while (writers > 0 && writersWaiting > 0) {
				wait();
			}
			readers++;
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
		Thread.sleep(3500);
		System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");
		synchronized (this) {
			readers--;
			if (readers == 0) {
				notifyAll();
			}
		}
	}

	public void write() throws InterruptedException {
		synchronized (this) {
			writersWaiting++;
			while (readers > 0 || writers > 0) {
				wait();
			}
			writersWaiting--;
			writers++;
		}
		
		System.out.println("Thread " + Thread.currentThread().getName() + " is Writing");
		Thread.sleep(3500);
		System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED Writing");

		synchronized (this) {
			writers--;
			if (writers == 0) {
				notifyAll();
			}
		}
	}

}
