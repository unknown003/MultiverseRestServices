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
import com.multiverse.dao.PersonsResponse;
import com.multiverse.model.CreatePersonResponse;
import com.multiverse.model.FamiliesInUniverseResponse;
import com.multiverse.model.Family;
import com.multiverse.model.FamilyDetails;
import com.multiverse.model.FamilyDetailsResponse;
import com.multiverse.model.FamilyResponse;
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
	public ResponseEntity<FamiliesInUniverseResponse> listAllFamilies(@PathVariable int id) {

		FamiliesInUniverseResponse familiesInUniverseResponse = new FamiliesInUniverseResponse();

		familiesInUniverseResponse.setFamilyIds(familyService.getAllFamiliesbyID(id));
		familiesInUniverseResponse.setResponseCode(200);
		return new ResponseEntity(familiesInUniverseResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/families/power/check", method = RequestMethod.GET)
	public ResponseEntity<FamilyResponse> powercheck() {

		FamilyResponse familyResponse = new FamilyResponse();
		familyResponse.setFamilies(familyService.familiesPowerCheck());
		familyResponse.setResponseCode(200);
		return new ResponseEntity(familyResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/families/power/balance", method = RequestMethod.POST)
	public ResponseEntity<FamilyDetailsResponse> powerbalance() {

		familyService.familiesPowerBalance();
		List<FamilyDetails> familyDetails = familyService.getAllFamilies();
		FamilyDetailsResponse familyDetailsResponse = new FamilyDetailsResponse();
		familyDetailsResponse.setFamilyDetails(familyDetails);
		familyDetailsResponse.setNoofFamilies(familyDetails.size());
		familyDetailsResponse.setResponseCode(familyDetails.size() > 0 ? 200 : 500);
		return new ResponseEntity(familyDetailsResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/families", method = RequestMethod.GET)
	public ResponseEntity<List<FamilyDetails>> getAllFamilies() {

		List<FamilyDetails> familyDetails = familyService.getAllFamilies();
		FamilyDetailsResponse familyDetailsResponse = new FamilyDetailsResponse();
		familyDetailsResponse.setFamilyDetails(familyDetails);
		familyDetailsResponse.setNoofFamilies(familyDetails.size());
		familyDetailsResponse.setResponseCode(familyDetails.size() > 0 ? 200 : 500);
		return new ResponseEntity(familyDetailsResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<CreatePersonResponse> createperson(@RequestBody Person person) {
		CreatePersonResponse createPersonResponse = new CreatePersonResponse();
		personService.savePerson(person);
		createPersonResponse.setCreationStatus(true);
		createPersonResponse.setResponseCode(200);
		return new ResponseEntity(createPersonResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<PersonsResponse> getallpersons() {

		PersonsResponse personsResponse = new PersonsResponse();
		List<Person> persons = personService.getAllpersons();
		personsResponse.setPersons(persons);
		personsResponse.setCount(persons.size());
		personsResponse.setResponseCode(200);
		return new ResponseEntity(personsResponse, HttpStatus.OK);
	}

}
