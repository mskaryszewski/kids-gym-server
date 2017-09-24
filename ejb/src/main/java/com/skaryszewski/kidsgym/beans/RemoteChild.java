package com.skaryszewski.kidsgym.beans;

import java.util.List;

import javax.ejb.Remote;

import com.skaryszewski.kidsgym.entity.child.Child;

@Remote
public interface RemoteChild {
	
	Child saveChild(Child child);
	Child getChild(long id);
	List<Child> getAllChildren();
	void update(Child child);

}
