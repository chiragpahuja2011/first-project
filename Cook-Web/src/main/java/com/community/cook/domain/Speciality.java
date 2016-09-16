package com.community.cook.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="c_speciality")
public class Speciality implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="spec_code")
	private String specCode;
	
	@Column(name ="spec_desc")
	private String specDesc;
	
	@Column(name ="spec_comment")
	private String specComment;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "modified_by")
	private Integer modifiedBy;
	
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_date")
	private Date modifiedDate;
	
	public String getSpecCode() {
		return specCode;
	}

	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}

	public String getSpecDesc() {
		return specDesc;
	}

	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}

	public String getSpecComment() {
		return specComment;
	}

	public void setSpecComment(String specComment) {
		this.specComment = specComment;
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
	
}
