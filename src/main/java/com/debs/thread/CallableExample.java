package com.debs.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample implements Callable<String> {

	@Override
	public String call() throws Exception {
//		Thread.sleep(1000);
		String name = Thread.currentThread().getName();
		System.out.println(name);
		return name;
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future<String>> list = new ArrayList<Future<String>>();
		Callable<String> callable = new CallableExample();

		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(callable);
			list.add(future);
		}

		for (Future<String> future : list) {
			try {
				System.out.println(new Date() + "::" + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		executorService.shutdown();
	}

}
