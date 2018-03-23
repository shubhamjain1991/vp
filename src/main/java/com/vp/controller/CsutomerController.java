package com.vp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vp.bean.CustomerResponseBean;
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

}
