package entity.dao;

import java.io.Serializable;

import org.hibernate.Session;

import entity.HibernateGenericSQL;
import entity.Person;
import entity.PersonSQL;
import util.DbOperation;
import util.HibernateUtil;

public class PersonDAO implements HibernateGenericSQL<Person>, PersonSQL {

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
	
	
	public void performMultipleThings() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			Person person = (Person) session.get(Person.class, 237L);
			System.out.println("LOADED");
			//session.getTransaction().commit();
			
			session = HibernateUtil.getSession();
			//session.beginTransaction();
			session.update(person);

			person.setAge(1232);
			session.update(person);
			person.setAge(1102);
			//session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION " + e.getMessage());
			//session.getTransaction().rollback();
		}
	}
	
	public void performMultipleThings2() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			Person person = new Person();
			person.setAge(11);
			person.setName("This is my name");
			session.saveOrUpdate(person);
			//session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("EXCEPTION " + e.getMessage());
			//session.getTransaction().rollback();
		}
	}
}
