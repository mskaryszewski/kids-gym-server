package com.skaryszewski.kidsgym.client;

import javax.naming.NamingException;

import com.skaryszewski.kidsgym.beans.RemoteChild;
import com.skaryszewski.kidsgym.client.util.ServiceUtil;
import com.skaryszewski.kidsgym.entity.child.Child;

public class ClientApp {
	public static void main(String[] args) throws NamingException {
		RemoteChild bean = ServiceUtil.INSTANCE.getService(RemoteChild.class);
		Child c = new Child();
		System.out.println(bean.saveChild(c));
	}
}
