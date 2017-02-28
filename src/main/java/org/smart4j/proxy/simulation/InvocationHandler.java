package org.smart4j.proxy.simulation;

import java.lang.reflect.Method;

public interface InvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] obj);
}
