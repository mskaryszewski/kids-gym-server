package com.skaryszewski.kidsgym.entity.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		return factory.getCurrentSession();
	}

	public static void closeSessionFactory() {
		factory.close();
	}

	public static <U> U executeInTransaction(DbOperation<U> dbOperation) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		return dbOperation.execute(session);
	}

}