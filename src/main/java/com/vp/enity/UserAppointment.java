package com.vp.enity;

import java.io.Serializable;

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
@Table(name="user_appointment")
public class UserAppointment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ua_id")
	private String uaId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ua_customer_id")
	private CustomerProfile customerProfile;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ua_sp_id")
	private ServiceProviders serviceProvider;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ua_af_id")
	private ApplicationForm applicationForm;
	
	@Column(name="ua_is_appointment_approved")
	private String uaIsAppointmentApproved;
	
	@Column(name="ua_is_client_notified")
	private String uaIsClientNotified;
	
	@Column(name="ua_is_client_notifed_on_same_day")
	private String uaIsClientNotifedOnSameDay;
	
	@Column(name="ua_alloted_meeting_datetime")
	private String uaAllotedMeetingDatetime;
	
	@Column(name="ua_created_date")
	private String uaCreatedDate;
	
	@Column(name="ua_updated_date")
	private String uaUpdatedDate;

	public UserAppointment() {
		super();
	}

	public UserAppointment(String uaId, CustomerProfile customerProfile, ServiceProviders serviceProvider,
			ApplicationForm applicationForm, String uaIsAppointmentApproved, String uaIsClientNotified,
			String uaIsClientNotifedOnSameDay, String uaAllotedMeetingDatetime, String uaCreatedDate,
			String uaUpdatedDate) {
		super();
		this.uaId = uaId;
		this.customerProfile = customerProfile;
		this.serviceProvider = serviceProvider;
		this.applicationForm = applicationForm;
		this.uaIsAppointmentApproved = uaIsAppointmentApproved;
		this.uaIsClientNotified = uaIsClientNotified;
		this.uaIsClientNotifedOnSameDay = uaIsClientNotifedOnSameDay;
		this.uaAllotedMeetingDatetime = uaAllotedMeetingDatetime;
		this.uaCreatedDate = uaCreatedDate;
		this.uaUpdatedDate = uaUpdatedDate;
	}

	public String getUaId() {
		return uaId;
	}

	public void setUaId(String uaId) {
		this.uaId = uaId;
	}

	public String getUaIsAppointmentApproved() {
		return uaIsAppointmentApproved;
	}

	public void setUaIsAppointmentApproved(String uaIsAppointmentApproved) {
		this.uaIsAppointmentApproved = uaIsAppointmentApproved;
	}

	public String getUaIsClientNotified() {
		return uaIsClientNotified;
	}

	public void setUaIsClientNotified(String uaIsClientNotified) {
		this.uaIsClientNotified = uaIsClientNotified;
	}

	public String getUaIsClientNotifedOnSameDay() {
		return uaIsClientNotifedOnSameDay;
	}

	public void setUaIsClientNotifedOnSameDay(String uaIsClientNotifedOnSameDay) {
		this.uaIsClientNotifedOnSameDay = uaIsClientNotifedOnSameDay;
	}

	public String getUaAllotedMeetingDatetime() {
		return uaAllotedMeetingDatetime;
	}

	public void setUaAllotedMeetingDatetime(String uaAllotedMeetingDatetime) {
		this.uaAllotedMeetingDatetime = uaAllotedMeetingDatetime;
	}

	public String getUaCreatedDate() {
		return uaCreatedDate;
	}

	public void setUaCreatedDate(String uaCreatedDate) {
		this.uaCreatedDate = uaCreatedDate;
	}

	public String getUaUpdatedDate() {
		return uaUpdatedDate;
	}

	public void setUaUpdatedDate(String uaUpdatedDate) {
		this.uaUpdatedDate = uaUpdatedDate;
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

	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

}
