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
@Table(name="application_form")
public class ApplicationForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="af_id")
	private Long af_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "af_customer_id")
	private CustomerProfile customerProfile;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "af_sp_id")
	private ServiceProviders serviceProvider;
	
	@Column(name="af_requester_name")
	private String afRequesterName;
	
	@Column(name="af_cause_of_meeting")
	private String afCauseOfMeeting;
	
	@Column(name="af_special_notes")
	private String afSpecialNotes;
	
	@Column(name="af_time_duration_estimate")
	private Integer afTimeDurationEstimate;
	
	@Column(name="af_req_meeting_datetime")
	private Long afReqMeetingDatetime;
	
	@Column(name="af_created_date")
	private Date afCreatedDate;
	
	@Column(name="af_last_modified_date")
	private Date afUpdatedDate;

	public ApplicationForm() {
		super();
	}
	
	public ApplicationForm(Long af_id, CustomerProfile customerProfile, ServiceProviders serviceProvider,
			String afRequesterName, String afCauseOfMeeting, String afSpecialNotes, Integer afTimeDurationEstimate,
			Long afReqMeetingDatetime, Date afCreatedDate, Date afUpdatedDate) {
		super();
		this.af_id = af_id;
		this.customerProfile = customerProfile;
		this.serviceProvider = serviceProvider;
		this.afRequesterName = afRequesterName;
		this.afCauseOfMeeting = afCauseOfMeeting;
		this.afSpecialNotes = afSpecialNotes;
		this.afTimeDurationEstimate = afTimeDurationEstimate;
		this.afReqMeetingDatetime = afReqMeetingDatetime;
		this.afCreatedDate = afCreatedDate;
		this.afUpdatedDate = afUpdatedDate;
	}

	public Long getAf_id() {
		return af_id;
	}

	public void setAf_id(Long af_id) {
		this.af_id = af_id;
	}

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}

	public ServiceProviders getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviders serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getAfRequesterName() {
		return afRequesterName;
	}

	public void setAfRequesterName(String afRequesterName) {
		this.afRequesterName = afRequesterName;
	}

	public String getAfCauseOfMeeting() {
		return afCauseOfMeeting;
	}

	public void setAfCauseOfMeeting(String afCauseOfMeeting) {
		this.afCauseOfMeeting = afCauseOfMeeting;
	}

	public String getAfSpecialNotes() {
		return afSpecialNotes;
	}

	public void setAfSpecialNotes(String afSpecialNotes) {
		this.afSpecialNotes = afSpecialNotes;
	}

	public Integer getAfTimeDurationEstimate() {
		return afTimeDurationEstimate;
	}

	public void setAfTimeDurationEstimate(Integer afTimeDurationEstimate) {
		this.afTimeDurationEstimate = afTimeDurationEstimate;
	}

	public Long getAfReqMeetingDatetime() {
		return afReqMeetingDatetime;
	}

	public void setAfReqMeetingDatetime(Long afReqMeetingDatetime) {
		this.afReqMeetingDatetime = afReqMeetingDatetime;
	}

	public Date getAfCreatedDate() {
		return afCreatedDate;
	}

	public void setAfCreatedDate(Date afCreatedDate) {
		this.afCreatedDate = afCreatedDate;
	}

	public Date getAfUpdatedDate() {
		return afUpdatedDate;
	}

	public void setAfUpdatedDate(Date afUpdatedDate) {
		this.afUpdatedDate = afUpdatedDate;
	}
	
}
