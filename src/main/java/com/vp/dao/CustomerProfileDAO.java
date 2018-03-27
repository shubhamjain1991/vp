package com.vp.dao;

import java.util.List;

import com.vp.bean.CustomerApplicationFormBean;
import com.vp.bean.RegistrartionFromBean;
import com.vp.enity.CustomerProfile;

public interface CustomerProfileDAO {

	public List<CustomerProfile> findAll(int startIndex, int rowCount);
	public boolean putCustomerDetails (RegistrartionFromBean registrartionFromBean);
	public boolean findByEmail(String emailAddress);
	public boolean findByMobile(String mobileNumber);
	public boolean findByUserName(String userName);
	public boolean findExistingUser(String email , String mobile , String userName);
	public CustomerProfile userLogin(String userName , String password);
	
	
}
