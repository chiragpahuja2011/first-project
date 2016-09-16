package com.community.cook.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="c_user")
public class CookUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="user_id")
	private Integer userId;

	@Column(name ="email_id")
	private String emailId;

	@Column(name ="password")
	private String password;

	@Column(name ="first_name")
	private String firstName;

	@Column(name ="last_name")
	private String lastName;

	@Column(name ="age")
	private Integer age;

	@Column(name ="gender")
	private String gender;

	@Column(name = "mobile_number")
	private Integer mobileNumber;

	@Column(name = "charge_month")
	private Integer chargeMonthly;

	@Column(name ="is_cook")
	private String isCook;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_date")
	private Date modifiedDate;

	/*************************************
	 * Relationships
	 ************************************/
	@OneToMany(mappedBy ="cookUser", fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<CookUserArea> cookUserAreas = new HashSet<CookUserArea>();

	@OneToMany(mappedBy ="cookUser", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CookUserSpeciality> cookUserSpecialities = new HashSet<CookUserSpeciality>();


	/*************************************
	 * Getter-Setters
	 ************************************/

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getChargeMonthly() {
		return chargeMonthly;
	}

	public void setChargeMonthly(Integer chargeMonthly) {
		this.chargeMonthly = chargeMonthly;
	}

	public String getIsCook() {
		return isCook;
	}

	public void setIsCook(String isCook) {
		this.isCook = isCook;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Set<CookUserArea> getCookUserAreas() {
		return cookUserAreas;
	}

	public void setCookUserAreas(Set<CookUserArea> cookUserAreas) {
		this.cookUserAreas = cookUserAreas;
	}

	public Set<CookUserSpeciality> getCookUserSpecialities() {
		return cookUserSpecialities;
	}

	public void setCookUserSpecialities(Set<CookUserSpeciality> cookUserSpecialities) {
		this.cookUserSpecialities = cookUserSpecialities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CookUser other = (CookUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
