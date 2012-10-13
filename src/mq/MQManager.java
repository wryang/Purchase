package mq;

import java.io.IOException;

public class MQManager {

//	private MQQueueManager qMgr;
//
//	private void getConnMQmanager() {
//		MQEnvironment.hostname = "192.168.47.94";// MQ服务器IP
//		MQEnvironment.channel = "CHANNEL";     // 队列管理器对应的服务器连接通道
//		MQEnvironment.CCSID = 1381;            // 字符编码
//		MQEnvironment.port = 8888;             // 队列管理器的端口号
//		
//		try {
//			qMgr = new MQQueueManager("Radiation");// 队列管理器名称
//		} catch (MQException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	private void closeConnMQmanager() {
//		if (qMgr != null) {
//			try {
//				qMgr.close();
//			} catch (MQException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public void sendMsg(String msgStr){
//		int openOptions = MQC.MQOO_INPUT_AS_Q_DEF|MQC.MQOO_OUTPUT|MQC.MQOO_INQUIRE;
//		MQQueue queue = null;
//		try {
//			//建立Q1通道的连接
//			queue = qMgr.accessQueue("INPUT_QUEUE", openOptions, null, null,null);  
//			MQMessage msg = new MQMessage();// 要写入队列的消息
//			msg.format = MQC.MQFMT_STRING;
//			msg.characterSet = 1381;
//			msg.writeObject(msgStr); //将消息写入消息对象中
//			MQPutMessageOptions pmo = new MQPutMessageOptions();
//			msg.expiry = -1;    // 设置消息用不过期
//			queue.put(msg, pmo);// 将消息放入队列
//		} catch (MQException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(queue!=null){
//				try {
//					queue.close();
//				} catch (MQException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	public void receiveMsg()
//	{
//		int openOptions = MQC.MQOO_INPUT_AS_Q_DEF|MQC.MQOO_OUTPUT|MQC.MQOO_INQUIRE;
//		MQQueue queue = null;
//		try {
//			queue = qMgr.accessQueue("Q1", openOptions, null, null,null);
//			
//			System.out.println("该队列当前的深度为:"+queue.getCurrentDepth());
//			System.out.println("===========================");
//			int depth = queue.getCurrentDepth();
//			//将队列的里的消息读出来
//			while(depth-->0)
//			{
//				MQMessage msg = new MQMessage();// 要读的队列的消息
//				MQGetMessageOptions gmo = new MQGetMessageOptions();
//				queue.get(msg, gmo);
//				System.out.println("消息的大小为："+msg.getDataLength());
//				System.out.println("消息的内容：\n"+msg.readObject());
//				System.out.println("---------------------------");
//			}
//		} catch (MQException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(queue!=null){
//				try {
//					queue.close();
//				} catch (MQException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		MQManager mm = new MQManager();
//		mm.getConnMQmanager();
//		try {
//			mm.sendMsg("第一条测试信息");
//			mm.sendMsg("test第二条测试信息");
//			mm.receiveMsg();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mm.closeConnMQmanager();
//	}
}
