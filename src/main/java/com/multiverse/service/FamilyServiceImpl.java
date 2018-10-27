package com.multiverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiverse.dao.Dao;
import com.multiverse.model.Family;
import com.multiverse.model.FamilyDetails;

@Service("FamilyService")
@Transactional
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	Dao dao;

	public List<Integer> getAllFamiliesbyID(int id) {

		return dao.getFamiliesbyID(id);
	}

	public List<Family> familiesPowerCheck() {

		return dao.checkbalance();
	}

	public String familiesPowerBalance() {

		dao.balancepower();
		return "success";
	}

	public List<FamilyDetails> getAllFamilies() {
		
		return dao.getAllFamilies();
	}

}
