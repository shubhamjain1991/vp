package com.vp.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vp.bean.CustomerApplicationFormBean;
import com.vp.bean.CustomerResponseBean;
import com.vp.bean.RegistrartionFromBean;
import com.vp.constant.MessageConstants;
import com.vp.dao.CustomerAppointmentDAO;
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
	@Autowired
	protected CustomerAppointmentDAO customerAppointmentDAO;
	
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

	@Override
	public RegistrartionFromBean userLogin(RegistrartionFromBean registrartionFromBean) {

		HashSet<MessageCode> messageCodes = new HashSet<MessageCode>();
		CustomerProfile customerProfile = customerProfileDAO.userLogin(registrartionFromBean.getCustomerUserName(), registrartionFromBean.getCustomerPassword());
		if(customerProfile!= null){
			//Setting Details of User
			if(( customerProfile.getCpIsEmailValid() || customerProfile.getCpIsMobileValid() ) && customerProfile.getCpIsActive()){
			registrartionFromBean.setCustomerFirstName(customerProfile.getCpFirstName());
			registrartionFromBean.setCustomerLastName(customerProfile.getCpLastName());
			registrartionFromBean.setCustomerMobileNumber(customerProfile.getCpMobile()+"");
			registrartionFromBean.setCustomerType(customerProfile.getCpType());
			registrartionFromBean.setCustomerEmailAddress(customerProfile.getCpEmail());
			messageCodes.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.LOGIN_SUCCESSFULL));
			return (RegistrartionFromBean) CustomerValidator.getInstance().getObjectBean(true, messageCodes, registrartionFromBean);
			}else{
				messageCodes.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.PROFILE_NOT_ACTIVE));
				return (RegistrartionFromBean) CustomerValidator.getInstance().getObjectBean(false, messageCodes, common);	
			}
			
		}
		messageCodes.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.LOGIN_FAILURE));
		 return (RegistrartionFromBean) CustomerValidator.getInstance().getObjectBean(false, messageCodes, common);
	}
	
	@Override
	public CustomerApplicationFormBean createCustomerAppointment(CustomerApplicationFormBean customerApplicationFormBean){
		HashSet <MessageCode> messageCodes = new HashSet<MessageCode>();
		CustomerValidator customerValidator = CustomerValidator.getInstance();
		if(customerAppointmentDAO.isTimeSlotFree(customerApplicationFormBean.getTimeSlot(), customerApplicationFormBean.getServiceProviderId() , customerApplicationFormBean.getUserID())){
			messageCodes.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.TIME_SLOT_NOT_FREE));
			return (CustomerApplicationFormBean) customerValidator.getObjectBean(false, messageCodes, customerApplicationFormBean);
		}
		if(customerAppointmentDAO.createCustomerAppointment(customerApplicationFormBean)){
			messageCodes.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.APPOINTMENT_SENT_TO_PROVIDER));
			return (CustomerApplicationFormBean) customerValidator.getObjectBean(true, messageCodes, customerApplicationFormBean);
		}
		messageCodes.add(CustomerValidator.getInstance().getMessageCode(MessageConstants.INTERNAL_SERVER_ERROR));
		return (CustomerApplicationFormBean) customerValidator.getObjectBean(false, messageCodes, customerApplicationFormBean);
	}

}
