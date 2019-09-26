package com.debs.thread;

public class SharedEntity {

	private Integer data;

	private boolean isProduced;

	public synchronized void produce(Integer i) {
		if (isProduced) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setData(i);
		isProduced = true;
		System.out.println("Produce " + i);
		notify();
	}

	public synchronized Integer consume() {
		if (!isProduced) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isProduced = false;
		System.out.println("Consume " + data);
		notify();
		return data;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer myInt) {
		this.data = myInt;
	}

	public static void main(String[] args) {
		SharedEntity entity = new SharedEntity();
		Thread producer = new Thread(new Producer(entity));
		Thread consumer = new Thread(new Consumer(entity));

		producer.start();
		consumer.start();

	}

}

class Producer implements Runnable {
	private final SharedEntity entity;

	public Producer(SharedEntity entity) {
		this.entity = entity;

	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			entity.produce(i);
		}
	}
}

class Consumer implements Runnable {
	private final SharedEntity entity;

	public Consumer(SharedEntity entity) {
		this.entity = entity;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			entity.consume();
		}
	}

}
