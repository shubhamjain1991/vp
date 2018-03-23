package com.vp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vp.enity.CustomerProfile;

@Repository
public class CustomerProfileDAOImpl implements CustomerProfileDAO{

	private static final Logger LOGGER = Logger.getLogger(CustomerProfileDAOImpl.class);
	
	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerProfile> findAll(int startIndex, int rowCount) {
		List<CustomerProfile> customerProfiles = null;
		Query query = null;
		try{
			LOGGER.info("Find All Customer Profiles :::: ");
			query = entityManager.createQuery("SELECT cp FROM CustomerProfile cp");
			query.setFirstResult(startIndex); 
			query.setMaxResults(rowCount);
			customerProfiles = (List<CustomerProfile>) query.getResultList();
			LOGGER.info("Find All Customer Profiles Success :::: ");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Find All Customer Profiles Failed :::: ");
		}finally{
			LOGGER.info("Find All Customer Profiles Finished :::: ");
		}
		return customerProfiles;
	}
	
}
