package com.vp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vp.enity.MessageCode;

@Repository
@SuppressWarnings("unchecked")
public class MessageCodeDAOImpl implements MessageCodeDAO{

private static final Logger LOGGER = Logger.getLogger(MessageCodeDAOImpl.class);
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public List<MessageCode> finAll() {
		List<MessageCode> messageCodes = null;
		Query query = null;
		try{
			LOGGER.info("Getting All Message Codes ::::");
			query = entityManager.createQuery("SELECT mc FROM MessageCode mc");
			messageCodes = (List<MessageCode>) query.getResultList();
			LOGGER.info("Getting All Message Codes Success ::::");
		}catch(Exception e){
			LOGGER.info("Getting All Message Codes Failed ::::");
		}finally{
			LOGGER.info("Getting All Message Codes Finished ::::");
		}
		return messageCodes;
	}

}
