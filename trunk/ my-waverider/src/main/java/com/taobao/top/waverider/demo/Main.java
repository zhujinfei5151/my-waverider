/**
 * waverider
 *  
 */

package com.taobao.top.waverider.demo;

import com.taobao.top.waverider.Node;
import com.taobao.top.waverider.config.WaveriderConfig;
import com.taobao.top.waverider.master.DefaultMasterNode;
import com.taobao.top.waverider.slave.DefaultSlaveNode;


/**
 * start class
 * 
 * java waverider Main -mode master
 * java waverider Main -mode slave
 * 
 * 
 * @author raoqiang
 *
 */
public class Main {
	
	private static final String MASTER_MODE = "master";
	private static final String SLAVE_MODE = "slave";
	private static final String ARG_MODE_KEY = "-mode";
	private static final int MIN_ARGS_LENGTH = 2;
	
	private static WaveriderConfig config = new WaveriderConfig();
	private static Node node;
	
	public static void showUsage() {
		System.out.println("waverider");
		System.out.println("	Usage:");
		System.out.println("			Run as master mode:");
		System.out.println("				java -jar waverider.jar Main -mode master");
		System.out.println("			Run as slave mode:");
		System.out.println("				java -jar waverider.jar Main -mode slave");
	}
	
	public static void main(String[] args) {
		if(args.length < MIN_ARGS_LENGTH) {
			showUsage();
			return;
		}
		
		if(!ARG_MODE_KEY.equals(args[0])) {
			showUsage();
			return;
		}
		
		if(MASTER_MODE.equals(args[1])) {
			runAsMaster();
		} else if(SLAVE_MODE.equals(args[1])) {
			runAsSlave();
		} else {
			showUsage();
			return;
		}
		
		try{
			Thread.currentThread().join();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void runAsMaster() {
		System.out.println("Run as master model ......");
		node = new DefaultMasterNode(config);
		node.init();
		node.start();
	}
	
	public static void runAsSlave() {
		System.out.println("Run as slave model ......");
		config.setMasterAddress("127.0.0.1");
		node = new DefaultSlaveNode(config);
		node.init();
		node.start();
	}
}
