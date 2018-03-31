package com.vp.enity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_details")
public class AddressDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addr_id")
	private Long addrId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addr_customer_id")
	private CustomerProfile customerProfile;
	
	@Column(name="addr_type")
	private String  addrType;
	
	@Column(name="addr_streat")
	private String  addrStreat;
	
	@Column(name="addr_landmark")
	private String  addrLandmark;
	
	@Column(name="addr_city")
	private String  addrCity;
	
	@Column(name="addr_area")
	private String  addrArea;
	
	@Column(name="addr_pincode")
	private String  addrPincode;
	
	@Column(name="addr_state")
	private String  addrState;
	
	@Column(name="addr_country")
	private String  addrCountry;
	
	@Column(name="addr_created")
	private Date  addrCreated;
	
	@Column(name="addr_updated")
	private Date  addrUpdated;

	public AddressDetails(){
		super();
	}

	public AddressDetails(Long addrId, CustomerProfile customerProfile, String addrType, String addrStreat,
			String addrLandmark, String addrCity, String addrArea, String addrPincode, String addrState,
			String addrCountry, Date addrCreated, Date addrUpdated) {
		super();
		this.addrId = addrId;
		this.customerProfile = customerProfile;
		this.addrType = addrType;
		this.addrStreat = addrStreat;
		this.addrLandmark = addrLandmark;
		this.addrCity = addrCity;
		this.addrArea = addrArea;
		this.addrPincode = addrPincode;
		this.addrState = addrState;
		this.addrCountry = addrCountry;
		this.addrCreated = addrCreated;
		this.addrUpdated = addrUpdated;
	}

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}



	public Long getAddrId() {		
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddrStreat() {
		return addrStreat;
	}

	public void setAddrStreat(String addrStreat) {
		this.addrStreat = addrStreat;
	}

	public String getAddrLandmark() {
		return addrLandmark;
	}

	public void setAddrLandmark(String addrLandmark) {
		this.addrLandmark = addrLandmark;
	}

	public String getAddrCity() {
		return addrCity;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}

	public String getAddrArea() {
		return addrArea;
	}

	public void setAddrArea(String addrArea) {
		this.addrArea = addrArea;
	}

	public String getAddrPincode() {
		return addrPincode;
	}

	public void setAddrPincode(String addrPincode) {
		this.addrPincode = addrPincode;
	}

	public String getAddrState() {
		return addrState;
	}

	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}

	public String getAddrCountry() {
		return addrCountry;
	}

	public void setAddrCountry(String addrCountry) {
		this.addrCountry = addrCountry;
	}

	public Date getAddrCreated() {
		return addrCreated;
	}

	public void setAddrCreated(Date addrCreated) {
		this.addrCreated = addrCreated;
	}

	public Date getAddrUpdated() {
		return addrUpdated;
	}

	public void setAddrUpdated(Date addrUpdated) {
		this.addrUpdated = addrUpdated;
	}
	
	
}
