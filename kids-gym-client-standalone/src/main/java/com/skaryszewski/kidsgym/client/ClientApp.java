package com.skaryszewski.kidsgym.client;

import javax.naming.NamingException;

import com.skaryszewski.kidsgym.beans.RemotePerson;
import com.skaryszewski.kidsgym.client.util.RemoteEjbGetter;

public class ClientApp {
	
	public static void main(String[] args) throws NamingException {
		RemotePerson bean = RemoteEjbGetter.INSTANCE.getRemoteEjb(RemotePerson.class);
		System.out.println(bean.savePerson());
	}
}
