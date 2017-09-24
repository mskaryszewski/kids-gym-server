package com.skaryszewski.kidsgym.client;

import javax.naming.NamingException;

import com.skaryszewski.kidsgym.beans.RemoteChild;
import com.skaryszewski.kidsgym.client.util.ServiceUtil;

public class ClientApp {
	public static void main(String[] args) throws NamingException {
		RemoteChild bean = ServiceUtil.INSTANCE.getService(RemoteChild.class);
		System.out.println(bean.saveChild());
	}
}
