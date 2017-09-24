package com.skaryszewski.kidsgym.entity;

import java.io.Serializable;
import java.util.List;

public interface HibernateGenericSQL<T> {

	Serializable save(T entity);
	T get(Long id);
	List<T> getAll();
	void update(T entity);
	void delete(long id);
	
}
