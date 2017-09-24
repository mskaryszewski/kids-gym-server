package com.skaryszewski.kidsgym.client;

import javax.naming.NamingException;

import com.skaryszewski.kidsgym.beans.RemotePerson;
import com.skaryszewski.kidsgym.client.util.ServiceUtil;

public class ClientApp {
	
	public static void main(String[] args) throws NamingException {
		RemotePerson bean = ServiceUtil.INSTANCE.getService(RemotePerson.class);
		System.out.println(bean.savePerson());
	}
}
