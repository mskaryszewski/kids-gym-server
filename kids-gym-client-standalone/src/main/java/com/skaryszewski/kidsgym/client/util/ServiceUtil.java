package com.skaryszewski.kidsgym.client.util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class retrieves EJBs by calculating given interfaceName class by removing packageName.Remote prefix and adding Bean suffix.
 * Example:
 *   InterfaceName: this.is.my.package.RemotePerson
 *   calculated BeanName: PersonBean
 * 
 * For all beans/interfaces that do not follow this convention, remote EJB will not be retrieved correctly.
 * 
 * @author Michal Skaryszewski
 *
 */
public enum ServiceUtil {
	
	INSTANCE;
	
	private ServiceUtil() {
		Properties properties = new Properties();
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try {
			context = new InitialContext(properties);
		} catch (NamingException e) {
			System.out.println("Context was not built correctly " + e.getMessage());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <U> U getService(Class clazz) throws NamingException {
		final String interfaceName = clazz.getName();
		String lookupName = generateLookupName(interfaceName);
		return (U) context.lookup(lookupName);
	}
	
	private String generateLookupName (String interfaceName) {
		final String beanName   = createBeanName(interfaceName);
		return "ejb:" + APP_NAME + "/" + EJB_MODULE_NAME + "/" + beanName + "!" + interfaceName;
	}
	
	private String createBeanName(String interfaceName) {
		return interfaceName.replaceFirst(".*Remote", "").concat("Bean");
	}
	
	private Context context;

	private static final String APP_NAME        = "kids-gym-app-0.0.1-SNAPSHOT";
	private static final String EJB_MODULE_NAME = "kids-gym-ejb-0.0.1-SNAPSHOT";
}
