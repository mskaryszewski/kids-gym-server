package com.skaryszewski.kidsgym.entity;

import java.io.Serializable;

public interface HibernateGenericSQL<T> {

	Serializable save(T entity);
	T get(Long id);
	void update(T entity);
	
}
