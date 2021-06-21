package com.careerit.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}

}

public class TaskManagers {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 30; i++) {
			 service.submit(new Task());
		}
		service.shutdown();
	}
}
