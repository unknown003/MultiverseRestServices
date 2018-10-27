package com.multiverse.model;

import java.util.List;

import com.multiverse.model.Person;
import com.multiverse.model.Response;

public class PersonsResponse extends Response {
	
	private int count;
	private List<Person> persons;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	

}
