/**
 * waverider
 * 
 */

package com.taobao.top.waverider.session;

import java.nio.channels.SocketChannel;
import java.util.List;

import com.taobao.top.waverider.command.CommandDispatcher;
import com.taobao.top.waverider.common.LifeCycle;
import com.taobao.top.waverider.network.NetWorkServer;

/**
 * <p>
 * Master端Session管理器
 * </p>
 * 
 * @author <a href="mailto:sihai@taobao.com">sihai</a>
 *
 */
public interface SessionManager extends LifeCycle {
	
	String SESSION_RECYCLE_THREAD_NAME_PREFIX = "Waverider-Sesion-Recycle";
	
	/**
	 * 设置Session的命令分发器
	 * @param commandDispatcher
	 */
	void setCommandDispatcher(CommandDispatcher commandDispatcher);
	
	/**
	 * 
	 * @param netWorkServer
	 * @param channel
	 * @param start
	 * @return
	 */
	Session newSession(NetWorkServer netWorkServer, SocketChannel channel, boolean start);
	
	/**
	 * 
	 * @param session
	 */
	void freeSession(Session session);
	
	/**
	 * 
	 * @return
	 */
	List<SessionState> generateSessionState();
}
