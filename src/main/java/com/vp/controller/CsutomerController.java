package com.vp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vp.bean.CustomerApplicationFormBean;
import com.vp.bean.CustomerResponseBean;
import com.vp.bean.RegistrartionFromBean;
import com.vp.service.CustomerProfileService;
import com.vp.validator.CustomerValidator;

@Controller
@RequestMapping("/customer")
public class CsutomerController {

	private static final Logger LOGGER = Logger.getLogger(SampleController.class);

	@Autowired
	CustomerProfileService customerProfileService;

	@RequestMapping(value = "/{startIndex}/{rowCount}", method = RequestMethod.GET)
	public ResponseEntity<CustomerResponseBean> customerProfiles(@PathVariable("startIndex") String startIndex,
			@PathVariable("rowCount") String rowCount) {
		LOGGER.info("Finding all the customer form :::: " + startIndex + " count :::: " + rowCount);
		CustomerResponseBean responseBean = CustomerValidator.getInstance().validateCustomerProfiles(startIndex, rowCount);
		if(null != responseBean){
			return new ResponseEntity<CustomerResponseBean>(responseBean, HttpStatus.OK);
		}
		responseBean = customerProfileService.customerProfiles(Integer.parseInt(startIndex), Integer.parseInt(rowCount));
		return new ResponseEntity<CustomerResponseBean>(responseBean,HttpStatus.OK);
	}
	
	@RequestMapping("/createProfile")
	public ResponseEntity<RegistrartionFromBean> putCustomerProfile(RegistrartionFromBean registrartionFromBean){
		
		LOGGER.info("Validating the customer Registrartion form");
		RegistrartionFromBean responseBean = CustomerValidator.getInstance().validateRegistrationForm(registrartionFromBean);
		if(responseBean != null){
			return new ResponseEntity<RegistrartionFromBean>(responseBean , HttpStatus.OK);
		}
		LOGGER.info("Inserting the customer Registrartion form");
		responseBean = customerProfileService.putCustomerDetais(registrartionFromBean);
		return new ResponseEntity<RegistrartionFromBean>(responseBean , HttpStatus.OK);
	}
	
	@RequestMapping("/updateProfile")
	public ResponseEntity<RegistrartionFromBean> updateCustomerProfile(RegistrartionFromBean registrartionFromBean){
		LOGGER.info("Validating the customer Registrartion form");
		RegistrartionFromBean responseBean = CustomerValidator.getInstance().validateRegistrationForm(registrartionFromBean);
		if(responseBean != null){
			return new ResponseEntity<RegistrartionFromBean>(responseBean , HttpStatus.OK);
		}
		return null;	
	}
	
	@RequestMapping("/deleteProfile")
	public ResponseEntity<RegistrartionFromBean> deleteCustomerProfile(RegistrartionFromBean registrartionFromBean){
		return null;	
	}
	
	@RequestMapping("/login")
	public ResponseEntity<RegistrartionFromBean> viewCustomerProfile(RegistrartionFromBean registrartionFromBean){
		LOGGER.info("Validating the customer login form");
		RegistrartionFromBean responseBean = CustomerValidator.getInstance().validateLoginForm(registrartionFromBean);
		if(null!=responseBean){
			LOGGER.info("customer login form details not valid");
			return new ResponseEntity<RegistrartionFromBean>(responseBean , HttpStatus.OK);
		}
		return null;		
	}
	
	@RequestMapping("/applicationForm")
	public ResponseEntity<CustomerApplicationFormBean> createCustomerAppointment(CustomerApplicationFormBean customerApplicationFormBean){
		CustomerApplicationFormBean responseBean = null;
		LOGGER.info("Validating CustomerApplicationFrom");
		responseBean = CustomerValidator.getInstance().validateCustomerApplicationForm(customerApplicationFormBean);
		if(responseBean!=null){
			return new ResponseEntity<CustomerApplicationFormBean>(responseBean , HttpStatus.OK);
		} 
		responseBean = customerProfileService.createCustomerAppointment(customerApplicationFormBean);
		return null;
	}

}
