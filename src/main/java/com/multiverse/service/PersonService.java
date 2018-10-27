package com.multiverse.service;

import java.util.List;

import com.multiverse.model.Person;

public interface PersonService {


	public void savePerson(Person person);	
	
	public List<Person> getAllpersons();	

}
