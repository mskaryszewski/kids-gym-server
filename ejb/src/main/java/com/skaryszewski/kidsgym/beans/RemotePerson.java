package com.skaryszewski.kidsgym.beans;

import javax.ejb.Remote;

import com.skaryszewski.kidsgym.entity.person.Person;

@Remote
public interface RemotePerson {
	
	Person savePerson();

}
