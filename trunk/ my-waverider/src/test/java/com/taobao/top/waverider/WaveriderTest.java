package com.taobao.top.waverider;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.taobao.top.waverider.master.DefaultMasterNode;
import com.taobao.top.waverider.slave.DefaultSlaveNode;

public class WaveriderTest extends WaveriderBaseTestCase{
	
	@Autowired
	@Qualifier("master")
	private DefaultMasterNode master;

	@Autowired
	@Qualifier("slave")
	private DefaultSlaveNode slave;
	
	@Test
	public void test() throws Exception {
		master.init();
		slave.init();
		master.start();
		slave.start();
		
		Thread.currentThread().sleep(30000);
		
		//master.stop();
		
		Thread.currentThread().join();
	}
	
	public void setMaster(DefaultMasterNode master) {
		this.master = master;
	}

	public void setSlave(DefaultSlaveNode slave) {
		this.slave = slave;
	}
	
}
