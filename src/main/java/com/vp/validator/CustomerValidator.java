package com.vp.validator;

import com.vp.bean.CustomerResponseBean;
import com.vp.constant.MessageConstants;
import com.vp.enity.MessageCode;

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
	
	public CustomerResponseBean validateCustomerProfiles(String startIndex, String rowCount){
		if(!isValidData(startIndex)){
			return getCustomerResponseBean(false, MessageConstants.EMPTY_START_INDEX, new  CustomerResponseBean());
		}
		if(!isValidData(rowCount)){
			return getCustomerResponseBean(false, MessageConstants.EMPTY_ROW_COUNT, new  CustomerResponseBean());
		}
		if(!isValidStartIndex(startIndex)){
			return getCustomerResponseBean(false, MessageConstants.INVALID_START_INDEX, new  CustomerResponseBean());
		}
		if(!isValidRowCount(rowCount)){
			return getCustomerResponseBean(false, MessageConstants.INVALID_ROW_COUNT, new  CustomerResponseBean());
		}
		return new CustomerResponseBean();
	}
	
	public CustomerResponseBean getCustomerResponseBean(boolean isValid, String mcTitle, CustomerResponseBean customerResponseBean){
		if(null == customerResponseBean){
			customerResponseBean = new CustomerResponseBean();
		}
		customerResponseBean.setValid(isValid);
		MessageCode messageCode = new MessageCode();
		messageCode.setMcTitle(mcTitle);
		messageCode.setMcDesc(mcTitle);
		customerResponseBean.setMessageCode(messageCode);
		return customerResponseBean;
	}
	
	
}
