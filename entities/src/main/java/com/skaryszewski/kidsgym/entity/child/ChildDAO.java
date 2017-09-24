package com.skaryszewski.kidsgym.entity.child;

import java.io.Serializable;

import org.hibernate.Session;

import com.skaryszewski.kidsgym.entity.HibernateGenericSQL;
import com.skaryszewski.kidsgym.entity.util.DbOperation;
import com.skaryszewski.kidsgym.entity.util.HibernateUtil;

public class ChildDAO implements HibernateGenericSQL<Child> {

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
