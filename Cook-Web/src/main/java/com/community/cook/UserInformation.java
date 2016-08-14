package com.community.cook;

import java.util.List;

public class UserInformation {


	private String firstName;
	private String lastName;
	private String imageURL;
	private List<String> speciality;
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

}
