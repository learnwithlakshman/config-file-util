package com.careerit.thread;

import java.util.concurrent.TimeUnit;

class Account{
	private double balance = 5000;
	
	public synchronized void withDraw(double amount) {
		System.out.println(Thread.currentThread().getName()+" is going withdraw :"+amount);
		if(balance < amount) {
			System.out.println("Please wait, util money is deposited in your account:");
			try {
				wait();
			}catch (Exception e) {
				e.printStackTrace();
			}
			this.balance -= amount;
			System.out.println("Withdraw of amount has been completed");
		}
		
	}
	
	public synchronized void deposit(double amount) {
		System.out.println(Thread.currentThread().getName()+" is going deposit :"+amount);
		
		try {
			System.out.println(amount+" is going deposit....");
			this.balance += amount;
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	}
	
}
public class AccountManager {

		public static void main(String[] args) {
			Account account = new Account();
			Thread t1 = new Thread(()->{
				account.withDraw(10000);
			});
			Thread t2 = new Thread(()->{
				account.deposit(6000);
			});
			
			t1.start();
			t2.start();
			
		}
}
