package org.smart4j.proxy.dynamic.jdk;

public class Main1 {

	public static void main(String[] args) {
		UserServiceImpl usi = new UserServiceImpl();
		UserService userProxy = (UserService) new MyProxy(usi).getProxy();
		userProxy.add();
	}
}
