package com.taobao.top.waverider.slave.failure.slave;

import com.taobao.top.waverider.common.LifeCycle;
import com.taobao.top.waverider.config.WaveriderConfig;
import com.taobao.top.waverider.master.MasterState;

/**
 * Slave端监控Master故障，并做响应的处理
 * 
 * @author raoqiang
 *
 */
public interface MasterFailureMonitor extends LifeCycle {
	
	int 	DEFAULT_STORE_MASTER_STATE_SIZE = 10;
	long 	DEFAULT_FAILURE_MONITOR_INTERVAL = WaveriderConfig.WAVERIDER_DEFAULT_HEART_BEAT_INTERVAL * 4;
	long 	DEFAULT_FAILURE_MONITOR_WAIT_MASTER_STATE_TIME_OUT = WaveriderConfig.WAVERIDER_DEFAULT_HEART_BEAT_INTERVAL * 10;
	
	/**
	 * 
	 * @param masterState
	 */
	void process(MasterState masterState);
}
