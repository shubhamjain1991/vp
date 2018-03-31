package com.vp.enity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
@Table(name="customer_profile")
public class CustomerProfile implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long cpId;
	
	@Column(name="customer_type")
	private String cpType;
	
	@Column(name="customer_email")
	private String cpEmail;
	
	@Column(name="customer_mobile")
	private Long cpMobile;
	
	@Column(name="customer_first_name")
	private String cpFirstName;
	
	@Column(name="customer_last_name")
	private String cpLastName;
	
	@Column(name="customer_user_name")
	private String cpUserName;
	
	@Column(name="customer_password")
	private String cpPwd;
	
	@Column(name="customer_unique_id")
	private String cpUniqueId;
	
	@Column(name="customer_unique_id_type")
	private String cpUniqueIdType;
	
	@Column(name="is_uid_validate")
	private String cpIsUidValid;
	
	@Column(name="is_mobile_validate")
	private String cpIsMobileValid;
	
	@Column(name="is_email_validate")
	private String cpIsEmailValid;
	
	@Column(name="is_active")
	private String cpIsActive;
	
	@Column(name="gender")
	private String cpGender;
	
	@Column(name="created_on")
	private Date cpCreatedOn;
	
	@Column(name="last_modified_on")
	private Date cpLastModifiedOn;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerProfile")
	private List<AddressDetails> addresses;
	
	public CustomerProfile(){
		super();
	}

	public CustomerProfile(Long cpId, String cpType, String cpEmail, Long cpMobile, String cpFirstName,
			String cpLastName, String cpUserName, String cpPwd, String cpUniqueId, String cpUniqueIdType,
			String cpIsUidValid, String cpIsMobileValid, String cpIsEmailValid, String cpIsActive, String cpGender,
			Date cpCreatedOn, Date cpLastModifiedOn) {
		super();
		this.cpId = cpId;
		this.cpType = cpType;
		this.cpEmail = cpEmail;
		this.cpMobile = cpMobile;
		this.cpFirstName = cpFirstName;
		this.cpLastName = cpLastName;
		this.cpUserName = cpUserName;
		this.cpPwd = cpPwd;
		this.cpUniqueId = cpUniqueId;
		this.cpUniqueIdType = cpUniqueIdType;
		this.cpIsUidValid = cpIsUidValid;
		this.cpIsMobileValid = cpIsMobileValid;
		this.cpIsEmailValid = cpIsEmailValid;
		this.cpIsActive = cpIsActive;
		this.cpGender = cpGender;
		this.cpCreatedOn = cpCreatedOn;
		this.cpLastModifiedOn = cpLastModifiedOn;
	}

	public Long getCpId() {
		return cpId;
	}

	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}

	public String getCpType() {
		return cpType;
	}

	public void setCpType(String cpType) {
		this.cpType = cpType;
	}

	public String getCpEmail() {
		return cpEmail;
	}

	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}

	public Long getCpMobile() {
		return cpMobile;
	}

	public void setCpMobile(Long cpMobile) {
		this.cpMobile = cpMobile;
	}

	public String getCpFirstName() {
		return cpFirstName;
	}

	public void setCpFirstName(String cpFirstName) {
		this.cpFirstName = cpFirstName;
	}

	public String getCpLastName() {
		return cpLastName;
	}

	public void setCpLastName(String cpLastName) {
		this.cpLastName = cpLastName;
	}

	public String getCpUserName() {
		return cpUserName;
	}

	public void setCpUserName(String cpUserName) {
		this.cpUserName = cpUserName;
	}

	public String getCpPwd() {
		return cpPwd;
	}

	public void setCpPwd(String cpPwd) {
		this.cpPwd = cpPwd;
	}

	public String getCpUniqueId() {
		return cpUniqueId;
	}

	public void setCpUniqueId(String cpUniqueId) {
		this.cpUniqueId = cpUniqueId;
	}

	public String getCpUniqueIdType() {
		return cpUniqueIdType;
	}

	public void setCpUniqueIdType(String cpUniqueIdType) {
		this.cpUniqueIdType = cpUniqueIdType;
	}

	public String getCpIsUidValid() {
		return cpIsUidValid;
	}

	public void setCpIsUidValid(String cpIsUidValid) {
		this.cpIsUidValid = cpIsUidValid;
	}

	public boolean getCpIsMobileValid() {
		if(cpIsMobileValid.equalsIgnoreCase("yes"))
		return true;
		else
			return false;
	}

	public void setCpIsMobileValid(String cpIsMobileValid) {
		this.cpIsMobileValid = cpIsMobileValid;
	}

	public boolean getCpIsEmailValid() {
		if(cpIsEmailValid.equalsIgnoreCase("yes"))
			return true;
			else
				return false;
	}

	public void setCpIsEmailValid(String cpIsEmailValid) {
		this.cpIsEmailValid = cpIsEmailValid;
	}

	public boolean getCpIsActive() {
		if(cpIsActive.equalsIgnoreCase("yes"))
			return true;
			else
				return false;
	}

	public void setCpIsActive(String cpIsActive) {
		this.cpIsActive = cpIsActive;
	}

	public String getCpGender() {
		return cpGender;
	}

	public void setCpGender(String cpGender) {
		this.cpGender = cpGender;
	}


	public Date getCpCreatedOn() {
		return cpCreatedOn;
	}


	public void setCpCreatedOn(Date cpCreatedOn) {
		this.cpCreatedOn = cpCreatedOn;
	}


	public Date getCpLastModifiedOn() {
		return cpLastModifiedOn;
	}


	public void setCpLastModifiedOn(Date cpLastModifiedOn) {
		this.cpLastModifiedOn = cpLastModifiedOn;
	}

	
}
