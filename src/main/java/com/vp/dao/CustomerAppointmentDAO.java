package com.vp.dao;

import com.vp.bean.CustomerApplicationFormBean;

public interface CustomerAppointmentDAO {
	
	public boolean isTimeSlotFree(String timeSlot , String serviceProviderId , String userID);
	public boolean  createCustomerAppointment(CustomerApplicationFormBean customerApplicationFormBean);

}
