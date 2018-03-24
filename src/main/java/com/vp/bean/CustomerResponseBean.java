package com.vp.bean;

import java.io.Serializable;
import java.util.List;

import com.vp.enity.CustomerProfile;
import com.vp.util.Common;

public class CustomerResponseBean extends Common implements Serializable{

	private static final long serialVersionUID = 1L;

	
	
	private String startIndex;
	private String rowCount;
	private List<CustomerProfile> customerProfiles;
	
	public CustomerResponseBean(){
		super();
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
