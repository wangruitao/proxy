package org.smart4j.proxy.simulation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {

	private Object target;
	
	public TimeInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] obj) {
		
		Object o = null;
		long start = before();
		try {
			o = method.invoke(target, obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		long end = after();
		System.out.println("************用时:" + (end-start) + "***********"); 
		return o;
	}

	public long before() {
		long start = System.currentTimeMillis();                           
		System.out.println("************开始:" + start + "***********");   
		return start;
	}
	
	public long after() {
		long end = System.currentTimeMillis();                         
		System.out.println("************结束:" + end + "***********"); 
		return end;
	}
}
