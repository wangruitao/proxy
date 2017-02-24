package org.smart4j.proxy;

import org.junit.Test;
import org.smart4j.proxy.statics.ProxyFactory;

public class ClockLogTest {


	@Test
	public void testCry() {
		ProxyFactory.getInstance().cry();
	}

}
