package com.vp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vp.enity.ApplicationForm;

@Repository
@SuppressWarnings("unchecked")
public class ApplicationFormDAOImpl implements ApplicationFormDAO{

private static final Logger LOGGER = Logger.getLogger(ApplicationFormDAOImpl.class);
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	@Override
	public List<ApplicationForm> findByAfSpId(Long afSpId) {
		List<ApplicationForm> applicationForms = null;
		Query query = null;
		try{
			LOGGER.info("Find ApplicationForms By AfSpId :::: "+afSpId);
			query = entityManager.createQuery("SELECT af FROM ApplicationForm af WHERE af.serviceProvider.spId="+afSpId);
			applicationForms = (List<ApplicationForm>) query.getSingleResult();
			LOGGER.info("Find ApplicationForms By AfSpId :::: "+afSpId+" Success");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Find ApplicationForms By AfSpId :::: "+afSpId+" Failed");
		}finally{
			LOGGER.info("Find ApplicationForms By AfSpId :::: "+afSpId+" Finished");
		}
		return applicationForms;
	}

	@Override
	public List<ApplicationForm> findByAfCustomerId(Long afCustomerId) {
		List<ApplicationForm> applicationForms = null;
		Query query = null;
		try{
			LOGGER.info("Find ApplicationForms By AfCustomerId :::: "+afCustomerId);
			query = entityManager.createQuery("SELECT af FROM ApplicationForm af WHERE af.customerProfile.cpId="+afCustomerId);
			applicationForms = (List<ApplicationForm>) query.getSingleResult();
			LOGGER.info("Find ApplicationForms By AfCustomerId :::: "+afCustomerId+" Success");
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.info("Find ApplicationForms By AfCustomerId :::: "+afCustomerId+" Failed");
		}finally{
			LOGGER.info("Find ApplicationForms By AfCustomerId :::: "+afCustomerId+" Finished");
		}
		return applicationForms;
	}

}
