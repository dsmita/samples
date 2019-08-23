package com.debs.sample;

import java.util.concurrent.Semaphore;

public class LoginQueueUsingSemaphore extends Thread {
	
	private Semaphore semaphore;
	
	public LoginQueueUsingSemaphore(int slotLimit){
		semaphore = new Semaphore(slotLimit);
	}
	
	public boolean tryLogin(){
		return semaphore.tryAcquire();
	}
	
	public void logout(){
		semaphore.release();
	}
	
	public int availableSlots(){
		return semaphore.availablePermits();
	}
	
}
