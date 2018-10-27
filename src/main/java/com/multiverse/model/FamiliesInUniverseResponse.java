package com.multiverse.model;

import java.util.List;

public class FamiliesInUniverseResponse extends Response {

	private List<Integer> familyIds;
    private int count;
	public List<Integer> getFamilyIds() {
		return familyIds;
	}

	public void setFamilyIds(List<Integer> familyIds) {
		this.familyIds = familyIds;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
