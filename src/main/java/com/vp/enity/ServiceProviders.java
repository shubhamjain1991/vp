package com.vp.enity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_providers")
public class ServiceProviders implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sp_id")
	private Long spId;
	
	@Column(name="sp_customer_id")
	private Long spCustomerId;
	
	@Column(name="sp_addr_id")
	private Long spAddrId;
	
	@Column(name="sp_profession")
	private String spProfession;
	
	@Column(name="sp_sub_profession")
	private String spSubProfession;
	
	@Column(name="sp_highest_qualifiaction")
	private String spHighestQualifiaction;
	
	@Column(name="sp_collage_name")
	private String spCollageName;
	
	@Column(name="sp_year_of_pass_out")
	private Integer spYearOfPassOut;
	
	@Column(name="sp_total_year_of_experience")
	private Integer spSotalYearOfExperience;
	
	@Column(name="sp_profile_head_line")
	private String spProfileHeadLine;
	
	@Column(name="sp_about_your_self")
	private String spAboutYourSelf;
	
	@Column(name="sp_certificate_serial_number")
	private String spCertificateSerialNumber;
	
	@Column(name="sp_is_certificate_validate")
	private String spIsCertificateValidate;
	
	@Column(name="sp_certificate_scan_url")
	private String spCertificateScanUrl;
	
	@Column(name="sp_proflie_pic_url")
	private String spProfliePicUrl;
	
	@Column(name="sp_created_date")
	private Date spCreatedDate;
	
	@Column(name="sp_updated_date")
	private Date spUpdatedDate;

	public ServiceProviders() {
		super();
	}
	
	public ServiceProviders(Long spId, Long spCustomerId, Long spAddrId, String spProfession, String spSubProfession,
			String spHighestQualifiaction, String spCollageName, Integer spYearOfPassOut,
			Integer spSotalYearOfExperience, String spProfileHeadLine, String spAboutYourSelf,
			String spCertificateSerialNumber, String spIsCertificateValidate, String spCertificateScanUrl,
			String spProfliePicUrl, Date spCreatedDate, Date spUpdatedDate) {
		super();
		this.spId = spId;
		this.spCustomerId = spCustomerId;
		this.spAddrId = spAddrId;
		this.spProfession = spProfession;
		this.spSubProfession = spSubProfession;
		this.spHighestQualifiaction = spHighestQualifiaction;
		this.spCollageName = spCollageName;
		this.spYearOfPassOut = spYearOfPassOut;
		this.spSotalYearOfExperience = spSotalYearOfExperience;
		this.spProfileHeadLine = spProfileHeadLine;
		this.spAboutYourSelf = spAboutYourSelf;
		this.spCertificateSerialNumber = spCertificateSerialNumber;
		this.spIsCertificateValidate = spIsCertificateValidate;
		this.spCertificateScanUrl = spCertificateScanUrl;
		this.spProfliePicUrl = spProfliePicUrl;
		this.spCreatedDate = spCreatedDate;
		this.spUpdatedDate = spUpdatedDate;
	}

	public Long getSpId() {
		return spId;
	}

	public void setSpId(Long spId) {
		this.spId = spId;
	}

	public Long getSpCustomerId() {
		return spCustomerId;
	}

	public void setSpCustomerId(Long spCustomerId) {
		this.spCustomerId = spCustomerId;
	}

	public Long getSpAddrId() {
		return spAddrId;
	}

	public void setSpAddrId(Long spAddrId) {
		this.spAddrId = spAddrId;
	}

	public String getSpProfession() {
		return spProfession;
	}

	public void setSpProfession(String spProfession) {
		this.spProfession = spProfession;
	}

	public String getSpSubProfession() {
		return spSubProfession;
	}

	public void setSpSubProfession(String spSubProfession) {
		this.spSubProfession = spSubProfession;
	}

	public String getSpHighestQualifiaction() {
		return spHighestQualifiaction;
	}

	public void setSpHighestQualifiaction(String spHighestQualifiaction) {
		this.spHighestQualifiaction = spHighestQualifiaction;
	}

	public String getSpCollageName() {
		return spCollageName;
	}

	public void setSpCollageName(String spCollageName) {
		this.spCollageName = spCollageName;
	}

	public Integer getSpYearOfPassOut() {
		return spYearOfPassOut;
	}

	public void setSpYearOfPassOut(Integer spYearOfPassOut) {
		this.spYearOfPassOut = spYearOfPassOut;
	}

	public Integer getSpSotalYearOfExperience() {
		return spSotalYearOfExperience;
	}

	public void setSpSotalYearOfExperience(Integer spSotalYearOfExperience) {
		this.spSotalYearOfExperience = spSotalYearOfExperience;
	}

	public String getSpProfileHeadLine() {
		return spProfileHeadLine;
	}

	public void setSpProfileHeadLine(String spProfileHeadLine) {
		this.spProfileHeadLine = spProfileHeadLine;
	}

	public String getSpAboutYourSelf() {
		return spAboutYourSelf;
	}

	public void setSpAboutYourSelf(String spAboutYourSelf) {
		this.spAboutYourSelf = spAboutYourSelf;
	}

	public String getSpCertificateSerialNumber() {
		return spCertificateSerialNumber;
	}

	public void setSpCertificateSerialNumber(String spCertificateSerialNumber) {
		this.spCertificateSerialNumber = spCertificateSerialNumber;
	}

	public String getSpIsCertificateValidate() {
		return spIsCertificateValidate;
	}

	public void setSpIsCertificateValidate(String spIsCertificateValidate) {
		this.spIsCertificateValidate = spIsCertificateValidate;
	}

	public String getSpCertificateScanUrl() {
		return spCertificateScanUrl;
	}

	public void setSpCertificateScanUrl(String spCertificateScanUrl) {
		this.spCertificateScanUrl = spCertificateScanUrl;
	}

	public String getSpProfliePicUrl() {
		return spProfliePicUrl;
	}

	public void setSpProfliePicUrl(String spProfliePicUrl) {
		this.spProfliePicUrl = spProfliePicUrl;
	}

	public Date getSpCreatedDate() {
		return spCreatedDate;
	}

	public void setSpCreatedDate(Date spCreatedDate) {
		this.spCreatedDate = spCreatedDate;
	}

	public Date getSpUpdatedDate() {
		return spUpdatedDate;
	}

	public void setSpUpdatedDate(Date spUpdatedDate) {
		this.spUpdatedDate = spUpdatedDate;
	}
	
}
