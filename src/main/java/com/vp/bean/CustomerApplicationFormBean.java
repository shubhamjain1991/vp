package com.vp.bean;

import java.io.Serializable;

import com.vp.util.Common;

public class CustomerApplicationFormBean extends Common implements Serializable {
	
	
	private  String userID = "";
	private  String ServiceProviderId = "";
	private  String RequesterName = "";
	private  String CauseOfMeeting = "";
	private  String SpecialNotes = "";
	private  String TimeDurationEstimate = "";
	private String timeSlot= "";
	
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getServiceProviderId() {
		return ServiceProviderId;
	}
	public void setServiceProviderId(String serviceProviderId) {
		ServiceProviderId = serviceProviderId;
	}
	public String getRequesterName() {
		return RequesterName;
	}
	public void setRequesterName(String requesterName) {
		RequesterName = requesterName;
	}
	public String getCauseOfMeeting() {
		return CauseOfMeeting;
	}
	public void setCauseOfMeeting(String causeOfMeeting) {
		CauseOfMeeting = causeOfMeeting;
	}
	public String getSpecialNotes() {
		return SpecialNotes;
	}
	public void setSpecialNotes(String specialNotes) {
		SpecialNotes = specialNotes;
	}
	public String getTimeDurationEstimate() {
		return TimeDurationEstimate;
	}
	public void setTimeDurationEstimate(String timeDurationEstimate) {
		TimeDurationEstimate = timeDurationEstimate;
	}
	

	

}
