package org.smart4j.proxy.simulation;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("add user");
	}

	@Override
	public void delete() {
		System.out.println("delete user");
		
	}

}
