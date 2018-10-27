package com.multiverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.multiverse.dao.Dao;
import com.multiverse.model.Family;
import com.multiverse.model.FamilyDetails;
import com.multiverse.model.Person;
import com.multiverse.service.FamilyService;
import com.multiverse.service.PersonService;

@RestController
public class MultiverseController {

	@Autowired
	PersonService personService; // Service which will do all data retrieval/manipulation work

	@Autowired
	FamilyService familyService;

	@RequestMapping(value = "/universe/{id}/families", method = RequestMethod.GET)
	public ResponseEntity<List<Integer>> listAllFamilies(@PathVariable int id) {

		return new ResponseEntity(familyService.getAllFamiliesbyID(id), HttpStatus.OK);

	}

	@RequestMapping(value = "/families/power/check", method = RequestMethod.GET)
	public ResponseEntity<List<Family>> powercheck() {

		return new ResponseEntity(familyService.familiesPowerCheck(), HttpStatus.OK);

	}

	@RequestMapping(value = "/families/power/balance", method = RequestMethod.POST)
	public ResponseEntity<List<FamilyDetails>> powerbalance() {

		familyService.familiesPowerBalance();

		return new ResponseEntity(familyService.getAllFamilies(), HttpStatus.OK);
	}

	@RequestMapping(value = "/families", method = RequestMethod.GET)
	public ResponseEntity<List<FamilyDetails>> getAllFamilies() {

		return new ResponseEntity(familyService.getAllFamilies(), HttpStatus.OK);
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<String> createperson(@RequestBody Person person) {
		personService.savePerson(person);
		return new ResponseEntity("created user", HttpStatus.OK);
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<String> getallpersons() {

		return new ResponseEntity(personService.getAllpersons(), HttpStatus.OK);
	}

}
