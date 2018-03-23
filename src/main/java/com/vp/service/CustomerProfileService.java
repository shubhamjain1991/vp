package com.vp.service;

import com.vp.bean.CustomerResponseBean;

public interface CustomerProfileService {

	public CustomerResponseBean customerProfiles(int startIndex, int rowCount);
	
}
