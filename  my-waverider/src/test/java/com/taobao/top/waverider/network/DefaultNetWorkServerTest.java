package com.taobao.top.waverider.network;

import javax.annotation.Resource;

import org.junit.Test;

import com.taobao.top.waverider.WaveriderBaseTestCase;


public class DefaultNetWorkServerTest extends WaveriderBaseTestCase{
	
	@Resource
	private NetWorkServer netWorkServer;
	
	@Resource
	private NetWorkClient netWorkClient;
	

	@Test
	public void testNetWorkServer() throws Exception {
		netWorkServer.init();
		netWorkClient.init();
		netWorkServer.start();
		netWorkClient.start();
		
		Thread.currentThread().join();
	}
	
	public void setNetWorkServer(NetWorkServer netWorkServer) {
		this.netWorkServer = netWorkServer;
	}
	
	public void setNetWorkClient(NetWorkClient netWorkClient) {
		this.netWorkClient = netWorkClient;
	}

}
