package org.smart4j.proxy.simulation;

public class Client {

	public static void main(String[] args) {
		
		UserService us = (UserService)Proxy.newProxyInstance(UserService.class, new TimeInvocationHandler(new UserServiceImpl()));
		us.add();
	}
}
