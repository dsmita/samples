package com.debs.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LoginQueue {
	
	public void givenLoginQueueWhenLimitIsReached(){
		int slots = 10;
		ExecutorService service = Executors.newFixedThreadPool(slots);
		LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
		/*IntStream.range(0, slots)
	      .forEach(user -> executorService.execute(loginQueue::tryLogin));*/
		
		int i=0;
		while(i<slots){
			service.execute(loginQueue.tryLogin());
		}
	}

}
