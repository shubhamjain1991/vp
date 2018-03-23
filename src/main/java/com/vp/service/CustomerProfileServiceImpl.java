package com.vp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.bean.CustomerResponseBean;
import com.vp.constant.MessageConstants;
import com.vp.dao.CustomerProfileDAO;
import com.vp.enity.CustomerProfile;
import com.vp.validator.CustomerValidator;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

	@Autowired
	protected CustomerProfileDAO customerProfileDAO;

	@Override
	public CustomerResponseBean customerProfiles(int startIndex, int rowCount) {
		CustomerResponseBean responseBean = new CustomerResponseBean();
		List<CustomerProfile> customerProfiles = customerProfileDAO.findAll(startIndex, rowCount);
		if (null != customerProfiles && !customerProfiles.isEmpty()) {
			for (CustomerProfile cp : customerProfiles) {
				cp.setCpPwd(null);
			}
			return CustomerValidator.getInstance().getCustomerResponseBean(true,MessageConstants.GET_CUSTOMER_PROFILES_SUCCESS, responseBean);
		}
		return CustomerValidator.getInstance().getCustomerResponseBean(false, MessageConstants.NO_CUSTOMER_PROFILES_FOUND, responseBean);
	}

}
