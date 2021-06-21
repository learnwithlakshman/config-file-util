package com.careerit.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class MyTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		return new Random().nextInt();
	}

}

public class FutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(5);

		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for (int i = 1; i <= 20; i++) {
			list.add(service.submit(new MyTask()));
		}
		System.out.println("Main... method ");

		for(Future<Integer> f:list) {
				System.out.println(f.get());
		}
		service.shutdown();
	}
}
