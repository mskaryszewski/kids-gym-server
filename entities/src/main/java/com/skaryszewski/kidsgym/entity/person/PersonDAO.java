package com.skaryszewski.kidsgym.entity.person;

import java.io.Serializable;

import org.hibernate.Session;

import com.skaryszewski.kidsgym.entity.util.DbOperation;
import com.skaryszewski.kidsgym.entity.util.HibernateUtil;

public class PersonDAO implements PersonSQL {

	@Override
	public Serializable save(final Person entity) {
		Serializable id = HibernateUtil.executeInTransaction(new DbOperation<Serializable>() {
			@Override
			public Serializable execute(final Session session) {
				return session.save(entity);
			}
		});
		return id;
	}

	@Override
	public Person get(final Long id) {
		Person person = HibernateUtil.executeInTransaction(new DbOperation<Person>() {
			@Override
			public Person execute(final Session session) {
				return (Person) session.get(Person.class, id);
			}
		});
		return person;
	}

	@Override
	public Integer getNumberOfAllPersons() {
		Integer numberOfPersons = HibernateUtil.executeInTransaction(new DbOperation<Integer>() {
			@Override
			public Integer execute(final Session session) {
				return (Integer) session.createSQLQuery("select count(*) from person").list().get(0);
			}
		});
		return numberOfPersons;
	}

	@Override
	public void update(final Person entity) {
		HibernateUtil.executeInTransaction(new DbOperation<Void>() {
			@Override
			public Void execute(final Session session) {
				session.update(entity);
				return null;
			}
		});
	}
}
