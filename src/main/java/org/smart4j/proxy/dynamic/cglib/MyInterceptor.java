package org.smart4j.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyInterceptor implements MethodInterceptor {

	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return (T)enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
		
		Object rsult = null;
		before();
		rsult = proxy.invokeSuper(obj, params);
		after();
		return rsult;
	}

	public void before() {
		System.out.println("前置增强");
	}
	
	public void after() {
		System.out.println("后置增强");
	}
}
