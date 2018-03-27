package com.vp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.vp.bean.CustomerApplicationFormBean;

@Repository
public class CustomerAppointmentDAOImpl implements CustomerAppointmentDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public boolean isTimeSlotFree(String timeSlot, String serviceProviderId , String userID  ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createCustomerAppointment(CustomerApplicationFormBean customerApplicationFormBean) {
		// TODO Auto-generated method stub
		return false;
	}

}
