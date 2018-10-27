package com.multiverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiverse.model.Person;
import com.multiverse.dao.PersonDao;

@Service("PersonService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	public void savePerson(Person person) {

		personDao.save(person);

	}
	
	public List<Person> getAllpersons() {

		return personDao.getAllpersons();
	}

}
