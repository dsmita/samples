package com.debs.thread;

public class HelloWorldThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("Inside my thread " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		HelloWorldThread t1 = new HelloWorldThread();
		Thread t2 = new Thread(new RunnableThread());
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Main thread is done");
	}

}

class RunnableThread implements Runnable {

	@Override
	public void run() {
		for (int j = 0; j < 50; j++) {
			System.out.println("thread implements runnable" + j);
		}
	}
}
