package com.skaryszewski.kidsgym.beans;

import javax.ejb.Remote;

import com.skaryszewski.kidsgym.entity.child.Child;

@Remote
public interface RemoteChild {
	
	Child saveChild();

}
