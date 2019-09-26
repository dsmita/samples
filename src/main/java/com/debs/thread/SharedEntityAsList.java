package com.debs.thread;

import java.util.ArrayList;
import java.util.List;

public class SharedEntityAsList {
	
	List<Integer> list;
	int size;
	
	public SharedEntityAsList(int size){
		this.size=size;
		this.list= new ArrayList<Integer>();
	}
	
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				while (list.size() > size) {
					wait();
				}
				System.out.println("Produce " + value);
				list.add(value);
				value++;
				notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true){
			synchronized(this){
				while (list.size() == 0) {
                    wait();
                }
                int value = list.remove(0);
                System.out.println("Consume " + value);
                notify();
                Thread.sleep(1000);
			}
		}
	}
	
	

}
