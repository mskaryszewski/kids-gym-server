package com.skaryszewski.kidsgym.entity.child;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.skaryszewski.kidsgym.entity.HibernateGenericSQL;
import com.skaryszewski.kidsgym.entity.util.DbOperation;
import com.skaryszewski.kidsgym.entity.util.HibernateUtil;

public class ChildService implements HibernateGenericSQL<Child> {

	@Override
	public Serializable save(final Child entity) {
		Serializable id = HibernateUtil.executeInTransaction(new DbOperation<Serializable>() {
			@Override
			public Serializable execute(final Session session) {
				return session.save(entity);
			}
		});
		return id;
	}

	@Override
	public Child get(final Long id) {
		Child child = HibernateUtil.executeInTransaction(new DbOperation<Child>() {
			@Override
			public Child execute(final Session session) {
				return (Child) session.get(Child.class, id);
			}
		});
		return child;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Child> getAll() {
		List<Child> children = HibernateUtil.executeInTransaction(new DbOperation<List<Child>>() {
			@Override
			public List<Child> execute(final Session session) {
				return session.createCriteria(Child.class).list();
			}
		});
		return children;
	}

	@Override
	public void update(final Child entity) {
		HibernateUtil.executeInTransaction(new DbOperation<Void>() {
			@Override
			public Void execute(final Session session) {
				session.update(entity);
				return null;
			}
		});
	}
}
