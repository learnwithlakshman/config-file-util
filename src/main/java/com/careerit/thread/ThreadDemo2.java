package com.careerit.thread;

import java.util.concurrent.TimeUnit;

class EvenNumber implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}
	}

}

class OddNumber implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}

}

public class ThreadDemo2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main method");

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 20; i++)
				if (i % 2 == 0)
					System.out.println(i);
		}, "Even");
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 20; i++)
				if (i % 2 != 0)
					System.out.println(i);
		}, "Odd");

		t1.start();
		t2.start();

		System.out.println("End of main method");
	}
}
