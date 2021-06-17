package com.careerit.thread;

import java.util.concurrent.TimeUnit;

class PrintNumbers extends Thread{
	
		@Override
		public void run() {
			for(int i=1;i<=10;i++) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName()+" : "+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}

public class ThreadExample1 {

		public static void main(String[] args) {
			
					System.out.println("Main method");
					for(int i=1;i<=10;i++) {
						System.out.println(i);
					}
					PrintNumbers t1 = new PrintNumbers();
					t1.setName("T1");
					PrintNumbers t2 = new PrintNumbers();
					t2.setName("T2");
					
					t1.start();
					t2.start();
					System.out.println("End of main");
		}
}
