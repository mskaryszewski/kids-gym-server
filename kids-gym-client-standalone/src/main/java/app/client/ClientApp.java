package app.client;

import javax.naming.NamingException;

import beans.RemoteHello;

public class ClientApp {
	
	public static void main(String[] args) throws NamingException {
		RemoteHello bean = RemoteEjbGetter.INSTANCE.getRemoteEjbAndCast(RemoteHello.class);
		System.out.println(bean.hello());
	}
}
