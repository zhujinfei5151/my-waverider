package com.taobao.top.waverider;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class WaveriderBaseTestCase extends
		AbstractDependencyInjectionSpringContextTests {

	@Override
	protected String[] getConfigLocations() {
		return new String[]{"classpath*:/spring-test/spring-waverider-test.xml"};
	}
}
