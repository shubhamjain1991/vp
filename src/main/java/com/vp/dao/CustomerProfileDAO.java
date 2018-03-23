package com.vp.dao;

import java.util.List;

import com.vp.enity.CustomerProfile;

public interface CustomerProfileDAO {

	public List<CustomerProfile> findAll(int startIndex, int rowCount);
	
}
