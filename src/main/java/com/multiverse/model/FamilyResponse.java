package com.multiverse.model;

import java.util.List;

public class FamilyResponse extends Response {

	private List<Family> families;

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}
	
}
