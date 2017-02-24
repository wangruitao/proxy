package org.smart4j.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

	private Object target;
	
	public MyProxy() {}
	
	public MyProxy(Object target) {
		this.target = target;
	}
	
	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

		Object result = null;
		//TODO 做点事
		before();
		result = method.invoke(target, params);
		after();
		//TODO 做点事
		return result;
	}
	
	public void before() {
		System.out.println("你看做点事情");
	}
	
	public void after() {
		System.out.println("你先走，我收尾");
	}

}
