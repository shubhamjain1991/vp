package com.vp.enity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer_profile")
public class CustomerProfile implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cp_id")
	private Long cpId;
	
	@Column(name="cp_type")
	private String cpType;
	
	@Column(name="cp_email")
	private String cpEmail;
	
	@Column(name="cp_mobile")
	private Long cpMobile;
	
	@Column(name="cp_first_name")
	private String cpFirstName;
	
	@Column(name="cp_last_name")
	private String cpLastName;
	
	@Column(name="cp_user_name")
	private String cpUserName;
	
	@Column(name="cp_pwd")
	private String cpPwd;
	
	@Column(name="cp_unique_id")
	private String cpUniqueId;
	
	@Column(name="cp_unique_id_type")
	private String cpUniqueIdType;
	
	@Column(name="cp_is_uid_valid")
	private String cpIsUidValid;
	
	@Column(name="cp_is_mobile_valid")
	private String cpIsMobileValid;
	
	@Column(name="cp_is_email_valid")
	private String cpIsEmailValid;
	
	@Column(name="cp_is_active")
	private String cpIsActive;
	
	@Column(name="cp_gender")
	private String cpGender;
	
	@Column(name="cp_created_by")
	private String cpCreatedBy;
	
	@Column(name="cp_created_date")
	private Date cpCreatedDate;
	
	@Column(name="cp_updated_by")
	private String cpUpdatedBy;
	
	@Column(name="cp_updated_date")
	private Date cpUpdatedDate;

	public CustomerProfile(){
		super();
	}
	
	public CustomerProfile(Long cpId, String cpType, String cpEmail, Long cpMobile, String cpFirstName,
			String cpLastName, String cpUserName, String cpPwd, String cpUniqueId, String cpUniqueIdType,
			String cpIsUidValid, String cpIsMobileValid, String cpIsEmailValid, String cpIsActive, String cpGender,
			String cpCreatedBy, Date cpCreatedDate, String cpUpdatedBy, Date cpUpdatedDate) {
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
		this.cpCreatedBy = cpCreatedBy;
		this.cpCreatedDate = cpCreatedDate;
		this.cpUpdatedBy = cpUpdatedBy;
		this.cpUpdatedDate = cpUpdatedDate;
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

	public String getCpCreatedBy() {
		return cpCreatedBy;
	}

	public void setCpCreatedBy(String cpCreatedBy) {
		this.cpCreatedBy = cpCreatedBy;
	}

	public Date getCpCreatedDate() {
		return cpCreatedDate;
	}

	public void setCpCreatedDate(Date cpCreatedDate) {
		this.cpCreatedDate = cpCreatedDate;
	}

	public String getCpUpdatedBy() {
		return cpUpdatedBy;
	}

	public void setCpUpdatedBy(String cpUpdatedBy) {
		this.cpUpdatedBy = cpUpdatedBy;
	}

	public Date getCpUpdatedDate() {
		return cpUpdatedDate;
	}

	public void setCpUpdatedDate(Date cpUpdatedDate) {
		this.cpUpdatedDate = cpUpdatedDate;
	}
}
