package org.smart4j.proxy.dynamic.cglib;

public class Main2 {

	public static void main(String[] args) {
		MyInterceptor mi = new MyInterceptor();
		UserService us = mi.getProxy(UserService.class);
		us.add();

	}

}
