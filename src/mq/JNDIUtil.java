package mq;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIUtil {
	private Context context;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JNDIUtil(String icf, String url) throws NamingException {
		Hashtable environment = new Hashtable();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, icf);
		environment.put(Context.PROVIDER_URL, url);
		context = new InitialContext(environment);
	}
	
	private Object getObjectByName(String name) throws NamingException {
		return context.lookup(name);
	}
	
//	public QueueConnectionFactory getQueueConnectionFactory(String name) throws NamingException {
//		return (QueueConnectionFactory)getObjectByName(name);
//	}
//	
//	public Queue getQueue(String name) throws NamingException {
//		return (Queue)getObjectByName(name);
//	}
}
