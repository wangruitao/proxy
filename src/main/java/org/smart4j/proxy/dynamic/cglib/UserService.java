package org.smart4j.proxy.dynamic.cglib;

public class UserService {

	public Long add() {
		System.out.println("添加成功");
		return 2L;
	}
	
	public Long delete() {
		System.out.println("删除成功");
		return 4L;
	}
	
}
