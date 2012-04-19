package com.taobao.top.waverider.network;

import javax.annotation.Resource;

import org.junit.Test;

import com.taobao.top.waverider.WaveriderBaseTestCase;


public class DefaultNetWorkClientTest extends WaveriderBaseTestCase{

	@Resource
	private NetWorkClient netWorkClient;
	

	@Test
	public void testNetWorkClient() throws Exception {
		netWorkClient.init();
		netWorkClient.start();
		Thread.currentThread().join();
	}
	
	public void setNetWorkClient(NetWorkClient netWorkClient) {
		this.netWorkClient = netWorkClient;
	}
}
