package com.vp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vp.enity.AddressDetails;

@Repository
@SuppressWarnings("unchecked")
public class AddressDAOImpl implements AddressDAO{

	private static final Logger LOGGER = Logger.getLogger(AddressDAOImpl.class);
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public AddressDetails findByAddrId(Long addrId) {
		AddressDetails addressDetails = null;
		Query query = null;
		try{
			LOGGER.info("Find AddressDetails By AddrId :::: "+addrId);
			query = entityManager.createQuery("SELECT ad FROM AddressDetails ad WHERE ad.addrId="+addrId);
			addressDetails = (AddressDetails) query.getSingleResult();
			LOGGER.info("Find AddressDetails By AddrId :::: "+addrId+" Success");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Find AddressDetails By AddrId :::: "+addrId+" Failed");
		}finally{
			LOGGER.info("Find AddressDetails By AddrId :::: "+addrId+" Finished");
		}
		return addressDetails;
	}

	
	@Override
	public List<AddressDetails> findByAddrCustomerId(Long addrCustomerId) {
		List<AddressDetails> addressDetails = null;
		Query query = null;
		try{
			LOGGER.info("Find AddressDetails By AddrCustomerId :::: "+addrCustomerId);
			query = entityManager.createQuery("SELECT ad FROM AddressDetails ad WHERE ad.customerProfile.cpId="+addrCustomerId);
			addressDetails = (List<AddressDetails>) query.getResultList();
			LOGGER.info("Find AddressDetails By AddrCustomerId :::: "+addrCustomerId+" Success");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Find AddressDetails By AddrCustomerId :::: "+addrCustomerId+" Failed");
		}finally{
			LOGGER.info("Find AddressDetails By AddrCustomerId :::: "+addrCustomerId+" Finished");
		}
		return addressDetails;
	}
}
