package com.skaryszewski.kidsgym.entity.person;

import com.skaryszewski.kidsgym.entity.HibernateGenericSQL;

public interface PersonSQL extends HibernateGenericSQL<Person> {
	
	Integer getNumberOfAllPersons();

}
