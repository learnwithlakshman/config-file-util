package com.careerit.thread;

class TaskManager {

	private static volatile TaskManager obj;

	private TaskManager() {

	}

	public static TaskManager getInstance() {

		if (obj == null) {
			synchronized (TaskManager.class) {
				if (obj == null) {
					obj = new TaskManager();
				}
			}
			
		}
		return obj;
	}

}

public class TaksManagerDemo {

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println(TaskManager.getInstance());
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println(TaskManager.getInstance());
			}
		});
		Thread t3 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println(TaskManager.getInstance());
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}
}
