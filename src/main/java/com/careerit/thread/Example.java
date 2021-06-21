package com.careerit.thread;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;

class One {

	void m1() {

	}
}

class Two extends One {

	@Override
	void m1() {

	}
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyOwn {

	String author() default "Krish";
}



@MyOwn()
public class Example {

		public static void main(String[] args) {
			try {
				Class<?> c = Class.forName(Example.class.getName());
				Annotation[] arr = c.getDeclaredAnnotations();
				for(Annotation a:arr) {
					MyOwn obj = (MyOwn)a;
					System.out.println(obj.author());
				}
			} catch (ClassNotFoundException e) {
	     		e.printStackTrace();
			}
		}
}
