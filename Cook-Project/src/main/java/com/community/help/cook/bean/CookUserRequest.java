package com.community.help.cook.bean;

import java.util.List;

public class CookUserRequest {

	private String emailId;
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private long mobileNumber;
	private long chargeMonthly;
	private String gender;
	private List<String> speciality;
	private List<String> workingArea;
	private byte[] imageData;
	
	// Not joined Parameters
	// TODO : Join them later
	private String imageURL;
	private String dob;

	public String getFirstName() {
		return firstName;
	}

	public long getChargeMonthly() {
		return chargeMonthly;
	}

	public void setChargeMonthly(long chargeMonthly) {
		this.chargeMonthly = chargeMonthly;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
