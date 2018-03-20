package com.vp.init;

import org.apache.log4j.Logger;

import com.vp.constant.ApplicationConstant;

public class Init {

	private static final Logger LOGGER = Logger.getLogger(Init.class);
	
	private String env;
	private String masterDB;
	private String slaveDB;
	
	public void initialize(){
		LOGGER.info("Inittializing Application With Environment :::: "+env);
		ApplicationConstant.ENVIRONMENT=env;
		ApplicationConstant.MASTER_DB=masterDB;
		ApplicationConstant.SLAVE_DB=slaveDB;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getMasterDB() {
		return masterDB;
	}

	public void setMasterDB(String masterDB) {
		this.masterDB = masterDB;
	}

	public String getSlaveDB() {
		return slaveDB;
	}

	public void setSlaveDB(String slaveDB) {
		this.slaveDB = slaveDB;
	}
	
	
}
