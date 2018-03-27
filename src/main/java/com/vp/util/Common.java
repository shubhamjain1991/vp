package com.vp.util;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vp.enity.MessageCode;

@Component
public class Common  {
	
	private boolean isValid;
	
	private HashSet<MessageCode> messageCode ;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public HashSet<MessageCode> getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(HashSet<MessageCode> messageCode) {
		this.messageCode = messageCode;
	}
	

}
