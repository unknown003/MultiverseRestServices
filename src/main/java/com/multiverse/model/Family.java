package com.multiverse.model;

import java.io.Serializable;

public class Family {

	int familyId;
	Boolean balanced;

	public Family(long l, Boolean balanced) {
		this.familyId = (int) l;
		this.balanced = balanced;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public Boolean getBalanced() {
		return balanced;
	}

	public void setBalanced(Boolean balanced) {
		this.balanced = balanced;
	}

}
