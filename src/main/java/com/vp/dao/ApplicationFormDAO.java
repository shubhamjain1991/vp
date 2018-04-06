package com.vp.dao;

import java.util.List;

import com.vp.enity.ApplicationForm;

public interface ApplicationFormDAO {

	public List<ApplicationForm> findByAfSpId(Long afSpId);
	public List<ApplicationForm> findByAfCustomerId(Long afCustomerId);
	
}
