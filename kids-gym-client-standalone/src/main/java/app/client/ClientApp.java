package app.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.RemoteHello;

public class ClientApp {
	
	public static void main(String[] args) throws NamingException {
		Properties properties = new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		Context context = new InitialContext(properties);
		
		String beanName   = "HelloBean";
		String appName    = "kids-gym-app-0.0.1-SNAPSHOT";
		String moduleName = "kids-gym-ejb-0.0.1-SNAPSHOT";
		final String interfaceName = RemoteHello.class.getName();
		
		String lookupName = "ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + interfaceName;
		
		RemoteHello bean = (RemoteHello) context.lookup(lookupName);
		String message = bean.hello();
		System.out.println(message);
	}
}
