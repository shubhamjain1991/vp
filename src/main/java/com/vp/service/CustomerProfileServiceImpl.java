package com.vp.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vp.bean.CustomerResponseBean;
import com.vp.bean.RegistrartionFromBean;
import com.vp.constant.MessageConstants;
import com.vp.dao.CustomerProfileDAO;
import com.vp.enity.CustomerProfile;
import com.vp.enity.MessageCode;
import com.vp.util.Common;
import com.vp.validator.CustomerValidator;

@Component
public class CustomerProfileServiceImpl implements CustomerProfileService {

	@Autowired
	Common common;
	
	@Autowired
	protected CustomerProfileDAO customerProfileDAO;
	
	@Override
	public CustomerResponseBean customerProfiles(int startIndex, int rowCount) {
		
		List<CustomerProfile> customerProfiles = customerProfileDAO.findAll(startIndex, rowCount);
		HashSet<MessageCode> messageCode = new HashSet<MessageCode>();
		if (null != customerProfiles && !customerProfiles.isEmpty()) {
			for (CustomerProfile cp : customerProfiles) {
				cp.setCpPwd(null);
			}
			messageCode.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.GET_CUSTOMER_PROFILES_SUCCESS));
			return (CustomerResponseBean) CustomerValidator.getInstance().getObjectBean(true, messageCode, common);
		}
		messageCode.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.NO_CUSTOMER_PROFILES_FOUND));
		return (CustomerResponseBean) CustomerValidator.getInstance().getObjectBean(false,  messageCode, common);
	}
	
	@Override
	public RegistrartionFromBean putCustomerDetais(RegistrartionFromBean registrartionFromBean) {
		// TODO Auto-generated method stub
		HashSet<MessageCode> messageCode = new HashSet<MessageCode>();
		if(! customerProfileDAO.findExistingUser(registrartionFromBean.getCustomerEmailAddress(), registrartionFromBean.getCustomerMobileNumber(), registrartionFromBean.getCustomerUserName())){
			if (customerProfileDAO.putCustomerDetails(registrartionFromBean)) {
				messageCode.add(CustomerValidator.getInstance()
						.getMessageCode(MessageConstants.CUSTOMER_PROFILE_INSERTED_SUCCESSFULLY));
				return (RegistrartionFromBean) CustomerValidator.getInstance().getObjectBean(true, messageCode, common);
			}
			else{
				messageCode.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.CUSTOMER_PROFILE_INSERTED_FAILURE));
				return (RegistrartionFromBean) CustomerValidator.getInstance().getObjectBean(false, messageCode, common);
			}
		}else{
			messageCode.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.PROFILE_ALREADY_EXISTS));
			return (RegistrartionFromBean) CustomerValidator.getInstance().getObjectBean(false, messageCode, common);
		}
		
		
	}

}
