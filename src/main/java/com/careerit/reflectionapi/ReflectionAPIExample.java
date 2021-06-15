package com.careerit.reflectionapi;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionAPIExample {

	public static void main(String[] args){
			try {
				Class c = Class.forName("java.lang.String");
				Method[] methods = c.getMethods();
				for(Method m:methods) {
					System.out.println(m);
				}
				
				System.out.println("....................................");
				for(Method m:c.getDeclaredMethods()) {
					System.out.println(Modifier.toString(m.getModifiers())+" "+m.getReturnType()+""+m.getName());
					
				}
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}

	}

	
}
