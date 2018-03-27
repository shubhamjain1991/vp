package com.vp.service;

import com.vp.bean.CustomerApplicationFormBean;
import com.vp.bean.CustomerResponseBean;
import com.vp.bean.RegistrartionFromBean;

public interface CustomerProfileService {

	public CustomerResponseBean customerProfiles(int startIndex, int rowCount);
	public RegistrartionFromBean putCustomerDetais(RegistrartionFromBean registrartionFromBean);
	public RegistrartionFromBean userLogin(RegistrartionFromBean registrartionFromBean);
	public CustomerApplicationFormBean createCustomerAppointment(CustomerApplicationFormBean customerApplicationFormBean);
	
}
