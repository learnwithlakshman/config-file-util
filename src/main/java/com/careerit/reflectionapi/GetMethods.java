package com.careerit.reflectionapi;

import com.careerit.yml.Tenant;

class One {
	public String fullName(String fname, String lname) {
		return fname.concat(" ").concat(lname);
	}
}

public class GetMethods {
	public static void main(String[] args) {
		try {
			Tenant obj = getInstance(Tenant.class);
		   	System.out.println(obj);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static<T> T getInstance(Class<T> obj) throws InstantiationException, IllegalAccessException {
			T object = obj.newInstance();
			return object;
	}
}