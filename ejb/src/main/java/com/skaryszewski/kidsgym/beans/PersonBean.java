package com.skaryszewski.kidsgym.beans;

import javax.ejb.Stateless;

import com.skaryszewski.kidsgym.entity.person.Person;
import com.skaryszewski.kidsgym.entity.person.PersonDAO;

@Stateless
public class PersonBean implements RemotePerson {
	
	private PersonDAO personDao;
	
	public PersonBean() {
		personDao = new PersonDAO();
	}

	@Override
	public Person savePerson() {
		Person person = new Person();
		personDao.save(person);
		return person;
	}
	
	public PersonDAO getPersonDao() {
		return personDao;
	}
	
	public void setPersonDao(PersonDAO personDao) {
		this.personDao = personDao;
	}
}
