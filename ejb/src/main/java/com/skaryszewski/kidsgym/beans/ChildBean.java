package com.skaryszewski.kidsgym.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.skaryszewski.kidsgym.entity.child.Child;
import com.skaryszewski.kidsgym.entity.child.ChildService;

@Stateless
public class ChildBean implements RemoteChild {
	
	private ChildService childService;
	
	public ChildBean() {
		childService = new ChildService();
	}
	
	@Override
	public Child getChild(long id) {
		return childService.get(id);
	}

	@Override
	public Child saveChild(Child child) {
		childService.save(child);
		return child;
	}
	
	@Override
	public List<Child> getAllChildren() {
		return childService.getAll();
	}

	@Override
	public void update(Child child) {
		childService.update(child);
	}
	
	public ChildService getChildDao() {
		return childService;
	}
	
	public void setChildDao(ChildService childDao) {
		this.childService = childDao;
	}
}
