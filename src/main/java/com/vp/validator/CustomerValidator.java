package com.vp.validator;

import java.util.HashSet;

import com.vp.bean.CustomerApplicationFormBean;
import com.vp.bean.CustomerResponseBean;
import com.vp.bean.RegistrartionFromBean;
import com.vp.constant.MessageConstants;
import com.vp.enity.MessageCode;
import com.vp.util.Common;

public class CustomerValidator extends Validator{

	private CustomerValidator(){
		super();
	}
	
	private static CustomerValidator customerValidator;
	
	public static CustomerValidator getInstance(){
		if(null == customerValidator){
			customerValidator = new CustomerValidator();
		}
		return customerValidator;
	}
	
	public CustomerApplicationFormBean validateCustomerApplicationForm(CustomerApplicationFormBean customerApplicationFormBean){
		HashSet<MessageCode> errorMessages = new HashSet<MessageCode>();
		if(!isValidData(customerApplicationFormBean.getCauseOfMeeting())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_MEETING_DESCRIPTION));
		}
		if(!isValidData(customerApplicationFormBean.getRequesterName())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_REQUESTER_NAME));
		}
		if(!isValidInteger(customerApplicationFormBean.getTimeSlot())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_OR_INVALID_TIME_SLOT));
		}
		if(errorMessages.isEmpty()){
			return (CustomerApplicationFormBean) getObjectBean(false, errorMessages, new Common());
		}
		return null;
	}
	
	public RegistrartionFromBean validateLoginForm(RegistrartionFromBean registrartionFromBean){
		HashSet<MessageCode> errorMessages = new HashSet<MessageCode>();
		
		if(!isValidData(registrartionFromBean.getCustomerPassword())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_PASSWORD));
		} 
		if(!isValidData(registrartionFromBean.getCustomerEmailAddress())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_CUSTOMER_EMAIL));
		}
		if(!errorMessages.isEmpty()){
			return (RegistrartionFromBean) getObjectBean(false, errorMessages, new Common());
		}
		return null;
		
	}
	
	public RegistrartionFromBean validateRegistrationForm (RegistrartionFromBean registrartionFromBean){
		HashSet<MessageCode> errorMessages = new HashSet<MessageCode>();
		if(!isValidData(registrartionFromBean.getCustomerFirstName())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_NAME));
		}
		if(!isValidData(registrartionFromBean.getCustomerPassword())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_PASSWORD));
		}
		if(!isValidData(registrartionFromBean.getCustomerType())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_CUSTOMER_TYPE));
		}
		if(!isValidCustomerType(registrartionFromBean.getCustomerType())){
			errorMessages.add(getMessageCode(MessageConstants.INVALID_CUSTOMER_TYPE));
		}
		
		if(!isValidData(registrartionFromBean.getCustomerEmailAddress())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_CUSTOMER_EMAIL));
		}
		else if(isValidEmaiAddress(registrartionFromBean.getCustomerEmailAddress())){
			errorMessages.add(getMessageCode(MessageConstants.INVALID_CUSTOMER_EMAIL));
		}
		
		if(isValidData(registrartionFromBean.getCustomerMobileNumber())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_CUSTOMER_MOBILE));
		}
		else if(isValidMobile(registrartionFromBean.getCustomerMobileNumber())){
			errorMessages.add(getMessageCode(MessageConstants.INVALID_CUSTOMER_MOBILE));
		}	
		if(!isValidData(registrartionFromBean.getCustomerUserName())){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_USERNAME));
		}
		if(!errorMessages.isEmpty()){
			return (RegistrartionFromBean) getObjectBean(false, errorMessages, new Common());
		}
		return null;
	}
	
	public CustomerResponseBean validateCustomerProfiles(String startIndex, String rowCount){
		HashSet<MessageCode> errorMessages = new HashSet<MessageCode>();
		if(!isValidData(startIndex)){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_START_INDEX));
			//return (CustomerResponseBean) getObjectBean(false, MessageConstants.EMPTY_START_INDEX, new  Common());
		}
		if(!isValidData(rowCount)){
			errorMessages.add(getMessageCode(MessageConstants.EMPTY_ROW_COUNT));
			//return (CustomerResponseBean) getObjectBean(false, MessageConstants.EMPTY_ROW_COUNT, new  Common());
		}
		if(!isValidStartIndex(startIndex)){
			errorMessages.add(getMessageCode(MessageConstants.INVALID_START_INDEX));
			//return (CustomerResponseBean) getObjectBean(false, MessageConstants.INVALID_START_INDEX, new  Common());
		}
		if(!isValidRowCount(rowCount)){
			errorMessages.add(getMessageCode(MessageConstants.INVALID_ROW_COUNT));
			//return (CustomerResponseBean) getObjectBean(false, MessageConstants.INVALID_ROW_COUNT, new  Common());
		}
		if(!errorMessages.isEmpty()){
			return (CustomerResponseBean) getObjectBean(false, errorMessages, new Common());
		}
		return null;
	}
	
	public MessageCode getMessageCode(String mcTitle){
		MessageCode messageCode = new MessageCode();
		messageCode.setMcTitle(mcTitle);
		messageCode.setMcDesc(mcTitle);
		return messageCode;
	}
	
	public Common getObjectBean(boolean isValid, HashSet<MessageCode> errors, Common common){
		common.setValid(isValid);
		common.setMessageCode(errors);
		return common;
	}
	
	
}
