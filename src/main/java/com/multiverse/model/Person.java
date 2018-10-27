package com.multiverse.model;

public class Person {

	String name;
	private int familyId;
	private int universeId;
	private int power;
	public String getName() {
		return name;
	}
	public void setName(Object object) {
		this.name = (String) object;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public int getUniverseId() {
		return universeId;
	}
	public void setUniverseId(int universeId) {
		this.universeId = universeId;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
}
