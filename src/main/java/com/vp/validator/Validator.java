package com.vp.validator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vp.constant.ApplicationConstant;

public abstract class Validator {
	
	private static Pattern pattern;
	private Matcher matcher;
	private void mobileValidator(){
		this.pattern = Pattern.compile(ApplicationConstant.MOBILE_REGEX);
	}
	public boolean isValidMobile(String mobile){
		mobileValidator();
		matcher = pattern.matcher(mobile);
		if(matcher.find() && matcher.group().equals(mobile))
			return true;
		return false;
	}
	private void emailValidator(){
		this.pattern = Pattern.compile(ApplicationConstant.EMAIL_REGEX , Pattern.CASE_INSENSITIVE );
	}
	
	
	public boolean isValidEmaiAddress(String email){
		emailValidator();
		matcher = pattern.matcher(email);
		if( matcher.matches())
			return true;
		return false;
	}
	public boolean isValidCustomerType(String customerType){
		ArrayList<String> customerTypeList = new ArrayList<String>();
		customerTypeList.add("endUser");
		customerTypeList.add("Student");
		customerTypeList.add("ServiceProider");
		if (!customerType.contentEquals(customerType))
			return true;
		return false;
	}

	public boolean isValidData(String data){
		if(null!=data && data.trim().length()>0)
			return true;
		return false;
	}
	
	public boolean isValidInteger(String data){
		try{
			Integer.parseInt(data);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}
	
	public boolean isValidRowCount(String data){
		try{
			if(Integer.parseInt(data)>0){
				return true;
			}
		}catch(Exception  e){
			
		}
		return false;
	}
	
	public boolean isValidStartIndex(String data){
		try{
			if(Integer.parseInt(data)>=0){
				return true;
			}
		}catch(Exception  e){
			
		}
		return false;
	}
}
