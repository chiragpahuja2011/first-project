package com.community.cook.bean;

import java.util.List;

public class CookUserRequest {
	

	private String firstName;
	private String lastName;
	private String imageURL;
	private List<String> speciality;
	private List<String> workingArea;
	private boolean gender;
	private Long charges;
	private String userName;
	private String password;
	private String confirmPassword;
	private String emailId;
	private long phoneNumber;
	private String dob;
	
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Long getCharges() {
		return charges;
	}

	public void setCharges(Long charges) {
		this.charges = charges;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
