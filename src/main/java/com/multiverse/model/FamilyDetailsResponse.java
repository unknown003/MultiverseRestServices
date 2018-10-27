package com.multiverse.model;

import java.util.List;

public class FamilyDetailsResponse extends Response {

	private List<FamilyDetails> familyDetails;
	private int noofFamilies;

	public List<FamilyDetails> getFamilyDetails() {
		return familyDetails;
	}
	public void setFamilyDetails(List<FamilyDetails> familyDetails) {
		
		this.familyDetails = familyDetails;
	}

	public int getNoofFamilies() {
		return noofFamilies;
	}

	
	public void setNoofFamilies(int size) {
		this.noofFamilies=size;
		
	}
	
}
