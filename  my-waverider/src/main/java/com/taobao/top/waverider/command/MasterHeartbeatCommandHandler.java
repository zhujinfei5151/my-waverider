/**
 * waverider
 *  
 */

package com.taobao.top.waverider.command;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.top.waverider.Node;
import com.taobao.top.waverider.master.MasterState;
import com.taobao.top.waverider.slave.SlaveState;

/**
 * <p>
 * Master端处理Heartbeat Command处理器
 * </p>
 * 
 * @author <a href="mailto:sihai@taobao.com">sihai</a>
 *
 */
public class MasterHeartbeatCommandHandler implements CommandHandler {
	
	private static final Log logger = LogFactory.getLog(MasterHeartbeatCommandHandler.class);
	
	private Node master;
	
	public MasterHeartbeatCommandHandler(Node master) {
		this.master = master;
	}

	@Override
	public Command handle(Command command) {
		//logger.info(new StringBuilder("Master receive heartbeat from slave : ").append(command.getSession().getSlaveWorker().getIp()));
		command.getSession().alive();
		master.acceptStatistics(SlaveState.fromByteBuffer(command.getPayLoad()));
		ByteBuffer buffer = ((MasterState)master.gatherStatistics()).toByteBuffer();
		//logger.info("MasterState to bytebuffer size: " + buffer.limit());
		return CommandFactory.createHeartbeatCommand(buffer);
	}
}
