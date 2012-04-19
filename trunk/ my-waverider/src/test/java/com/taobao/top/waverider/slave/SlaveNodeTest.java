package com.taobao.top.waverider.slave;

import static org.junit.Assert.*;

import org.junit.Test;

import com.taobao.top.waverider.WaveriderBaseTestCase;

public class SlaveNodeTest extends WaveriderBaseTestCase
{

	private DefaultSlaveNode slave;
	
	@Test
	public void test() throws Exception
	{
		slave.init();
		slave.start();
		
		Thread.currentThread().join();
	}
	
	public void setSlave(DefaultSlaveNode slave)
	{
		this.slave = slave;
	}

}
