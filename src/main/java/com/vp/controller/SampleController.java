package com.vp.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vp.constant.ApplicationConstant;

@Controller
@RequestMapping("/sample")
public class SampleController {

	private static final Logger LOGGER = Logger.getLogger(SampleController.class);

	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public ResponseEntity<String> example() {
		LOGGER.info("In SampleController Calling example Method");
		LOGGER.info("Environment :::: " + ApplicationConstant.ENVIRONMENT);
		LOGGER.info("Master DB :::: " + ApplicationConstant.MASTER_DB);
		LOGGER.info("Slave DB :::: " + ApplicationConstant.SLAVE_DB);
		return new ResponseEntity<String>("Hurray! You First Spring JPA(Hibernate) Web Service Is Working Just Fine.",
				HttpStatus.OK);
	}
}
