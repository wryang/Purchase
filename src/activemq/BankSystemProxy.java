package activemq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import assignment3.BankSystem;

//鍙戦�BytesMessage
public class BankSystemProxy implements BankSystem {

	private static final String url = "tcp://localhost:61616";;
	private static final String GPMS_QUEUE = "GPMS_QUEUE";
	private static final String BANK_QUEUE = "BANK_QUEUE";

	private boolean receiveMessage() throws JMSException {
		boolean result = false;

		ConnectionFactory factory = new ActiveMQConnectionFactory();
		Connection connection = factory.createConnection();
		connection.start();
		final Session session = connection.createSession(true,
				Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(BANK_QUEUE);

		MessageConsumer consumer = session.createConsumer(destination);
		Message message = consumer.receive();
		session.commit();
		String resultStr = message.getStringProperty("result");
		if(null != resultStr) {
			result = Boolean.valueOf(resultStr);
		}
		
		session.close();
		connection.close();
		return result;
	}

	private void sendMessage(Map<String, String> data) throws JMSException {

		Connection connection = null;

		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					url);
			connection = connectionFactory.createConnection();

			connection.start();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(GPMS_QUEUE);
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			
			Set<String> keys = data.keySet();
			
			Iterator<String> it = keys.
					
					
					
					iterator();
			while(it.hasNext()) {
				String name = (String)it.next();
				String value = data.get(name);
				message.setStringProperty(name, value);
			}
			producer.send(message);
			System.out.println("Send complete");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public boolean transfer(String account, String passwd, String target,
			double amount) {
		boolean result = false;
		try {
			
			Map<String, String> data = new HashMap<String, String>();
			data.put("account", account);
			data.put("passwd", passwd);
			data.put("target", target);
			data.put("amount", String.valueOf(amount));
			sendMessage(data);
			result = receiveMessage();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		BankSystemProxy bank = new BankSystemProxy();
		boolean result = bank.transfer("buyer", "123", "justin", 12);
		System.out.println(result);
	}
}