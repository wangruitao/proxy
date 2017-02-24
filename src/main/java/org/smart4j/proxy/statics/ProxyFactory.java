package org.smart4j.proxy.statics;

public class ProxyFactory {

	public static Animal getInstance() {
		return new ClockLog(new Dog());
	}
}
