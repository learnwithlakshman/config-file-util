package com.careerit.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

	
public class CompletableFutureExample {
		
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			
			
			List<Integer> list = new ArrayList<Integer>();
			list.add(1001);
			list.add(1002);
			list.add(1003);
			
			List<Integer> slist = Collections.synchronizedList(list);
			
			ExecutorService service = Executors.newFixedThreadPool(4);
		
			CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
				String name = "";
				   try {
				       TimeUnit.SECONDS.sleep(1);
				       Scanner sc = new Scanner(System.in);
				       System.out.println("Enter your name:");
				       name = sc.nextLine();
				   } catch (InterruptedException e) {
				       throw new IllegalStateException(e);
				   }
				   return name;
				},service);

				// Attach a callback to the Future using thenApply()
				CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
				   return "Hello " + name;
				});

				// Block and get the result of the future.
				System.out.println(greetingFuture.get());
			
		}
}
