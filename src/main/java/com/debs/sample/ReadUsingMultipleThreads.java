package com.debs.sample;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadUsingMultipleThreads {
	
	private static Queue<String> myQueue = new ConcurrentLinkedQueue<String>();
	private static ExecutorService executorService;
	
	static{
		myQueue.offer("Planets");
		myQueue.offer("mercury");
		myQueue.offer("venus");
		myQueue.offer("earth");
		myQueue.offer("mars");
		myQueue.offer("jupiter");
		myQueue.offer("saturn");
		myQueue.offer("uranus");
		myQueue.offer("neptune");
		myQueue.offer("pluto");
		executorService = Executors.newFixedThreadPool(4);
	}
	
	public static void print(){
		executorService.execute(new Runnable() {
	        public void run() {
	            System.out.println("ThreadName :: " + Thread.currentThread().getName() + " " +myQueue.poll());
	        }
	    });

	    executorService.shutdown();
	}
	
	public static void main(String[] args){
		for(int i=0;i<5;i++){
			executorService.execute(new Runnable() {
		        public void run() {
		            System.out.println("ThreadName :: " + Thread.currentThread().getName() + " " +myQueue.poll());
		        }
		    });

		    executorService.shutdown();
			
		}
		
	}

}
