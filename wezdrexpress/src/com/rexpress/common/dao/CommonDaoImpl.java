package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CommonDaoImpl<ENTITY, PK> extends CrudDaoImpl<ENTITY, PK> {

	private static final Logger logger = LogManager.getLogger(CommonDaoImpl.class);
	
    private static   EntityManagerFactory emf;
    
	private static EntityManager em;
	
	static {
	logger.debug("emf=Persistence.createEntityManagerFactory(rexpressPU);");
	try{
	emf=Persistence.createEntityManagerFactory("rexpressPU");
	}catch (JDBCConnectionException e) {
		logger.debug(e.getMessage());
	}
	 //SET GLOBAL time_zone = '-3:00';//
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		em=emf.createEntityManager();
		logger.debug(">>>>>>>Creando EntityManager Static");
		return em;
	}

}
