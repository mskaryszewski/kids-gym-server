package com.skaryszewski.kidsgym.entity.child;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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
	
	public List<Child> getChildrenOlderThan(int age) {
		List<Child> children = HibernateUtil.executeInTransaction(new DbOperation<List<Child>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Child> execute(final Session session) {
				Query query = session.createQuery("from Child where age > :age");
				query.setParameter("age", age);
				return query.list();
			}
		});
		return children;
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
				Child child = (Child)session.get(Child.class, entity.getId());
				updateChild(child, entity);
				session.update(child);
				return null;
			}
		});
	}
	private void updateChild(Child oldChild, Child newChild) {
		oldChild.setName(newChild.getName());
		oldChild.setAge(newChild.getAge());
	}

	@Override
	public void delete(long id) {
		HibernateUtil.executeInTransaction(new DbOperation<Void>() {
			@Override
			public Void execute(final Session session) {
				Query query = session.createQuery("delete Child where id = :id");
				query.setParameter("id", id);
				query.executeUpdate();
				return null;
			}
		});
	}
}
