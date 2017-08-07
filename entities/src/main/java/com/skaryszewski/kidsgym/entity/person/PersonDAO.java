package com.skaryszewski.kidsgym.entity.person;

import java.io.Serializable;

import org.hibernate.Session;

import com.skaryszewski.kidsgym.entity.HibernateGenericSQL;
import com.skaryszewski.kidsgym.entity.util.DbOperation;
import com.skaryszewski.kidsgym.entity.util.HibernateUtil;

public class PersonDAO implements HibernateGenericSQL<Person> {

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
