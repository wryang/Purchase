package mq;

import java.io.IOException;

public class MQManager {

//	private MQQueueManager qMgr;
//
//	private void getConnMQmanager() {
//		MQEnvironment.hostname = "192.168.47.94";// MQ������IP
//		MQEnvironment.channel = "CHANNEL";     // ���й�������Ӧ�ķ���������ͨ��
//		MQEnvironment.CCSID = 1381;            // �ַ�����
//		MQEnvironment.port = 8888;             // ���й������Ķ˿ں�
//		
//		try {
//			qMgr = new MQQueueManager("Radiation");// ���й���������
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
//			//����Q1ͨ��������
//			queue = qMgr.accessQueue("INPUT_QUEUE", openOptions, null, null,null);  
//			MQMessage msg = new MQMessage();// Ҫд����е���Ϣ
//			msg.format = MQC.MQFMT_STRING;
//			msg.characterSet = 1381;
//			msg.writeObject(msgStr); //����Ϣд����Ϣ������
//			MQPutMessageOptions pmo = new MQPutMessageOptions();
//			msg.expiry = -1;    // ������Ϣ�ò�����
//			queue.put(msg, pmo);// ����Ϣ�������
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
//			System.out.println("�ö��е�ǰ�����Ϊ:"+queue.getCurrentDepth());
//			System.out.println("===========================");
//			int depth = queue.getCurrentDepth();
//			//�����е������Ϣ������
//			while(depth-->0)
//			{
//				MQMessage msg = new MQMessage();// Ҫ���Ķ��е���Ϣ
//				MQGetMessageOptions gmo = new MQGetMessageOptions();
//				queue.get(msg, gmo);
//				System.out.println("��Ϣ�Ĵ�СΪ��"+msg.getDataLength());
//				System.out.println("��Ϣ�����ݣ�\n"+msg.readObject());
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
//			mm.sendMsg("��һ��������Ϣ");
//			mm.sendMsg("test�ڶ���������Ϣ");
//			mm.receiveMsg();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mm.closeConnMQmanager();
//	}
}
