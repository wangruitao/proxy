package org.smart4j.proxy.simulation;

public class TestUserService {

	public static void main(String[] args) {
		UserService usi = new UserServiceImpl();
		InvocationHandler ih = new TimeInvocationHandler(usi);
		UserService us = (UserService) Proxy.newProxyInstance(UserService.class, ih);
//		us.add();
		InvocationHandler logIh = new LogInvocationHandler(us);
		UserService lus = (UserService) Proxy.newProxyInstance(UserService.class, logIh);
		lus.add();
	}
}
