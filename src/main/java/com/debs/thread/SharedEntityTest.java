package com.debs.thread;

public class SharedEntityTest {
	
	public static void main(String[] args) {
		SharedEntityAsList shared = new SharedEntityAsList(10);
	
	
	Thread producerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
            	shared.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread consumerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
            	shared.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    producerThread.start();
    consumerThread.start();
	}

}
