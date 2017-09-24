package com.skaryszewski.kidsgym.beans;

import javax.ejb.Stateless;

import com.skaryszewski.kidsgym.entity.child.Child;
import com.skaryszewski.kidsgym.entity.child.ChildDAO;

@Stateless
public class ChildBean implements RemoteChild {
	
	private ChildDAO childDao;
	
	public ChildBean() {
		childDao = new ChildDAO();
	}

	@Override
	public Child saveChild() {
		Child child = new Child();
		childDao.save(child);
		return child;
	}
	
	public ChildDAO getChildDao() {
		return childDao;
	}
	
	public void setChildDao(ChildDAO childDao) {
		this.childDao = childDao;
	}
}
