package org.smart4j.proxy.dynamic.jdk;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("add user entry");

	}

	@Override
	public void delete() {
		System.out.println("delete user");

	}

}
