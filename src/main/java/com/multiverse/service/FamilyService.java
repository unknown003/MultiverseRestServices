package com.multiverse.service;

import java.util.List;

import com.multiverse.model.Family;
import com.multiverse.model.FamilyDetails;

public interface FamilyService {

	public List<Integer> getAllFamiliesbyID(int id);

	public List<Family> familiesPowerCheck();

	public String familiesPowerBalance();
	
	public List<FamilyDetails> getAllFamilies();

}
