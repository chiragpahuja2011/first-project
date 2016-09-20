package com.community.cook.bean;

import java.util.List;

public class UserInformationResponse {

	private String firstName;
	private String lastName;
	private String imageURL;
	private List<String> speciality;
	private List<String> workingArea;
	private String gender;
	private Long charges;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public List<String> getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(List<String> speciality) {
		this.speciality = speciality;
	}

	public List<String> getWorkingArea() {
		return workingArea;
	}

	public void setWorkingArea(List<String> workingArea) {
		this.workingArea = workingArea;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getCharges() {
		return charges;
	}

	public void setCharges(Long charges) {
		this.charges = charges;
	}
	
}
