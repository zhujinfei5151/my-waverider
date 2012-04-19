/**
 * waverider
 *  
 */

package com.taobao.top.waverider.command;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.top.waverider.Node;
import com.taobao.top.waverider.master.MasterState;
import com.taobao.top.waverider.slave.SlaveState;

/**
 * <p>
 * Slave端处理Heartbeat Command处理器
 * </p>
 * 
 * @author <a href="mailto:sihai@taobao.com">sihai</a>
 *
 */
public class SlaveHeartbeatCommandHandler implements CommandHandler {
	
	private static final Log logger = LogFactory.getLog(SlaveHeartbeatCommandHandler.class);
	
	private Node slave;
	
	public SlaveHeartbeatCommandHandler(Node slave) {
		this.slave = slave;
	}
	
	@Override
	public Command handle(Command command) {
		//logger.info("Slave received heartbeat from master");
		slave.acceptStatistics(MasterState.fromByteBuffer(command.getPayLoad()));
		return null;
		//return CommandFactory.createHeartbeatCommand(((SlaveState)slave.gatherStatistics()).toByteBuffer());
	}
}
