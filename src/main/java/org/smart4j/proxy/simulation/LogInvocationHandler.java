package org.smart4j.proxy.simulation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

	private Object target;
	
	public LogInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] obj) {
		before();
		Object o = null;
		try {
			o = method.invoke(target, obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		after();
		return o;
	}

	public void before() {
		System.out.println("************记录日志开始***********");   
	}
	
	public void after() {
		System.out.println("************记录日志结束***********"); 
	}
}
