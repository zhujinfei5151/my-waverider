/**
 * waverider
 * 
 */

package com.taobao.top.waverider.network;

import java.nio.channels.SocketChannel;

import com.taobao.top.waverider.common.LifeCycle;

/**
 * <p>
 * 网络对等节点
 * </p>
 * 
 * @author <a href="mailto:sihai@taobao.com">sihai</a>
 *
 */
public interface NetWorkEndPoint extends LifeCycle {

	/**
	 * 通知有数据要写
	 * @param channel
	 */
	void notifyWrite(SocketChannel channel);
	
	/**
	 * 通知读数据请求
	 * @param channel
	 */
	void notifyRead(SocketChannel channel);
}
