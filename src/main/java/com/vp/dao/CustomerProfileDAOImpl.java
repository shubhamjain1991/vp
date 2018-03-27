package com.vp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vp.bean.CustomerApplicationFormBean;
import com.vp.bean.RegistrartionFromBean;
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

	@Override
	public boolean putCustomerDetails(RegistrartionFromBean registrartionFromBean) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean findByEmail(String email){
		return false;
	}	
	public boolean findByMobile(String mobile){
		return false;
	}
	public boolean findByUserName(String userName){
		return false;
	}
	
	@SuppressWarnings("finally")
	public boolean findExistingUser(String email , String mobile , String userName){
		Query query = null;
		int dbResults = 0;
		try{
			LOGGER.info("Find Customer Profile for <---Email--->"+email + "<---mobile--->"+mobile+"<---userName--->"+userName);
			query = entityManager.createQuery("SELECT cp FROM CustomerProfile cp where cp.cpEmail= "+email+" or cp.cpMobile = "+mobile+"or cp.cpUserName= "+userName);
			dbResults = query.getResultList().size();
			LOGGER.info("Record found for <---Email--->"+email + "<---mobile--->"+mobile+"<---userName--->"+userName);
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Query Execution Failed "+query.toString());
		}finally{
			LOGGER.info("Record found for <---Email--->"+email + "<---mobile--->"+mobile+"<---userName--->"+userName);
			if(dbResults>0){
				return false;
			}else{
				return true;
			}
		}
	}
	
	public CustomerProfile userLogin(String userName , String password){
		Query query = null;
		CustomerProfile customerProfile = null;
		try{
			LOGGER.info("Find Customer Profile for <---userName--->"+userName );
			query = entityManager.createQuery("Select cp from CustomerProfile where cp.cpUserName= "+userName+"and cpPwd="+password);
			customerProfile = (CustomerProfile) query.getResultList();	
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Query Execution Failed "+query.toString());	
		}finally{
			LOGGER.info("Query Execution Success "+query.toString());
		}
		return customerProfile;
	}

	
}
