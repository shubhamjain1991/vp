package com.vp.validator;

public abstract class Validator {

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
