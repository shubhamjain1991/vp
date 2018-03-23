package com.vp.bean;

import java.io.Serializable;
import java.util.List;
import com.vp.enity.CustomerProfile;
import com.vp.enity.MessageCode;

public class CustomerResponseBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean isValid;
	private MessageCode messageCode;
	private String startIndex;
	private String rowCount;
	private List<CustomerProfile> customerProfiles;
	
	public CustomerResponseBean(){
		super();
	}

	public CustomerResponseBean(boolean isValid, MessageCode messageCode) {
		super();
		this.isValid = isValid;
		this.messageCode = messageCode;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(MessageCode messageCode) {
		this.messageCode = messageCode;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public List<CustomerProfile> getCustomerProfiles() {
		return customerProfiles;
	}

	public void setCustomerProfiles(List<CustomerProfile> customerProfiles) {
		this.customerProfiles = customerProfiles;
	}

}
