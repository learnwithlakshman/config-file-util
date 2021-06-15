package com.careerit.reflectionapi;

import java.lang.reflect.Method;

class Example {

	private Example() {
	}

	private Example(int a, int b) {
	}

	private Example(String name, String email) {
	}

	public void display() {
		System.out.println("The Display Method");
	}

	public void show(int a, int b, int c) {
		System.out.println("The Show Method");
	}

	private void print() {
		System.out.println("The Print Method");
	}
}